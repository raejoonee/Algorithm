import java.io.*;

public class Main {
	static char[][] clip;
	static StringBuffer sb = new StringBuffer();
	
	static void divide(char[][] clip) {
		int size = clip.length;
		if (size == 1) {
			sb.append(clip[0][0] == '0' ? '0' : '1');
			return ;
		}
		
		char[][] leftUp = new char[size/2][size/2];
		char[][] rightUp = new char[size/2][size/2];
		char[][] leftDown = new char[size/2][size/2];
		char[][] rightDown = new char[size/2][size/2];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i < size/2 && j < size/2) leftUp[i][j] = clip[i][j];
				if (i < size/2 && j >= size/2) rightUp[i][j-size/2] = clip[i][j];
				if (i >= size/2 && j < size/2) leftDown[i-size/2][j] = clip[i][j];
				if (i >= size/2 && j >= size/2) rightDown[i-size/2][j-size/2] = clip[i][j];
			}
		}
		sb.append('(');
		divide(leftUp);
		divide(rightUp);
		divide(leftDown);
		divide(rightDown);
		sb.append(')');
		
		return ;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		clip = new char[N][N];
		for (int i = 0; i < N; i++) {
			clip[i] = br.readLine().toCharArray();
		}
		divide(clip);
		String answer = sb.toString();
		while (answer.contains("(1111)") || answer.contains("(0000)")) {
			answer = answer.replaceAll("[(]1111[)]", "1").replaceAll("[(]0000[)]", "0");
		}
		System.out.println(answer);
		
	}
}
