package thisiscodingtest.dfs_bfs.Q14888_연산자끼워넣기;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int min;
    static int max;
    static int[] number;
    static int[] calculator;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        calculator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calculator[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[n - 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(0);

        sb.append(max).append("\n").append(min);
        System.out.println(sb);
        br.close();
    }

    static void dfs(int depth) {
        if (depth == n - 1) {
            int result = calculate();
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (calculator[i] > 0) {
                arr[depth] = i;
                calculator[i]--;
                dfs(depth + 1);
                calculator[i]++;
            }
        }
    }

    static int calculate() {
        int result = number[0];

        for (int i = 0; i < n - 1; i++) {
            int calc = arr[i];
            int num = number[i + 1];

            if (calc == 0) {
                result += num;
            } else if (calc == 1) {
                result -= num;
            } else if (calc == 2) {
                result *= num;
            } else {
                result /= num;
            }
        }
        return result;
    }
}