import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<Double> stack = new Stack<Double>();
		Scanner sc = new Scanner(System.in);
		
		// 입력 받기
		int size = Integer.parseInt(sc.nextLine());
		double[] operandList = new double[size];
		char[] postfix = sc.nextLine().toCharArray();
		for (int i = 0; i < operandList.length; i++) {
			operandList[i] = sc.nextInt();
		}
		
                // 후위 표현식 계산하기
		for (char character : postfix) {
			if (Character.isAlphabetic(character)) {
				stack.push(operandList[character - 'A']);
			} else {
				double result = 0.0;
				switch (character) {
				case '+':
					result = stack.pop() + stack.pop();
					break;
				case '-':
					result = -1.0 * stack.pop() + stack.pop();
					break;
				case '*':
					result = stack.pop() * stack.pop();
					break;
				case '/':
					result = 1 / stack.pop() * stack.pop();
					break;
				}
				stack.push(result);
			}
		}
    
                // 스택에 남아있는 수가 정답
		System.out.printf("%.2f", stack.pop());
		sc.close();
	}
}
