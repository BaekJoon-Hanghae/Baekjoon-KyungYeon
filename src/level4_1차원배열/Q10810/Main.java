package level4_1차원배열.Q10810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            for (int j = start; j < end + 1; j++) {
                arr[j] = number;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}