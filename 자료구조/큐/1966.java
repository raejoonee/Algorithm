import java.io.*;
import java.util.*;

class Document {
	int index;
	int priority;
	
	public Document(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
	
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		for (int i = 0; i < test_case; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int priorityList[] = new int[10];
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Document> queue = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int priority = Integer.parseInt(st.nextToken());
				priorityList[priority]++;
				queue.add(new Document(j, priority));
			}
			int answer = 1;
			int curPriority = 9;
			while (!queue.isEmpty()) {
				if (priorityList[curPriority] != 0) {
					if (queue.peek().priority == curPriority) {
						if (queue.peek().index == M) break;
						queue.poll();
						priorityList[curPriority]--;
						answer++;
					} else queue.add(queue.poll());
				} else curPriority--;
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
