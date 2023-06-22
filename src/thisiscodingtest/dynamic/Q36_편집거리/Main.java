package thisiscodingtest.dynamic.Q36_편집거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 생각한 사람은 천재일 것이다.
// 행 : a, 열 : b
// 오른쪽 이동 : 삽입, ex) s -> sa 만들기.
// 아래쪽 이동 : 삭제, ex) 생각도 어렵다.
// 대각선 이동 : 치환,
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        sb.append(dp[dp.length - 1][dp[0].length - 1]);
        System.out.println(sb);
        br.close();
    }
}