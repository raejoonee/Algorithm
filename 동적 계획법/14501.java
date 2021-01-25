import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력 받기
		int day = sc.nextInt();
		int[] time = new int[day];
		int[] price = new int[day];
		int[] dp = new int[day];
		for (int i = 0; i < day; i++) {
			time[i] = sc.nextInt();
			price[i] = sc.nextInt();
			dp[i] = price[i];
		}
		
		// 점화식 적용
		for (int i = 0; i < time.length; i++) {
			for (int j = 0; j < i; j++) {
				if (i >= j + time[j]) dp[i] = Math.max(price[i] + dp[j], dp[i]);
			}
		}
		
		// 최댓값 찾아서 반환
		int answer = 0;
		for (int i = 0; i < dp.length; i++) {
			// N+1일째에는 회사에 없어요~
			if (time[i] + i > day) continue;
			answer = Math.max(dp[i], answer);
		}
		System.out.println(answer);
		
		sc.close();
	}
}
