import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int dump = sc.nextInt();
            int[] temp = new int[102];
            for (int j = 0; j < 100; j++) {
                temp[sc.nextInt()]++;
            }
            int left = 1;
            int right = 100;
            while (dump != 0) {
                if (left == 101 || right == 0) break;
                if (temp[left] == 0) left++;
                if (temp[right] == 0) right--;
                if (temp[left] != 0 && temp[right] != 0) {
                    temp[left]--;
                    temp[left+1]++;
                    temp[right]--;
                    temp[right-1]++;
                    dump--;
                }
            }
            int min = 0, max = 0;
            for (int j = 0; j < 100; j++) {
                if (temp[j] != 0) {
                    if (min == 0) min = j;
                    max = j;
                }
            }
            System.out.printf("#%d %d\n", i + 1, max - min);
        }
        sc.close();
    }
}
  
// 상자의 높이 별 개수를 셀 temp 배열을 만든다.
// 상자의 높이를 입력을 받을 때마다 temp의 index가 높이인 곳의 값을 1 늘린다.
// 이렇게 개수를 센다.
 
// temp 배열의 왼쪽 끝과 오른쪽 끝에 포인터를 하나씩 두고
// dump 횟수만큼 각각 오른쪽, 왼쪽으로 진행하도록 한다.
// 진행하면서 0이 아닌 수를 만나면 1 줄이고 제자리에 멈춘다.
// 덤프 횟수만큼 반복했을 때, 두 포인터의 위치의 차가 정답이다.
