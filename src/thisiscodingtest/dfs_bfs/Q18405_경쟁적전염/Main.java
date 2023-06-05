package thisiscodingtest.dfs_bfs.Q18405_경쟁적전염;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];
        PriorityQueue<Virus> pq = new PriorityQueue<>();

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    pq.add(new Virus(0, map[i][j], i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (sb.length() == 0 && !pq.isEmpty()) {
            Virus virus = pq.poll();

            if(virus.time == s) {
                sb.append(map[x][y]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (nx >= 1 && nx < n+1 && ny >= 1 && ny < n+1) {
                    if(map[nx][ny] == 0) {
                        map[nx][ny] = virus.number;
                        pq.add(new Virus(virus.time + 1, virus.number, nx, ny));
                    }

                    if (nx == x && ny == y) {
                        sb.append(map[x][y]);
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}

class Virus implements Comparable<Virus> {
    int time;
    int number;
    int x;
    int y;

    Virus(int time, int number, int x, int y) {
        this.time = time;
        this.number = number;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Virus o) {
        if (this.time == o.time) {
            return this.number - o.number;
        }
        return this.time - o.time;
    }
}