import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Long> trees;
	
	public static void main(String[] args) throws IOException {
		// �Է� �ޱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		trees = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			trees.add(Long.parseLong(st.nextToken()));
		
		// �̺� Ž���ϱ�
		long high = Collections.max(trees);
		long low = 0;
		while (low <= high) {
			long mid = (high + low) / 2;
			if (trees.stream().map(a -> a > mid ? a - mid : 0).reduce((a, b) -> a + b).get() >= M) low = mid + 1;
			else high = mid - 1;
		}
		System.out.println(high);
		
	}
}
