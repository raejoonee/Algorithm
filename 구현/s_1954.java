import java.util.*;
 
public class Solution {
    static int[][] snail;
    static int n;
    static int count;
    static final int[][] MOVE = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
     
    public static void move(int x, int y, int direction, int start) {
        if (x < 0 || y >= n || snail[x][y] != 0) return ;
        if (x == start && y == n-1-start && direction == 0) move(x, y, direction+1, start);
        else if (x == n-1-start && y == n-1-start && direction == 1) move(x, y, direction+1, start);
        else if (x == n-1-start && y == start && direction == 2) move(x, y, direction+1, start);
        else {
            snail[x][y] = count;
            count++;
            move(x+MOVE[direction][0], y+MOVE[direction][1], direction, start);
        }
        return ;
    }
     
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            snail = new int[n][n];
            count = 1;
            move(0, 0, 0, 0);
            for (int j = 1; j < n; j++)
                if (snail[j][j] == 0) move(j, j, 0, j);
            System.out.printf("#%d\n", i+1);
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    System.out.printf("%d ", snail[a][b]);
                }
                System.out.println();
            }
            count = 0;  
        }
         
        sc.close();
    }
}
