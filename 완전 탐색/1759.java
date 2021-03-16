import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] inputList;
	static boolean[] visited;
	static int L;
	static int C;
	
	static void combination(int count, int index) {
		if (count == L) {
			StringBuilder sb = new StringBuilder();
			int vowel = 0, consonant = 0;
			for (int i = 0; i < C; i++) {
				if (visited[i]) {
					switch (inputList[i]) {
					case "a":
					case "e":
					case "i":
					case "o":
					case "u":
						vowel++;
						break;
					default:
						consonant++;
						break;
					}
					sb.append(inputList[i]);
				}
			}
			if (vowel >= 1 && consonant >= 2) System.out.println(sb.toString());
			return ;
		}
		for (int i = index; i < C; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			combination(count + 1, i);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		inputList = br.readLine().split(" ");
		Arrays.sort(inputList);
		visited = new boolean[C];
		combination(0, 0);
	}
}
