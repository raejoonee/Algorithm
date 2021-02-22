import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int S;
	static int[] arr;
	static ArrayList<Integer> al = new ArrayList<>();
	static void combination(int[] arr, int index, int reduce, int limit) {
		if (index > limit) return ;
		al.add(arr[index]+reduce);
		combination(arr, index+1, reduce+arr[index], limit);
		combination(arr, index+1, reduce, limit);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		combination(arr, 0, 0, N-1);
		System.out.println(al.stream().filter(e -> e == S).count());
	}
}
