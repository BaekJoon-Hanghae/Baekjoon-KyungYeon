package dfs_bfs.Q14502_연구소;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] clone;
    static int max;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        clone = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        dfs(map, 0, 0);
        sb.append(max);

        System.out.println(sb);
        br.close();
    }

    static void dfs(int[][] map, int depth, int now) {
        if (depth == 3) {
            int count = countSafe(map);
            if (count > max) {
                max = count;
            }
            return;
        }

        for (int i = now; i < n * m; i++) {
            int x = i / m;
            int y = i % m;
            if (map[x][y] == 0) {
                map[x][y] = 1;
                dfs(map, depth + 1, i + 1);
                map[x][y] = 0;
            }
        }
    }

    static int countSafe(int[][] map) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            clone[i] = map[i].clone();
            for (int j = 0; j < m; j++) {
//                System.out.print(map[i][j]);
//                System.out.print(" ");
                if (map[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
//            System.out.println();
        }
//        System.out.println();

        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && clone[nx][ny] == 0) {
                    clone[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (clone[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }
}