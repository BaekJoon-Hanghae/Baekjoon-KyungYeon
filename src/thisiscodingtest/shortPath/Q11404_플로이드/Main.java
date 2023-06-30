package thisiscodingtest.shortPath.Q11404_플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] distance = new int[n + 1][n + 1];
        StringTokenizer st;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                distance[i][j] = 123456789;
            }
            distance[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            distance[start][to] = Math.min(distance[start][to], dist);
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 1; k < n+1; k++) {
                    if (i == k) {
                        continue;
                    }
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (distance[i][j] == 123456789) {
                    sb.append(0);
                }else {
                    sb.append(distance[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}