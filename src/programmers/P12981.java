package programmers;

import java.util.HashSet;

class P12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        char last = words[0].charAt(words[0].length() - 1);
        HashSet<String> hash = new HashSet<>();
        hash.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            char first = words[i].charAt(0);

            if (last != first || hash.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            hash.add(words[i]);
            last = words[i].charAt(words[i].length() - 1);
        }
        return answer;
    }
}
