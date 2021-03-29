import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 정수의 원래 값 num과 정수를 숫자 단위로 읽은 결과 str을 가지고 있는 새로운 클래스 Number를 만든다.
class Number implements Comparable<Number> {
	int num; // 정수의 원래 값
	String str; // 정수를 숫자 단위로 읽은 결과
	
	// 생성자
	public Number(int num, String str) {
		this.num = num;
		this.str = str;
	}

	// 숫자 단위로 읽은 결과를 사전 순으로 정렬해야 하기 때문에 compareTo()를 str에 대해서 처리한다.
	@Override
	public int compareTo(Number o) {
		return this.str.compareTo(o.str);
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		// M 이상 N 이하의 정수의 원래 값과 숫자 단위로 읽은 결과를 Priority Queue에 넣는다.
		// Number 클래스의 compareTo()에 의해서 숫자 단위로 읽은 결과에 대해 사전 순으로 정렬된다.
		PriorityQueue<Number> pq = new PriorityQueue<>();
		for (int i = M; i <= N; i++) {
			StringBuilder sb = new StringBuilder();
			String string = new Integer(i).toString(); // int를 String 타입으로 형변환
			// 형변환한 문자열을 앞에서부터 읽으면서(숫자 단위로 읽으면서) 결과를 StringBuilder에 저장
			for (int j = 0; j < string.length(); j++) {
				switch (string.charAt(j)) {
				case '0':
					sb.append("zero ");
					break;
				case '1':
					sb.append("one ");
					break;
				case '2':
					sb.append("two ");
					break;
				case '3':
					sb.append("three ");
					break;
				case '4':
					sb.append("four ");
					break;
				case '5':
					sb.append("five ");
					break;
				case '6':
					sb.append("six ");
					break;
				case '7':
					sb.append("seven ");
					break;
				case '8':
					sb.append("eight ");
					break;
				case '9':
					sb.append("nine ");
					break;
				}
			}
			// 원래 값 i와 StringBuilder에 저장된 값을 pq에 저장하면, 숫자 단위로 읽은 결과가 사전 순으로 정렬됨
			pq.add(new Number(i, sb.toString()));
		}
		StringBuilder sb = new StringBuilder(); // 정답을 출력하기 위한 StringBuilder
		int count = 1; // 한 줄에 10개씩 출력하기 위한 변수
		// Priority Queue에 있는 String들을 출력한다.
		while (!pq.isEmpty()) {
			sb.append(pq.poll().num).append(' '); // 정답에 Priority Queue에 저장된 Number 객체의 num을 저장함
			if (count == 10) { // 한 줄에 10개가 출력되다면,
				sb.append('\n'); // 줄바꿈
				count = 0; // 변수 초기화
			}
			count++; // 현재 줄에 출력된 정답의 개수를 1 늘림
		}
		System.out.println(sb.toString()); // 정답 출력
	}

}
