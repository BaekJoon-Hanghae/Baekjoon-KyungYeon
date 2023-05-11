package level9_약수와배수와소수.Q9506;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        int sum;
        List<Integer> numberList;

        while ((n = Integer.parseInt(br.readLine())) != -1) {
            numberList = new ArrayList<>();
            sum = 1;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    numberList.add(i);
                    sum += i;
                    if (n / i != i) {
                        numberList.add(n / i);
                        sum += n / i;
                    }
                }
            }

            if (sum == n) {
                Collections.sort(numberList);
                sb.append(n).append(" = 1");
                for (Integer integer : numberList) {
                    sb.append(" + ").append(integer);
                }
            } else {
                sb.append(n).append(" is NOT perfect.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}