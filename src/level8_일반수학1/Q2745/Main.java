package level8_일반수학1.Q2745;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        int number;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (c >= '0' && c <= '9') {
                number = c - '0';
            } else {
                number = c - 'A' + 10;
            }
            result += number * Math.pow(b, n.length() - 1 - i);
        }

        // 이거면 끝나는 거였다.
//        result = Integer.parseInt(n, b);
        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}