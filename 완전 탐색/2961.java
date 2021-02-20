import java.io.*;
import java.util.*;

public class Main {
	static int[] sour;
	static int[] bitter;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	static void combination(int index, int count, int curSour, int curBitter) {
		if (count >= 1) answer = Math.min(answer, Math.abs(curSour - curBitter));
		for (int i = 0; i < sour.length; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			combination(i, count+1, curSour*sour[i], curBitter+bitter[i]);
			visited[i] = false;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		combination(1, 0, 1, 0);		
		System.out.println(answer);
		
	}
}
