import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp = new long[5001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// dp 배열 채우기 (어차피 5000까지 입력받을 수 있어야 하므로 먼저 채우고 나중에 입출력 받는게 낫다.)
		dp[0] = 1; dp[2] = 1; // 기본값
		// index가 홀수인 경우는 애초에 괄호가 성립되지 않아서 무조건 0이기 때문에 i와 j를 2씩 증가시켜서 시간을 최대한 아낀다.
		for (int i = 4; i <= 5000; i += 2) {
			for (int j = 2; j <= i; j += 2) {
				dp[i] += dp[j-2] * dp[i-j];
				dp[i] %= 1000000007L; // **더할 때마다 1000000007L로 나눠줘야 한다.**
			}
			dp[i] %= 1000000007L;
		}
		// 아래부터는 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < T; i++) sb.append(dp[Integer.parseInt(br.readLine().trim())]).append('\n');
		System.out.print(sb.toString());
	}
}
