import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		while (N != 0) {
			int border = (int) Math.pow(2, N-1);
			if (r < border && c >= border) {
				answer += Math.pow(4, N-1);
				c -= Math.pow(2, N-1);
			}
			else if (r >= border && c < border) {
				answer += 2 * Math.pow(4, N-1);
				r -= Math.pow(2, N-1);
			}
			else if (r >= border && c >= border) {
				answer += 3 * Math.pow(4, N-1);
				r -= Math.pow(2, N-1);
				c -= Math.pow(2, N-1);
			}
			N--;
		}
		if (r == 0 && c == 1) answer += 1;
		if (r == 1 && c == 0) answer += 2;
		if (r == 1 && c == 1) answer += 3;
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}

}
