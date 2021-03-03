import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
		while (!pq.isEmpty()) {
			int first = pq.poll();
			if (pq.isEmpty()) break;
			int second = pq.poll();
			answer += first + second;
			pq.add(first + second);
		}
		System.out.println(answer);
	}
}
