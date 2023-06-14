package thisiscodingtest.sorting.Q10825_국영수;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Score> scoreList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            scoreList.add(new Score(name, kor, eng, math));
        }

        Collections.sort(scoreList);

        for (Score score : scoreList) {
            sb.append(score.name).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

class Score implements Comparable<Score>{
    String name;
    int kor;
    int eng;
    int math;

    Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Score o) {
        if(this.kor != o.kor) {
            return o.kor - this.kor;
        }

        if(this.eng != o.eng) {
            return this.eng - o.eng;
        }

        if(this.math != o.math) {
            return o.math - this.math;
        }

        return this.name.compareTo(o.name);
    }
}