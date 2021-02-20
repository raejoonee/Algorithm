import java.io.*;
import java.util.*;
 
class Tower {
	int number;
	int height;
	
	public Tower(int number, int height) {
		this.number = number;
		this.height = height;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {
				stack.push(new Tower(i + 1, height));
				sb.append("0 ");
				continue;
			}
			while (!stack.isEmpty()) {
				if (stack.peek().height > height) {
					sb.append(stack.peek().number + " ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty())
				sb.append("0 ");
			stack.push(new Tower(i + 1, height));
		}
		System.out.println(sb.toString());
	}
}
