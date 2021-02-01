import java.io.*;
import java.util.*;

class Location {
	int x;
	int y;
	public Location (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static char[][] yard;
	static boolean[][] visited;
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int row;
	static int column;
	static int sheepTotal;
	static int wolfTotal;
	
	public static void bfs(Location start, char[][] yard, boolean[][] visited) {
		Queue<Location> queue = new LinkedList<>();
		queue.add(start);
		visited[start.x][start.y] = true;
		int sheep = 0;
		int wolf = 0;
		while(!queue.isEmpty()) {
			Location top = queue.poll();
			switch (yard[top.x][top.y]) {
			case 'o': sheep++; break;
			case 'v': wolf++; break;
			}
			for (int[] movingDirection : move) {
				int newX = top.x + movingDirection[0];
				int newY = top.y + movingDirection[1];
				if (newX >= 0 && newY >= 0 && newX < row && newY < column && !visited[newX][newY] && yard[newX][newY] != '#') {
					Location newLocation = new Location(newX, newY);
					queue.add(newLocation);
					visited[newX][newY] = true;
				}
				
			}
		}
		if (sheep > wolf) {
			sheepTotal += sheep;
		} else {
			wolfTotal += wolf;
		}
    
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		yard = new char[row][column];
		visited = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			yard[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (!visited[i][j] && yard[i][j] != '#') bfs(new Location(i, j), yard, visited);
			}
		}
		
		System.out.printf("%d %d", sheepTotal, wolfTotal);
		
	}
	
}
