import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N;
	static int M;
	static int[][] map;
	static int[][] temp;
	static int answer = 0;
	static int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
	
	static void bfs() {
		int[][] copyMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = temp[i][j];
			}
		}
		Queue<Point> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 2) queue.add(new Point(i, j));
			}
		}
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = point.x + direction[i][0];
				int newY = point.y + direction[i][1];
				if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
					if (copyMap[newX][newY] == 0) {
						copyMap[newX][newY] = 2;
						queue.add(new Point(newX, newY));
					}
				}
			}
		}
		int curAnswer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) curAnswer++;
			}
		}
		answer = Math.max(answer, curAnswer);
	}
	
	static void combination(int count) {
		if (count == 3) {
			bfs();
			return ;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0) {
					temp[i][j] = 1;
					combination(count + 1);
					temp[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					for (int x = 0; x < N; x++)
						for (int y = 0; y < M; y++)
							temp[x][y] = map[x][y];
					temp[i][j] = 1;
					combination(1);
					temp[i][j] = 0;
				}
			}
		}
		
		System.out.println(answer);
	}

}
