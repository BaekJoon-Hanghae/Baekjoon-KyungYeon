package level8_일반수학1.Q11005;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int number;
        while (n != 0) {
            number = n % b;
            n /= b;

            if (number >= 0 && number < 10) {
                sb.append(number);
            } else {
                sb.append((char) ('A' + number - 10));
            }
        }

        // 이거면 끝나는 거였다.
//        String result = Integer.toString(n, b).toUpperCase();
        sb.reverse();
        System.out.println(sb);
        br.close();
    }
}