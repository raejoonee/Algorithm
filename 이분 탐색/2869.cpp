#include <iostream>

using namespace std;

int A, B, V;
long long cnt = 0; // Ʋ�� ���� 1: int�� long long���� �ٲ��� �ʾƼ� 
bool teuksoo = false;

bool wee(int mid){
        if ((mid-1)*(A-B)+A>=V) return true; // Ʋ�� ���� 2: ���ǹ��� Ʋ����
        else return false;
}

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        cin >> A >> B >> V;
        long long high = V;
        long long low = 1;
        while (low <= high) {
                long long mid = (high + low) / 2;
                if (wee(mid)){
                        high = mid - 1;
                        cnt = mid; // Ʋ�� ���� 3: cnt�� �������� ��� �ȿ� �־�� �ϴµ� �ۿ� ����
                } else{
                        low = mid + 1;  
                }
        }
        cout << cnt;
        return 0;
}