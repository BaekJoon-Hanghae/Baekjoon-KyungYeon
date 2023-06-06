package thisiscodingtest.dfs_bfs.Q18428_감시피하기;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[][] arr;
    static boolean result;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        dfs(0, 0);
        System.out.println(result ? "YES" : "NO");
        br.close();
    }

    static void dfs(int depth, int now) {
        if (result) {
            return;
        }

        if (depth == 3) {
            result = check();
            return;
        }

        for (int i = now; i < n * n; i++) {
            int x = i / n;
            int y = i % n;
            if (arr[x][y].equals("X")) {
                arr[x][y] = "O";
                dfs(depth + 1, i + 1);
                arr[x][y] = "X";
            }
        }
    }

    static boolean check() {
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].equals("T")) {
                    q.add(new int[]{i, j, 4});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < 4; i++) {
                if (point[2] == 4 || point[2] == i) {
                    int nx = point[0] + dx[i];
                    int ny = point[1] + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (arr[nx][ny].equals("S")) {
                            return false;
                        } else if (arr[nx][ny].equals("X")) {
                            q.add(new int[]{nx, ny, i});
                        }
                    }
                }
            }
        }
        return true;
    }
}