import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] line = new int[N];
		for (int i = 1; i <= N; i++) {
			int position = sc.nextInt();
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (position == count && line[j] == 0) {
					line[j] = i;
					break;
				}
				if (line[j] == 0) count++;
			}
		}
		Arrays.stream(line).forEach(a -> System.out.printf("%d ", a));
		sc.close();
	}
}
