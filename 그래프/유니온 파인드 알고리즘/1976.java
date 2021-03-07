import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parent;
	
	public static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if (aParent != bParent) parent[bParent] = aParent;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N];
		for (int i = 0; i < N; i++) parent[i] = i;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) union(i, j);
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int curParent = find(Integer.parseInt(st.nextToken())-1);
		for (int i = 1; i < M; i++) {
			if (curParent != find(Integer.parseInt(st.nextToken())-1)) {
				System.out.println("NO");
				return ;
			}
		}
		System.out.println("YES");
	}
}
