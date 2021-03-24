import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey {
	int x; // 현재 위치한 x좌표
	int y; // 현재 위치한 y좌표
	int horse; // 앞으로 더 사용 가능한 말의 움직임 횟수
	int count; // 현재까지의 동작 수
	
	public Monkey(int x, int y, int horse, int count) {
		this.x = x;
		this.y = y;
		this.horse = horse;
		this.count = count;
	}
	
}

public class Main {
	static int K, W, H;
	static int[][] zoo;
	static boolean[][][] visited;
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] moveHorse = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	
	static int bfs() {
		Queue<Monkey> queue = new ArrayDeque<>();
		queue.add(new Monkey(0, 0, K, 0));
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			Monkey monkey = queue.poll();
			if (monkey.x == H-1 && monkey.y == W-1) {
				return monkey.count;
			}
			// move like horse
			if (monkey.horse > 0) {
				for (int i = 0; i < 8; i++) {
					int newX = monkey.x + moveHorse[i][0];
					int newY = monkey.y + moveHorse[i][1];
					if (newX >= 0 && newY >= 0 && newX < H && newY < W) {
						if (!visited[newX][newY][monkey.horse-1]) {
							visited[newX][newY][monkey.horse-1] = true;
							if (zoo[newX][newY] != 1) queue.add(new Monkey(newX, newY, monkey.horse-1, monkey.count+1));
						}
					}
				}
			}
			// move like monkey
			for (int i = 0; i < 4; i++) {
				int newX = monkey.x + move[i][0];
				int newY = monkey.y + move[i][1];
				if (newX >= 0 && newY >= 0 && newX < H && newY < W) {
					if (!visited[newX][newY][monkey.horse]) {
						visited[newX][newY][monkey.horse] = true;
						if (zoo[newX][newY] != 1) queue.add(new Monkey(newX, newY, monkey.horse, monkey.count+1));
					}
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		zoo = new int[H][W];
		visited = new boolean[H][W][K+1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				zoo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(bfs());
	}

}
