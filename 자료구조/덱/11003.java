import java.io.*;
import java.util.*;

class Number {
	int index;
	int amount;
	
	public Number(int index, int amount) {
		this.index = index;
		this.amount = amount;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Number> window = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            while(!window.isEmpty() && input < window.getLast().amount)
                window.removeLast();
            window.addLast(new Number(i, input));
            if (window.getFirst().index <= i - L)
                window.removeFirst();
            bw.write(window.getFirst().amount + " ");
        }
        bw.flush();
        bw.close();
	}
}
