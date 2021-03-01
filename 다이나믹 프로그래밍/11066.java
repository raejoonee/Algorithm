import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long merge (int[] chapterList, int N) {
		long dp[][] = new long[555][555];
		long sum[] = new long[555];
		for (int i = 1; i <= N; i++) sum[i] = sum[i-1] + chapterList[i-1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; i + j <= N; j++) {
				int temp = i + j;
				dp[j][temp] = Long.MAX_VALUE;
				for (int k = j; k < temp; k++)
					dp[j][temp] = Math.min(dp[j][temp], dp[j][k] + dp[k+1][temp] + sum[temp] - sum[j-1]);
			}
		}
		return dp[1][N];
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for (int i = 0; i < T; i++) {
    		int N = Integer.parseInt(br.readLine());
    		int[] chapterList = new int[N];
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) chapterList[j] = Integer.parseInt(st.nextToken());
    		sb.append(merge(chapterList, N)).append("\n");
    	}
    	System.out.println(sb.toString());
	}
}
