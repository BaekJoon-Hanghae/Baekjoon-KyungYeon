package thisiscodingtest.dynamic.Q1932_정수삼각형;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[i + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (n != 1) {
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < i + 1; j++) {
                    arr[i][j] = arr[i][j] + Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
                }
            }
        }

        sb.append(arr[0][0]);
        System.out.println(sb);
        br.close();
    }
}