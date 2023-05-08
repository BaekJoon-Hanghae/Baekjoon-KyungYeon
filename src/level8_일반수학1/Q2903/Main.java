package level8_일반수학1.Q2903;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int length = 2;

        for (int i = 0; i < n; i++) {
            length = 2 * length - 1;
        }

        sb.append(length * length);
        System.out.println(sb);
        br.close();
    }
}