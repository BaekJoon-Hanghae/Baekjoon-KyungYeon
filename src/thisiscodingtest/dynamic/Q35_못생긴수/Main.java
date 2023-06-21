package thisiscodingtest.dynamic.Q35_못생긴수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(ugly[index2] * 2, ugly[index3] * 3), ugly[index5] * 5);
            if (ugly[i] == ugly[index2] * 2) {
                index2++;
            }
            if (ugly[i] == ugly[index3] * 3) {
                index3++;
            }
            if (ugly[i] == ugly[index5] * 5) {
                index5++;
            }
            System.out.println(ugly[i]);
        }

        sb.append(ugly[n - 1]);
        System.out.println(sb);
        br.close();
    }
}