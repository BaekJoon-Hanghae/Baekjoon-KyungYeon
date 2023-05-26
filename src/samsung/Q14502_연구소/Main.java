package samsung.Q14502_연구소;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[][] clone;
    static int max;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        clone = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        block(0, 0);

        sb.append(max);
        System.out.println(sb);
        br.close();
    }

    static void block(int start, int depth) {

        if(depth == 3) {
            for(int i=0; i<n; i++) {
                clone[i] = map[i].clone();

                for(int j=0; j<m; j++) {
                    if(map[i][j] == 2) {
                        q.add(new int[] {i, j});
                    }
                }
            }

            while(!q.isEmpty()) {
                int[] a = q.poll();

                for(int i=0; i<4; i++) {
                    int x = a[0] + dx[i];
                    int y = a[1] + dy[i];

                    if(isIn(x, y)) {
                        if(clone[x][y] == 0) {
                            clone[x][y] = 2;
                            q.add(new int[] {x, y});
                        }
                    }
                }
            }

            int sum = 0;
            for(int i=0; i<n; i++) {
                sum += Arrays.stream(clone[i]).filter(a -> a == 0).count();
            }

            max = Math.max(max, sum);
            return;
        }

        for(int i=start; i<n*m; i++) {
            int x = i / m;
            int y = i % m;
            if(map[x][y] != 0) continue;

            map[x][y] = 1;
            block(i+1, depth+1);
            map[x][y] = 0;
        }
    }

    static boolean isIn(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}
