package thisiscodingtest.graph.Q43_어두운길;

import java.io.*;
import java.util.*;

//7 11
//0 1 7
//0 3 5
//1 2 8
//1 3 9
//1 4 7
//2 4 5
//3 4 15
//3 5 6
//4 5 8
//4 6 9
//5 6 11

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Road> pq = new PriorityQueue<>();
        int total = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            pq.add(new Road(start, to, distance));
            total += distance;
        }

        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int count = 0;
        int result = 0;
        while (count < n && !pq.isEmpty()) {
            Road road = pq.poll();

            System.out.println("road.start = " + road.start);
            System.out.println("road.to = " + road.to);
            System.out.println("road.distance = " + road.distance);
            System.out.println("findParent(road.start) = " + findParent(road.start));
            System.out.println("findParent(road.to) = " + findParent(road.to));
            System.out.println();

            if (findParent(road.start) != findParent(road.to)) {
                unionParent(road.start, road.to);
                result += road.distance;
                count++;
            }
        }

        sb.append(total - result);
        System.out.println(sb);
        br.close();
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static int findParent(int num) {
        if (parent[num] != num) {
            parent[num] = findParent(parent[num]);
        }
        return parent[num];
    }
}

class Road implements Comparable<Road> {
    int start;
    int to;
    int distance;

    public Road(int start, int to, int distance) {
        this.start = start;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public int compareTo(Road o) {
        return this.distance - o.distance;
    }
}