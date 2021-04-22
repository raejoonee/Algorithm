import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Game implements Comparable<Game> {
	int start;
	int end;
	
	public Game(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Game o) {
		return this.end - o.end;
	}
	
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= n; test_case++) {
			int m = Integer.parseInt(br.readLine());
			int answer = 0;
			PriorityQueue<Game> pq = new PriorityQueue<>();
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int d = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				s += (d-1) * 2400;
				e += (d-1) * 2400;
				pq.add(new Game(s, e));
			}
			int curTime = 0;
			while (!pq.isEmpty()) {
				while (curTime > pq.peek().start) {
					pq.poll();
					if (pq.isEmpty()) break;
				}
				if (pq.isEmpty()) break;
				Game game = pq.poll();
				curTime = game.end;
				answer++;
			}
			sb.append("Scenario #").append(test_case).append(":\n").append(answer);
			if (test_case != n) sb.append("\n\n");
		}
		System.out.print(sb.toString());
	}
	
}
