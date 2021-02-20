import java.io.*;
import java.util.*;

public class Main {
	static int[][] canvas;
	static int[][] copyedCanvas;
	static int N;
	static int M;
	static int R;
	static void one() {
		copyedCanvas = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				copyedCanvas[i][j] = canvas[N-i-1][j];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				canvas[i][j] = copyedCanvas[i][j];
	}
	static void two() {
		copyedCanvas = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				copyedCanvas[i][j] = canvas[i][M-j-1];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				canvas[i][j] = copyedCanvas[i][j];
	}
	static void three() {
		int temp = N;
		N = M;
		M = temp;
		copyedCanvas = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				copyedCanvas[i][j] = canvas[M-j-1][i];
		canvas = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				canvas[i][j] = copyedCanvas[i][j];
	}
	static void four() {
		int temp = N;
		N = M;
		M = temp;
		copyedCanvas = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				copyedCanvas[i][j] = canvas[j][N-i-1];
		canvas = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				canvas[i][j] = copyedCanvas[i][j];
	}
	static void five() {
		copyedCanvas = new int[N][M];
		int tempN = N/2;
		int tempM = M/2;
		for (int i = 0; i < tempN; i++)
			for (int j = 0; j < tempM; j++) {
				copyedCanvas[i][j] = canvas[i+tempN][j];
				copyedCanvas[i+tempN][j] = canvas[i+tempN][j+tempM];
				copyedCanvas[i][j+tempM] = canvas[i][j];
				copyedCanvas[i+tempN][j+tempM] = canvas[i][j+tempM];
			}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				canvas[i][j] = copyedCanvas[i][j];
	}
	static void six() {
		copyedCanvas = new int[N][M];
		int tempN = N/2;
		int tempM = M/2;
		for (int i = 0; i < tempN; i++)
			for (int j = 0; j < tempM; j++) {
				copyedCanvas[i][j] = canvas[i][j+tempM];
				copyedCanvas[i+tempN][j] = canvas[i][j];
				copyedCanvas[i][j+tempM] = canvas[i+tempN][j+tempM];
				copyedCanvas[i+tempN][j+tempM] = canvas[i+tempN][j];
			}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				canvas[i][j] = copyedCanvas[i][j];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		canvas = new int[N][M];
		R = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				canvas[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			switch (st.nextToken()) {
			case "1":
				one();
				break;
			case "2":
				two();
				break;
			case "3":
				three();
				break;
			case "4":
				four();
				break;
			case "5":
				five();
				break;
			case "6":
				six();
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(canvas[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
