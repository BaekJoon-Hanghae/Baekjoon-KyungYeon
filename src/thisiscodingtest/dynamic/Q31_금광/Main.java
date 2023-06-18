package thisiscodingtest.dynamic.Q31_금광;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//        2
//        3 4
//        1 3 3 2 2 1 4 1 0 6 4 7
//        4 4
//        1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n * m; j++) {
                int x = j / m;
                int y = j % m;
                arr[x][y] = Integer.parseInt(st.nextToken());
            }

            int[][] gold = new int[n][m];
            for (int j = 0; j < n; j++) {
                gold[j][0] = arr[j][0];
            }

            for (int j = 1; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int temp = 0;
                    for (int l = Math.max(k - 1, 0); l <= Math.min(k + 1, n - 1); l++) {
                        temp = Math.max(gold[l][j - 1], temp);
                    }
                    gold[k][j] = arr[k][j] + temp;
                }

                if (j == m - 1) {
                    int max = 0;
                    for (int k = 0; k < n; k++) {
                        max = Math.max(max, gold[k][j]);
                    }
                    sb.append(max).append("\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}