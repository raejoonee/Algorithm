import java.io.*;
import java.util.*;

public class Main {
	static int row;
	static int column;
	static int curCheese = 0;
	static int curCount = 0;
	static int[][] cheese;
	static int[][] cheeseCount;
	static boolean[][] visited;
	
	static int answer = 0;
	
	static void dfs(int x, int y, int count) {
		if (visited[x][y]) return ;
		if (cheeseCount[x][y] > count) {
			if (cheese[x][y] != -1)
				return;
		}
		if (cheese[x][y] == -1) {
			if (cheeseCount[x][y] == 0) {
				cheeseCount[x][y] = count+1;
				cheese[x][y] = 0;
				answer++;
			}
			return ;
		}
		visited[x][y] = true;
		if (y >= 1) dfs(x, y-1, count);
		if (y < column) dfs(x, y+1, count);
		if (x < row) dfs(x+1, y, count);
		if (x >= 1) dfs(x-1, y, count);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		cheese = new int[row+2][column+2];
		cheese[0] = new int[column+2];
		for (int i = 1; i <= row; i++) {
			int[] eachRow = new int[column+2];
			eachRow[0] = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= column; j++) {
				int point = Integer.parseInt(st.nextToken());
				if (point == 1) eachRow[j] = -1;
				else eachRow[j] = point;
			}
			eachRow[column+1] = 0;
			cheese[i] = eachRow;
		}
		cheese[row+1] = new int[column+2];
		cheeseCount = new int[row+2][column+2];
		boolean startZero = true;
		for (int i = 0; i < row+2; i++) {
			for (int j = 0; j < column+2; j++) {
				if (cheese[i][j] != 0) startZero = false;
			}
		}
		boolean flag = false;
		while (!flag) {
			flag = true;
			answer = 0;
			visited = new boolean[row+2][column+2];
			dfs(0, 0, curCount);
			for (int i = 0; i < row+2; i++) {
				for (int j = 0; j < column+2; j++) {
					if (cheese[i][j] != 0) flag = false;
				}
			}
			curCount++;
		}
		if (startZero) curCount--;
		System.out.println(curCount + "\n" + answer);
	}

}
