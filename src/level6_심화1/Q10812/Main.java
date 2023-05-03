package level6_심화1.Q10812;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] arr_clone = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
            arr_clone[i] = i;
        }

        for (int a = 0; a < m; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int b = i; b <= i + j - k; b++) {
                arr[b] = arr_clone[b + k - i];
            }

            for (int b = i + j - k + 1; b <= j; b++) {
                arr[b] = arr_clone[b - j + k - 1];
            }

            arr_clone = arr.clone();
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}