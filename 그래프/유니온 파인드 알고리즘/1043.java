import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parent;
	static boolean[] knowTruth; // i번째 사람이 진실을 아는지 여부를 담는 배열
	static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		knowTruth = new boolean[N+1];
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		
		// 일단 정답을 M(파티 개수)으로 둔다.
		int answer = M;
		// 진실을 아는 사람이 없으면 모든 파티에서 과장된 이야기를 할 수 있다.
		if (num == 0) {
			System.out.println(answer);
			return ;
		}
		// 진실을 아는 사람 설정
		for (int i = 0; i < num; i++) {
			knowTruth[Integer.parseInt(st.nextToken())] = true;
		}
		// 파티 구성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			al.add(new ArrayList<Integer>());
			int partyNum = Integer.parseInt(st.nextToken());
			for (int j = 0; j < partyNum; j++) {
				al.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		// 서로 진실 공유가 가능한 사람끼리 묶는다.
		for (ArrayList<Integer> party : al) {
			int parentNum = Integer.MAX_VALUE;
			for (Integer person : party) {
				if (parentNum > parent[person]) parentNum = parent[person];
			}
			for (Integer person : party) {
				if (parent[person] > parentNum) {
					int parentPerson = parent[person];
					for (int i = 1; i <= N; i++) {
						if (parent[i] == parentPerson) {
							parent[i] = parentNum;
						}
					}
				}
			}
		}
		// 진실을 알고 있는 사람이 공유한다.
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			if (knowTruth[i]) {
				map.put(parent[i], true);
			}
		}
		// 모든 파티를 조사하며 참석 불가능할 때마다 정답을 1씩 줄여나간다.
		for (ArrayList<Integer> party : al) {
			if (map.containsKey(parent[party.get(0)])) answer--;
		}
		System.out.println(answer);
	}
	
}
