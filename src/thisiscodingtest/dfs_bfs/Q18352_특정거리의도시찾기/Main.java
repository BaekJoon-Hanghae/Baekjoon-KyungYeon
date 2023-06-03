package thisiscodingtest.dfs_bfs.Q18352_특정거리의도시찾기;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            distance[i] = -1;
        }
        int[][] road = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            road[i][0] = Integer.parseInt(st.nextToken());
            road[i][1] = Integer.parseInt(st.nextToken());
        }

        distance[x] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            int start = q.poll();

            for (int i = 0; i < m; i++) {
                if (road[i][0] == start && distance[road[i][1]] == -1) {
                    if (distance[start] + 1 == k) {
                        sb.append(road[i][1]).append("\n");
                    } else {
                        distance[road[i][1]] = distance[start] + 1;
                        q.add(road[i][1]);
                    }
                }
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }
        System.out.println(sb);
        br.close();
    }
}
