package thisiscodingtest.greedy.Q04_만들수없는금액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] coin = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coin);

        if (coin[0] != 1) {
            sb.append(1);
        } else {
            int sum = coin[0];
            for (int i = 1; i < n; i++) {
                if (sum < coin[i] - 1) {
                    break;
                }
                sum += coin[i];
            }
            sb.append(sum + 1);
        }

        System.out.println(sb);
        br.close();
    }
}