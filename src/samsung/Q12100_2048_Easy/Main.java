package samsung.Q12100_2048_Easy;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int max = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] > max) {
                    max = board[i][j];
                }
            }
        }

        move(board, 0);

        sb.append(max);
        System.out.println(sb);
        br.close();
    }

    static void move(int[][]board, int count) {

        if(count == 5) {
            return;
        }

        int[][] clone = new int[n][n];

        for(int k=0; k<4; k++) {

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    clone[i][j] = board[i][j];
                }
            }

            if(k == 0) {
                for(int j=0; j<n; j++) {
                    int cnt = 0;

                    for(int i=1; i<n; i++) {
                        if(clone[i][j] != 0) {
                            if(clone[cnt][j] == 0) {
                                clone[cnt][j] = clone[i][j];
                                clone[i][j] = 0;
                            }else {
                                if(clone[cnt][j] == clone[i][j] && clone[i][j] > 0) {
                                    max = Math.max(max, clone[i][j] * 2);
                                    clone[cnt][j] = clone[i][j]*2;
                                    clone[i][j] = 0;
                                    cnt++;
                                }else {
                                    cnt++;
                                    if(i != cnt) {
                                        clone[cnt][j] = clone[i][j];
                                        clone[i][j] = 0;
                                    }
                                }
                            }
                        }
                    }
                }

                move(clone, count+1);
            }

            if(k == 1) {
                for(int j=0; j<n; j++) {
                    int cnt = n-1;

                    for(int i=n-2; i>=0; i--) {
                        if(clone[i][j] != 0) {
                            if(clone[cnt][j] == 0) {
                                clone[cnt][j] = clone[i][j];
                                clone[i][j] = 0;
                            }else {
                                if(clone[cnt][j] == clone[i][j] && clone[i][j] > 0) {
                                    max = Math.max(max, clone[i][j] * 2);
                                    clone[cnt][j] = clone[i][j]*2;
                                    clone[i][j] = 0;
                                    cnt--;
                                }else {
                                    cnt--;
                                    if(i != cnt) {
                                        clone[cnt][j] = clone[i][j];
                                        clone[i][j] = 0;
                                    }
                                }
                            }
                        }
                    }
                }

                move(clone, count+1);
            }

            if(k == 2) {
                for(int i=0; i<n; i++) {
                    int cnt = 0;

                    for(int j=1; j<n; j++) {
                        if(clone[i][j] != 0) {
                            if(clone[i][cnt] == 0) {
                                clone[i][cnt] = clone[i][j];
                                clone[i][j] = 0;
                            }else {
                                if(clone[i][cnt] == clone[i][j] && clone[i][j] > 0) {
                                    max = Math.max(max, clone[i][j] * 2);
                                    clone[i][cnt] = clone[i][j]*2;
                                    clone[i][j] = 0;
                                    cnt++;
                                }else {
                                    cnt++;
                                    if(j != cnt) {
                                        clone[i][cnt] = clone[i][j];
                                        clone[i][j] = 0;
                                    }
                                }
                            }
                        }
                    }
                }

                move(clone, count+1);
            }

            if(k == 3) {
                for(int i=0; i<n; i++) {
                    int cnt = n-1;

                    for(int j=n-2; j>=0; j--) {
                        if(clone[i][j] != 0) {
                            if(clone[i][cnt] == 0) {
                                clone[i][cnt] = clone[i][j];
                                clone[i][j] = 0;
                            }else {
                                if(clone[i][cnt] == clone[i][j] && clone[i][j] > 0) {
                                    max = Math.max(max, clone[i][j] * 2);
                                    clone[i][cnt] = clone[i][j]*2;
                                    clone[i][j] = 0;
                                    cnt--;
                                }else {
                                    cnt--;
                                    if(j != cnt) {
                                        clone[i][cnt] = clone[i][j];
                                        clone[i][j] = 0;
                                    }
                                }
                            }
                        }
                    }
                }

                move(clone, count+1);
            }
        }
    }
}