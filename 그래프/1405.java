import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static double east;
	static double west;
	static double south;
	static double north;
	static boolean[][] visited; 
	static double answer = 0;
	
	static void dfs(int x, int y, double p, int N) {
		if (visited[x][y]) return ;
		if (N == 0) {
			answer += p;
			return ;
		}
		N--;
		visited[x][y] = true;
		dfs(x, y+1, p*east, N);
		dfs(x, y-1, p*west, N);
		dfs(x+1, y, p*south, N);
		dfs(x-1, y, p*north, N);
		visited[x][y] = false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		east = Double.parseDouble(st.nextToken()) * 0.01;
		west = Double.parseDouble(st.nextToken()) * 0.01;
		south = Double.parseDouble(st.nextToken()) * 0.01;
		north = Double.parseDouble(st.nextToken()) * 0.01;
		visited = new boolean[2*N+1][2*N+1];
		dfs(N, N, 1, N);
		System.out.printf("%.9f", answer);
	}

}
