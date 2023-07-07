package thisiscodingtest.graph.b3665_최종순위;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] score = new int[n + 1];
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < n + 1; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }

            boolean[][] graph = new boolean[n + 1][n + 1];
            int[] indegree = new int[n + 1];

            for (int j = 1; j < n + 1; j++) {
                for (int k = j + 1; k < n + 1; k++) {
                    graph[score[j]][score[k]] = true;
                    indegree[score[k]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;
                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[a][b] = true;
                    graph[b][a] = false;
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            Queue<Integer> q = new LinkedList<>();

            for (int j = 1; j < n + 1; j++) {
                if (indegree[j] == 0) {
                    q.add(j);
                }
            }

            boolean cycle = false;
            boolean query = false;

            for (int j = 1; j < n + 1; j++) {
                if (q.size() == 0) {
                    cycle = true;
                    break;
                }

                if (q.size() > 1) {
                    query = true;
                    break;
                }

                int now = q.poll();
                score[j] = now;
                for (int k = 1; k < n + 1; k++) {
                    if (graph[now][k]) {
                        if (--indegree[k] == 0) {
                            q.add(k);
                        }
                    }
                }
            }
            if(cycle) {
                sb.append("IMPOSSIBLE");
            }else if(query) {
                sb.append("?");
            }else {
                for (int j = 1; j < n+1; j++) {
                    sb.append(score[j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}