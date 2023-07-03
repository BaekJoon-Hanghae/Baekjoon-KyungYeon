package thisiscodingtest.graph.Q42_탑승구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        int[] arr = new int[p];
        for (int i = 0; i < p; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        parent = new int[g + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[i] = " + arr[i]);
            int fp = findParent(arr[i]);
            if (fp == 0) {
                break;
            }

            System.out.println("findParent(arr[i]) = ");
            for (int j = 0; j < parent.length; j++) {
                System.out.println("parent[j] = " + parent[j]);
            }
            
            unionParent(fp, fp-1);

            System.out.println("unionParent(arr[i], arr[i]-1); = ");
            for (int j = 0; j < parent.length; j++) {
                System.out.println("parent[j] = " + parent[j]);
            }

            System.out.println();
            result++;
        }

        sb.append(result);
        System.out.println(sb);
        br.close();
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int findParent(int i) {
        if (parent[i] != i) {
            parent[i] = findParent(parent[i]);
        }
        return parent[i];
    }
}