package level4_1차원배열.Q5597;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[31];
        for (int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[n] = true;
        }

        for (int i = 1; i < 31; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}