import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N, M;
	static int[][] board; // 0: 내부 공기, 1: 치즈, 2: 외부 공기
	static boolean[][] visited;
	static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	// 외부 공기와 내부 공기를 구분하는 함수
	static void externalAir(int x, int y) {
		if (board[x][y] == 1) return ;
		if (visited[x][y]) return ;
		visited[x][y] = true;
		board[x][y] = 2;
		for (int i = 0; i < 4; i++) {
			int newX = x + direction[i][0];
			int newY = y + direction[i][1];
			if (newX >= 0 && newY >= 0 && newX < N && newY < M) {
				externalAir(newX, newY);
			}
		}
	}
	
	// 녹일 치즈의 좌표를 담은 큐를 반환하는 함수
	static Queue<Point> melt() {
		Queue<Point> queue = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					// 사방탐색 결과 
					int count = 0;
					for (int k = 0; k < 4; k++) {
						int newX = i + direction[k][0];
						int newY = j + direction[k][1];
						if (board[newX][newY] == 2) count++;
					}
					// 외부 공기와 2방향 이상에서 만나야 함
					if (count >= 2) queue.add(new Point(i, j));
				}
			}
		}
		return queue;
	}
	
	// 남은 치즈 찾기
	static boolean findCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while (findCheese()) {
			visited = new boolean[N][M];
			externalAir(0, 0); // 외부 공기와 내부 공기를 구분하기
			Queue<Point> queue = melt();
			while (!queue.isEmpty()) {
				Point point = queue.poll();
				board[point.x][point.y] = 2;
			}
			visited = new boolean[N][M];
			externalAir(0, 0);
			answer++;
		}
		System.out.println(answer);
	}
	
}
