package thisiscodingtest.graph.Q41_여행계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//5 4
//0 1 0 1 1
//1 0 1 1 0
//0 1 0 0 0
//1 1 0 0 0
//1 0 0 0 0
//2 3 4 3

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int[] group = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            group[i] = i;
        }

        int[] city = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    group[j] = group[i];
                }
            }
            System.out.println("group[i] = " + group[i]);
        }

        boolean confirm = false;
        int g = group[city[0]];

        for (int i : city) {
            if(group[i] != g) {
                confirm = true;
                break;
            }
        }

        System.out.println(confirm ? "NO" : "YES");
        br.close();
    }
}