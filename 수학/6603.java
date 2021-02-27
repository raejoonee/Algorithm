import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer> al;
	static void combination(int cnt, int index) {
		if (cnt == 6) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < k; i++) {
				if (visited[i]) sb.append(arr[i]).append(" ");
			}
			System.out.println(sb.toString());
			return ;
		}
		for (int i = index; i < k; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			al.add(arr[i]);
			combination(cnt + 1, i);
			al.remove((Integer) arr[i]);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String newLine = br.readLine();
			if (newLine.trim().equals("0")) break;
			StringTokenizer st = new StringTokenizer(newLine);
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			visited = new boolean[k];
			al = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combination(0, 0);
			System.out.println();
		}
	}
}
