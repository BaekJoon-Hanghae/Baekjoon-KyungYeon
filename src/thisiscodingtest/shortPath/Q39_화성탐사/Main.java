package thisiscodingtest.shortPath.Q39_화성탐사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//3
//3
//5 5 4
//3 9 1
//3 2 7
//5
//3 7 2 0 1
//2 8 0 9 1
//1 2 1 8 1
//9 8 9 2 0
//3 6 5 1 5
//7
//9 0 5 1 1 5 3
//4 1 2 1 6 5 3
//0 7 6 1 6 8 5
//1 1 7 8 3 2 3
//9 4 0 7 6 4 1
//5 8 3 2 4 8 3
//7 4 8 4 8 3 4

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] distance = new int[n][n];
            distance[0][0] = arr[0][0];
            int result = 0;

            PriorityQueue<Fuel> pq = new PriorityQueue<>();
            pq.add(new Fuel(arr[0][0], 0, 0));

            while (result == 0 && !pq.isEmpty()) {
                Fuel fuel = pq.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = fuel.x + dx[j];
                    int ny = fuel.y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if( distance[nx][ny] == 0) {
                            int next_fuel = fuel.fuel + arr[nx][ny];
                            distance[nx][ny] = next_fuel;

                            if (nx == n - 1 && ny == n - 1) {
                                result = next_fuel;
                                break;
                            }
                            pq.add(new Fuel(next_fuel, nx, ny));
                        }
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}

class Fuel implements Comparable<Fuel> {
    int fuel;
    int x;
    int y;

    Fuel(int fuel, int x, int y) {
        this.fuel = fuel;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Fuel o) {
        return this.fuel - o.fuel;
    }
}