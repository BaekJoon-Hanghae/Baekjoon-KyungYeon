package level8_일반수학1.Q2720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] coin = new int[]{25, 10, 5, 1};
        int[] result;
        int change;

        for (int i = 0; i < t; i++) {
            change = Integer.parseInt(br.readLine());
            result = new int[coin.length];
            int index = 0;

            while (change != 0) {
                result[index] = change / coin[index];
                change %= coin[index];
                index++;
            }

            for (int j : result) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}