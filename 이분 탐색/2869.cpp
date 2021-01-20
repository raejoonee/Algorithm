#include <iostream>

using namespace std;

int A, B, V;
long long cnt = 0; // 틀린 이유 1: int를 long long으로 바꾸지 않아서 
bool teuksoo = false;

bool wee(int mid){
        if ((mid-1)*(A-B)+A>=V) return true; // 틀린 이유 2: 조건문을 틀려서
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
                        cnt = mid; // 틀린 이유 3: cnt를 성공했을 경우 안에 넣어야 하는데 밖에 빼서
                } else{
                        low = mid + 1;  
                }
        }
        cout << cnt;
        return 0;
}