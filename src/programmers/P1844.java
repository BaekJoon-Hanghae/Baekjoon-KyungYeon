package programmers;

import java.util.PriorityQueue;

class P1844 {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(1,0,0));

        while(!pq.isEmpty() && answer == 0) {
            Point now = pq.poll();
            int distance = now.distance + 1;

            for(int i=0; i<4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx >= 0 && ny >=0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    if(nx == n-1 && ny == m-1) {
                        answer = distance;
                        break;
                    }
                    maps[nx][ny] = 0;
                    pq.add(new Point(distance, nx, ny));
                }
            }
        }

        return answer == 0 ? -1 : answer;
    }
}

class Point implements Comparable<Point> {
    int distance;
    int x;
    int y;

    Point(int distance, int x, int y) {
        this.distance = distance;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point o) {
        return this.distance - o.distance;
    }
}