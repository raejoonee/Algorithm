import java.io.*;
import java.util.*;

public class Main {
	static int[][] canvas;
	static int[][] director = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int N;
	static int M;
	static int R;
	static boolean starter = true;
	
	static int[] swap(int a, int b) {
		return new int[]{b, a};
	}
	
	static void rotate(int x, int y, int direction, int curNum, int start) {
		if (!starter && x == start && x == y) return ;
		int newX = x + director[direction][0];
		int newY = y + director[direction][1];
		int next = canvas[x][y];
		canvas[x][y] = curNum;
		if (direction == 0 && newX == N-1-start) direction++;
		if (direction == 1 && newY == M-1-start) direction++;
		if (direction == 2 && newX == start) direction++;
		if (direction == 3 && newY == start) direction = 0;
		starter = false;
		rotate(newX, newY, direction, next, start);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		canvas = new int[N][M];
		R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				canvas[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int j = 0; j < R; j++) {
			int rotateTime = Math.min(N, M) / 2;
			for (int i = 0; i < rotateTime; i++) {
				starter = true;
				rotate(i, i, 0, canvas[i][i+1], i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(canvas[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
