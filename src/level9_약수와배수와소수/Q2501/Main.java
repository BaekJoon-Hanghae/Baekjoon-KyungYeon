package level9_약수와배수와소수.Q2501;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        int count = 0;

        for (int i = 1; i <= a; i++) {
            if (a % i != 0) {
                continue;
            }

            if(++count == b) {
                result = i;
                break;
            }
        }
        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}