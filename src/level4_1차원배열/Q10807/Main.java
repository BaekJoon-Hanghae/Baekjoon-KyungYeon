package level4_1차원배열.Q10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (v == Integer.parseInt(st.nextToken())) {
                count++;
            }
        }

        sb.append(count);
        System.out.println(sb);
        br.close();
    }
}