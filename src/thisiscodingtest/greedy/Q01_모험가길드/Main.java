package thisiscodingtest.greedy.Q01_모험가길드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] fear = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            fear[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fear);

        int result = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < fear.length; i++) {
            list.add(fear[i]);
            if (list.size() >= fear[i]) {
                list.clear();
                result++;
            }
        }

        sb.append(result);
        System.out.println(sb);
        br.close();
    }
}