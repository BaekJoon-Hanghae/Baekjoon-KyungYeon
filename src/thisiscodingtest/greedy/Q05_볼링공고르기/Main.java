package thisiscodingtest.greedy.Q05_볼링공고르기;

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

        int[] ball = new int[n];
        int[] weight = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ball[i] = Integer.parseInt(st.nextToken());
            weight[ball[i]]++;
        }

        int result = 0;
        for (int i = 1; i < m + 1; i++) {
            if(weight[i] != 0) {
                result += weight[i] * (n - weight[i]);
            }
        }

        sb.append(result/2);
        System.out.println(sb);
        br.close();
    }
}