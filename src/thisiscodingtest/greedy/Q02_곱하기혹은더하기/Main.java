package thisiscodingtest.greedy.Q02_곱하기혹은더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(result <= 1 || num <= 1) {
                result += num;
            }else {
                result *= num;
            }
        }

        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}