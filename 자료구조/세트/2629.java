import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()); // 추의 개수
		int[] weightList = new int[N]; // 추의 무게
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) weightList[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine().trim()); // 구슬의 개수
		int[] ballList = new int[M]; // 확인하고자 하는 구슬의 무게
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) ballList[i] = Integer.parseInt(st.nextToken());
		
		// 확인 가능한 무게를 저장하는 Set 생성
		Set<Integer> set = new HashSet<>();
		
		// 어떤 추의 무게를 입력받았을 때, 현재 확인 가능한 무게는 다음과 같다.
		// 1. 입력받은 추의 무게
		// 2. 입력받은 추의 무게와 지금까지 확인 가능한 무게의 합과 차
		// 따라서, 추의 무게를 하나씩 입력받으면서 확인 가능한 무게를 추가해가는 형식으로 구현해 보자.
		for (int i = 0; i < N; i++) {
			int weight = weightList[i]; // 현재 입력받은 추의 무게
			ArrayList<Integer> al = new ArrayList<>(); // 입력받은 추의 무게와 지금까지 확인 가능한 무게의 합과 차를 저장해둘 ArrayList
			
			// 지금까지 확인 가능한 무게(set 내부에 있는 정수들) 전부에 대하여 입력받은 추와의 합과 차를 ArrayList에 저장해둔다.
			set.stream().forEach(element -> {
				al.add(element + weight);
				al.add(Math.abs(element - weight)); // 차는 음수가 될 수 있으므로 절댓값을 저장해야 한다.
			});
			
			// ArrayList에 저장된 무게들은 입력받은 추의 무게와 지금까지 확인 가능한 무게의 합과 차이기 때문에 확인 가능한 무게이므로 Set에 추가한다.
			for (int j = 0; j < al.size(); j++) {
				set.add(al.get(j));
			}
			
			set.add(weight); // 입력받은 추의 무게는 항상 확인 가능하다.
		}
		
		// 이제 주어진 각 구슬의 무게를 확인하며, 해당하는 구슬의 무게가 Set에 있는지 여부를 확인해서 정답을 출력한다.
		StringBuilder sb = new StringBuilder(); // 정답 출력용 StringBuilder
		for (int i = 0; i < ballList.length; i++) {
			if (set.contains(ballList[i])) sb.append('Y');
			else sb.append('N');
			sb.append(' ');
		}
		System.out.print(sb.toString());
	}
}
