package thisiscodingtest.sorting.Q18310_안테나;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] house = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);

        sb.append(house[(n-1)/2]);
        System.out.println(sb);
        br.close();
    }
}