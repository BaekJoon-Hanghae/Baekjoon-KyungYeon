package level5_문자열.Q11718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if(str == null) {
                break;
            }
            sb.append(str).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}