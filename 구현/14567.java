import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] pre;
	static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		pre = new boolean[N][N];
		answer = new int[N];
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int prerequisite = Integer.parseInt(st.nextToken())-1;
			int subject = Integer.parseInt(st.nextToken())-1;
			pre[prerequisite][subject] = true;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (pre[i][j]) answer[j] = Math.max(answer[j], answer[i]+1);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]+1).append(' ');
		}
		System.out.println(sb.toString());
	}
	
}
