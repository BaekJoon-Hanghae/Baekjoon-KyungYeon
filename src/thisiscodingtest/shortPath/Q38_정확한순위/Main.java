package thisiscodingtest.shortPath.Q38_정확한순위;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 플로이드 워셜 문제라고 한다.
//6 6
//1 5
//3 4
//4 2
//4 6
//5 2
//5 4

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] possible = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            possible[start][to] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j == i) {
                    continue;
                }

                for (int k = 1; k < n + 1; k++) {
                    if (k == i) {
                        continue;
                    }

                    possible[j][k] = possible[j][k] || (possible[j][i] && possible[i][k]);
                }
            }
        }

        for (int j = 1; j < n + 1; j++) {
            for (int k = 1; k < n + 1; k++) {
                System.out.print(possible[j][k] + " ");
            }
            System.out.println();
        }

        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            boolean confirm = true;
            for (int j = 1; j < n + 1; j++) {
                if(i == j) {
                    continue;
                }

                if (!possible[i][j] && !possible[j][i]) {
                    confirm = false;
                    break;
                }
            }

            if (confirm) {
                result++;
            }
        }

        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}