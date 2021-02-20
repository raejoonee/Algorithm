import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> al = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int prev = 0;
		int ascendingAnswer = 0;
		int descendingAnswer = 0;
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (prev <= number) {
				ascendingAnswer++;
			} else {
				al.add(ascendingAnswer);
				ascendingAnswer = 1;
			}
			if (prev >= number) {
				descendingAnswer++;
			} else {
				al.add(descendingAnswer);
				descendingAnswer = 1;
			}
			prev = number;
		}
		al.add(ascendingAnswer);
		al.add(descendingAnswer);
		System.out.println(al.stream().max((a, b) -> a - b).get());
		
	}
}
