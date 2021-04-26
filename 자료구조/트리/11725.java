import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static Vector<Vector<Integer>> vector;
	static int[] answer;
	
	static void dfs(int vertex, int parent) {
		// 이미 vertex의 부모를 알고 있다면 return
		if (answer[vertex] != 0) return ;
		answer[vertex] = parent;
		
		// curVector: 현재 노드와 만나는 노드의 정보를 담은 벡터
		Vector<Integer> curVector = vector.get(vertex);
		
		// 현재 노드와 만나는 노드는 무조건 현재 노드의 자식이다.
		for (int node : curVector) {
			dfs(node, vertex);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 이중 벡터를 사용하여 만나는 노드의 정보를 담는다.
		vector = new Vector<Vector<Integer>>();
		for (int i = 0; i <= N; i++) {
			vector.add(new Vector<Integer>());
		}
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			vector.get(a).add(b);
			vector.get(b).add(a);
		}
		
		answer = new int[N+1]; // i번째 index에 노드 i의 부모를 담는 정답 배열
		dfs(1, 0); // 1을 트리의 루트로 정한다. (1은 루트이기 때문에 부모가 없으므로 두 번째 파라미터는 0)
		for (int i = 2; i <= N; i++) {
			System.out.println(answer[i]);
		}
	}
	
}
