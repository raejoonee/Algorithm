import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(br.readLine());
    	int[][] rgb = new int[N][3];
    	// 색 각각의 비용 저장
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		rgb[i][0] = Integer.parseInt(st.nextToken());
    		rgb[i][1] = Integer.parseInt(st.nextToken());
    		rgb[i][2] = Integer.parseInt(st.nextToken());
    	}
    	int answer = Integer.MAX_VALUE;
    	// 최소 비용 저장
    	int[][] dp = new int[N][3];
    	// 첫번째 집을 빨강, 초록, 파랑으로 칠하는 세 경우 중 비용 최솟값을 구한다.
    	for (int i = 0; i < 3; i++) {
    		// 첫번째 집의 비용은 가정한 대로 정한다.
    		for (int j = 0; j < 3; j++) {
    			if (i == j) dp[0][j] = rgb[0][j];
    			// 첫번째 집으로 가정한 색이 아닐 경우, 무조건 dp의 Math.min()에서 걸러지게 최대 비용보다 훨씬 더 큰 수로 넣어둔다.
    			else dp[0][j] = 2000;
    		}
    		// 지금부터는 RGB거리(http://boj.kr/1149)와 똑같이 푼다.
    		for (int j = 1; j < N; j++) {
    			dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + rgb[j][0];
    			dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + rgb[j][1];
    			dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + rgb[j][2];
    		}
    		// 마지막 집은 첫번째 집과 같은 색일 수가 없다.
    		for (int j = 0; j < 3; j++) {
    			// 같은 색일 경우 무시
    			if (i == j) continue;
    			// 아닐 경우 최솟값 후보에 들어간다.
    			else answer = Math.min(dp[N-1][j], answer);
    		}
    	}
    	// 최종적으로 가장 작은 값이 답
    	System.out.println(answer);
	}
}
