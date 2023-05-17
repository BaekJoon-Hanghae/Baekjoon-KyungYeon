package level14_집합과맵.Q7785;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String name;
        Set<String> nameSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();

            if (nameSet.contains(name)) {
                nameSet.remove(name);
            } else {
                nameSet.add(name);
            }
        }

        List<String> nameList = new ArrayList<>(nameSet);
        nameList.sort(Collections.reverseOrder());

        for (String s : nameList) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}