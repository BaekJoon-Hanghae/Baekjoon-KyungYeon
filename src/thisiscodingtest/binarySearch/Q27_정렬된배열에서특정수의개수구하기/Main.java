package thisiscodingtest.binarySearch.Q27_정렬된배열에서특정수의개수구하기;

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
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;
        int mid = 0;
        boolean confirm = false;
        int result = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == x && (mid == 0 || arr[mid - 1] != x)) {
                confirm = true;
                break;
            }

            if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (confirm) {
            for (int i = mid; i < n; i++) {
                if (arr[i] != x) {
                    break;
                }
                result++;
            }
            sb.append(result);
        }else {
            sb.append(-1);
        }

        System.out.println(sb);
        br.close();
    }
}