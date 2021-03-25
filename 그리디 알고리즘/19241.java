import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Treasure {
	int a; // Alice 기준 가치
	int b; // Bob 기준 가치
	int val; // 두 가치의 합
	
	public Treasure(int a, int b) {
		this.a = a;
		this.b = b;
		val = a + b;
	}
	
}

public class Main {
	static int T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Treasure> pq = new PriorityQueue<>(N,
					(Treasure t1, Treasure t2) -> t2.val - t1.val);
			// PQ에 삽입
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int valAlice = Integer.parseInt(st.nextToken());
				int valBob = Integer.parseInt(st.nextToken());
				pq.add(new Treasure(valAlice, valBob));
			}
			boolean turn = true;
			int scoreA = 0, scoreB = 0;
			for (int j = 0; j < N; j++) {
				Treasure treasure = pq.poll();
				if (turn) { // Alice Turn
					scoreA += treasure.a;
					turn = false;
				} else { // Bob Turn
					scoreB += treasure.b;
					turn = true;
				}
			}
			sb.append(scoreA - scoreB).append('\n');
		}
		System.out.print(sb.toString());
	}

}
