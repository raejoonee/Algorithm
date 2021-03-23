import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info {
	int x;
	int y;
	int bitmask;
	int moveCount;

	public Info(int x, int y, int bitmask, int moveCount) {
		this.x = x;
		this.y = y;
		this.bitmask = bitmask;
		this.moveCount = moveCount;
	}
}

public class Main {
	static int N, M;
	static char[][] maze;
	static boolean[][][] visited;
	static int[][] direction = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
	
	static int bfs(Info info) {
		visited[info.x][info.y][0] = true;
		Queue<Info> queue = new LinkedList<>();
		queue.add(info);
		while (!queue.isEmpty()) {
			Info top = queue.poll();
			visited[top.x][top.y][top.bitmask] = true;
			for (int i = 0; i < 4; i++) {
				int newX = top.x + direction[i][0];
				int newY = top.y + direction[i][1];
				if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
					if (!visited[newX][newY][top.bitmask]) {
						switch(maze[newX][newY]) {
						case '1':
							return top.moveCount + 1;
						case '0':
						case '.':
							visited[newX][newY][top.bitmask] = true;
							queue.add(new Info(newX, newY, top.bitmask, top.moveCount + 1)); // break 안해도 아래서 걸림
						case '#':
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							visited[newX][newY][top.bitmask] = true;
							queue.add(new Info(newX, newY, top.bitmask | 1 << 'f' - maze[newX][newY], top.moveCount + 1));
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							visited[newX][newY][top.bitmask] = true;
							// 맞는 열쇠가 없다ㅠㅠ
							if (((top.bitmask) & (1 << 'F' - maze[newX][newY])) == 0) break;
							// 맞는 열쇠가 있다ㅎㅎ
							else queue.add(new Info(newX, newY, top.bitmask, top.moveCount + 1));
						}
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new char[N][M];
		visited = new boolean[N][M][64];
		for (int i = 0; i < N; i++) maze[i] = br.readLine().toCharArray();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maze[i][j] == '0') System.out.println(bfs(new Info(i, j, 0, 0)));
			}
		}
	}
}
