import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		char[] input = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char e : input) {
			switch (e) {
			case '*':
			case '/':
				if (!stack.isEmpty())
					if (stack.peek() == '*' || stack.peek() == '/') 
						sb.append(stack.pop());
				stack.push(e);
				break;
			case '+':
			case '-':
				while (!stack.isEmpty()) {
					if (stack.peek() == '(') break;
					sb.append(stack.pop());
				}
				stack.push(e);
				break;
			case '(':
				stack.push(e);
				break;
			case ')':
				while (stack.peek() != '(')
					sb.append(stack.pop());
				stack.pop();
				break;
			default:
				sb.append(e);
			}
		}
		while (!stack.isEmpty())
			sb.append(stack.pop());
		System.out.println(sb.toString());
	}
}
