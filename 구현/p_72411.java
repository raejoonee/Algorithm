import java.util.*;

class Solution {
    // maxtime: 조합을 통해 얻어낼 문자열의 길이
    // mostOrderedTime: 해당 시행에서 가장 많이 주문된 횟수
    static int maxtime, mostOrderedTime;
    // 주문 조합을 나타내는 문자열을 key, 해당 조합의 주문 횟수를 value로 하는 Map 생성
    static Map<String, Integer> map;
    // 주문 조합을 재귀로 완전 탐색
	static void combination(int cnt, int index, String order, String newString) {
        // 주문 조합이 얻어낼 문자열의 길이가 되면 Map에 주문 조합 삽입 시작
		if (cnt == maxtime) {
            // newString을 알파벳 순으로 정렬하기 (temp가 알파벳 순으로 정렬된 문자열)
            char[] charList = newString.toCharArray();
            Arrays.sort(charList);
            String temp = "";
            for (char curChar : charList) temp += curChar;
            // 해당 조합이 주문된 횟수를 map에 추가
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            // 해당 조합이 주문된 횟수가 mostOrderedTime보다 크면 mostOrderedTime 갱신
            mostOrderedTime = Math.max(mostOrderedTime, map.get(temp));
            return ;
        }
        // 주문 조합을 탐색하는 재귀
        for (int i = index; i < order.length(); i++)
            combination(cnt + 1, i + 1, order, newString + order.charAt(i));
	}
    
    public String[] solution(String[] orders, int[] course) {
        // 조합을 사전순으로 정렬할 pq 생성
        PriorityQueue<String> pq = new PriorityQueue<>();
        // 결국 정답을 탐색하는 횟수는 course에 결정됨
        for (int cnt : course) {
            // 시행마다 mostOrederTime을 0으로 초기화
            mostOrderedTime = 0;
            // course 배열에 담긴 수가 maxtime이 됨
            maxtime = cnt;
            // 시행마다 map 초기화
            map = new HashMap<>();
            // 입력받은 orders 각각에 대해 주문 조합을 얻어내기 위해 조합 사용
            for (String order : orders) combination(0, 0, order, "");
            // 조합을 통해 얻어낸 map 구성을 사용
            for (String keyset : map.keySet())
                // 두 명 이상의 손님에게 주문되어야 하므로 mostOrderedTime >= 2여야 함
                // mostOrderedTime만큼 주문된 주문만 pq에 넣음
                if (mostOrderedTime >= 2 && map.get(keyset) == mostOrderedTime) pq.offer(keyset);
        }
        // 정답을 담을 배열 생성
        String answer[] = new String[pq.size()];
        // answer 배열에 정답 채워넣기
        for (int i = 0; i < answer.length; i++) answer[i] = pq.poll();
        // 정답 반환
        return answer;
    }
}
