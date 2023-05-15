package level13_정렬.Q2587;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> numberList = new ArrayList<>();
        int sum = 0;
        int number;
        for (int i = 0; i < 5; i++) {
            number = Integer.parseInt(br.readLine());
            sum += number;
            numberList.add(number);
        }
        Collections.sort(numberList);
        sb.append(sum/5).append("\n").append(numberList.get(2));

        System.out.println(sb);
        br.close();
    }
}