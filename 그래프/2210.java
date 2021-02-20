import java.io.*;
import java.util.*;

class Location {
	int x;
	int y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static Set<String> set = new HashSet<>();
	static final int[][] MOVE = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	static String[][] graph = new String[5][5];
	
	public static void dfs(Location start, String curString) {
		if (curString.length() >= 6) {
			set.add(curString);
			return ;
		}
		curString += graph[start.x][start.y];
		for (int i = 0; i < 4; i++) {
			int newX = start.x + MOVE[i][0];
			int newY = start.y + MOVE[i][1];
			if (newX < 0 || newX >= 5 || newY < 0 || newY >= 5) continue;
			dfs(new Location(newX, newY), curString);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			graph[i] = br.readLine().split(" ");
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(new Location(i, j), "");
			}
		}
		System.out.println(set.size());
	}
}
