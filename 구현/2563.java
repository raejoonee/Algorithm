import java.io.*;
import java.util.*;

public class Main {
	static int[][] canvas = new int[100][100];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int papers = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < papers; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					canvas[j + x][k + y] = 1;
				}
			}
		}
		int answer = 0;
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				if (canvas[x][y] == 1) answer++;
			}
		}
		System.out.println(answer);
	}

}
