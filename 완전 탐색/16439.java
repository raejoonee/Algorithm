import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] chicken;
	static boolean[] visited;
	static int answer = 0;
	
	public static void combination(int count, int index) {
		if (count == 3) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				if (visited[i]) al.add(i);
			}
			int happy = 0;
			for (int i = 0; i < N; i++) {
				happy += Math.max(Math.max(chicken[i][al.get(0)], chicken[i][al.get(1)]), chicken[i][al.get(2)]);
			}
			answer = Math.max(happy, answer);
			return ;
		}
		
		for (int i = index; i < M; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			combination(count + 1, i);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new int[N][M];
		visited = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				chicken[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(answer);
	}
}
