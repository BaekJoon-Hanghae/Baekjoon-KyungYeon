package level6_심화1.Q25206;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double hakjum = 0;
        double totalGrade = 0;

        StringTokenizer st;
        String[] arr = new String[3];

        for (int i = 0; i < 20; i++) {
            arr = br.readLine().split(" ");

            if (arr[2].charAt(0) == 'P') {
                continue;
            }

            hakjum += Double.parseDouble(arr[1]);
            double grade = 0;
            if (arr[2].charAt(0) != 'F') {
                grade = 'E' - arr[2].charAt(0);
                if (arr[2].charAt(1) == '+') {
                    grade += 0.5;
                }
            }
            totalGrade += Double.parseDouble(arr[1]) * grade;
        }

        sb.append(totalGrade / hakjum);
        System.out.println(sb);
        br.close();
    }
}