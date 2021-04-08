import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c;
	static int[] sushi;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N * 2];
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			sushi[i] = input;
			sushi[i+N] = input;
		}
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i; j < i + k; j++) {
				set.add(sushi[j]);
			}
			set.add(c);
			answer = Math.max(answer, set.size());
		}
		System.out.println(answer);
	}
	
}
