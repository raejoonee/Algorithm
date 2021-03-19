import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int k;
	static int[] parent;
	static int[] money;
	
	static void union(int a, int b) {
		int min = Math.min(parent[a], parent[b]);
		int max = Math.max(parent[a], parent[b]);
		for (int i = 0; i <= N; i++) if (parent[i] == max) parent[i] = min;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		money = new int[N];
		for (int i = 0; i <= N; i++) parent[i] = i;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) money[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int[] temp = new int[10001];
		for (int i = 1; i <= N; i++) {
			if (temp[parent[i]] == 0) temp[parent[i]] = money[i-1];
			else temp[parent[i]] = Math.min(money[i-1], temp[parent[i]]);
		}
		int minCost = Arrays.stream(temp).sum();
		if (minCost <= k) System.out.println(minCost);
		else System.out.println("Oh no");
	}
}
