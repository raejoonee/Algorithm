import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			if (dp[i] != 0 || i == 0) {
				for (int j = 1; j <= arr[i]; j++) {
					if (i+j >= N) break;
					if (dp[i+j] != 0 && dp[i+j] < dp[i] + 1) continue;
					dp[i+j] = dp[i] + 1;
				}
			}
		}
		if (dp[N-1] == 0 && N != 1) System.out.println(-1);
		else System.out.println(dp[N-1]);
	}
	
}
