import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Article implements Comparable<Article> {
	int no; // 기사 번호
	int click; // 기사가 클릭된 횟수
	int time; // 기사가 메인 기사로 올라간 시간
	
	public Article(int no, int click, int time) {
		this.no = no;
		this.click = click;
		this.time = time;
	}
	
	@Override
	public int compareTo(Article o) {
		return this.no - o.no;
	}
	
}

public class Solution {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int C = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			ArrayList<Article> mainArticles = new ArrayList<>(); // 오름차순 출력용 ArrayList
			boolean[] isMain = new boolean[1001]; // 메인 뉴스로 선정된 기사인지 여부를 저장하는 배열
			
			// 사용자가 기사를 순서대로 클릭한다.
			for (int time = 0; time < C; time++) {
				int no = Integer.parseInt(st.nextToken()); // 클릭한 기사의 기사 번호
				
				// 클릭한 기사가 이미 메인 뉴스로 선정된 기사일 경우 클릭 횟수만 1 증가한다.
				if (isMain[no]) {
					for (Article article : mainArticles) {
						if (article.no == no) {
							article.click++;
							break;
						}
					}
				}
				// 클릭한 기사가 이미 메인 뉴스로 선정된 기사가 아닐 경우
				else {
					// 메인 기사가 이미 정해진 수만큼 선정된 상태일 경우 메인 기사 하나를 내려야 한다.
					if (mainArticles.size() == N) {
						Collections.sort(mainArticles, new Comparator<Article>() {
							@Override
							public int compare(Article a, Article b) {
								// 클릭 횟수가 가장 적은 기사를 ArrayList 앞에 둠
								if (a.click != b.click) return a.click - b.click;
								// 클릭 횟수가 같은 경우엔 게시된 지 가장 오래된 기사를 ArrayList 앞에 둠
								else return a.time - b.time;
							}
						});
						// ArrayList 가장 앞에 있는 기사를 메인 기사에서 내린다.
						isMain[mainArticles.get(0).no] = false;
						mainArticles.remove(0);
					}
					// 클릭된 기사를 메인 기사로 선정한다.
					isMain[no] = true;
					mainArticles.add(new Article(no, 1, time));
				}
			}
			
			// 정답을 출력하기 위해 ArrayList를 정렬한다.
			Collections.sort(mainArticles);
			
			sb.append("#").append(test_case).append(" ");
					
			for (Article article : mainArticles) {
				sb.append(article.no + " ");
			}
			
			if (test_case != T) sb.append("\n");
		}
		
		// 정답 출력
		System.out.println(sb.toString());
	}
	
}
