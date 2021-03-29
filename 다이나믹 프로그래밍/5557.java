import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[] number; // 등호의 좌변에서 계산될 수를 담을 배열
	static long[][] dp; // dp[a][b]: a번째 수까지 계산한 결과가 b인 경우의 수
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		number = new int[N-1]; // 마지막 수는 계산 결과가 담기기 때문에 저장 안해도 됨
		dp = new long[N-1][21]; // 상근이는 0부터 20까지 21개의 수에 대해서만 기억하므로 21만큼의 공간만 만들면 됨 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) number[i] = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken()); // 계산의 결과가 되어야 하는 수
		dp[0][number[0]] = 1; // 0번째 수(첫번째로 입력받은 수)까지 계산한 결과는 0번째 수 하나뿐임
		
		for (int i = 0; i < N-2; i++) { // 1부터 N-2까지 결과 계산하기 위해 0부터 N-3을 탐색
			for (int j = 0; j <= 20; j++) { // 각 결과를 계산할 때마다 이전까지 계산한 결과를 기반으로 함
				if (dp[i][j] != 0) { // dp[i][j]에 저장된 값이 있을 경우
					int sum = j + number[i+1]; // 현재 위치와 다음 입력받은 수의 합
					int diff = j - number[i+1]; // 현재 위치에서 다음 입력받은 수를 뺀 값
					if (0 <= sum && sum <= 20) dp[i+1][sum] += dp[i][j];
					if (0 <= diff && diff <= 20) dp[i+1][diff] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N-2][target]);
	}
}
