package level6_심화1.Q2444;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < 2 * n; i++) {
            int abs = Math.abs(n - i);
            for (int j = 0; j < abs; j++) {
                sb.append(" ");
            }
            for (int j = abs; j <= 2 * n - abs - 2; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}