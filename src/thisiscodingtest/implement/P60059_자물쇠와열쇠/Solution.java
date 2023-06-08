package thisiscodingtest.implement.P60059_자물쇠와열쇠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int[][] largeLock;
    static int[][] largeKey;
    static boolean answer = false;

    public static boolean solution(int[][] key, int[][] lock) {
        largeLock = new int[lock.length + 2 * (key.length - 1)][lock.length + 2 * (key.length - 1)];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                largeLock[i + key.length - 1][j + key.length - 1] = lock[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            key = keyTurn(key);
            moveKey(key);
        }

        return answer;
    }

    static void moveKey(int[][] key) {
        if (answer) {
            return;
        }

        for (int i = 0; i <= largeLock.length - key.length; i++) {
            for (int j = 0; j <= largeLock.length - key.length; j++) {
                largeKey = new int[largeLock.length][largeLock.length];
                for (int k = 0; k < key.length; k++) {
                    for (int l = 0; l < key.length; l++) {
                        largeKey[i + k][j + l] = key[k][l];
                    }
                }
                unlock(largeKey, key.length);
            }
        }
    }

    static void unlock(int[][] largeKey, int length) {
        for (int i = length - 1; i <= largeKey.length - length; i++) {
            for (int j = length - 1; j <= largeKey.length - length; j++) {
                if (largeKey[i][j] == largeLock[i][j]) {
                    return;
                }
            }
        }
        answer = true;
    }

    static int[][] keyTurn(int[][] key) {
        int[][] after = new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                after[i][j] = key[j][key.length - i - 1];
            }
        }
        return after;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
        br.close();
    }
}