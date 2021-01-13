#include <iostream>
#include <vector>
#include <string>
#include <queue>
#include <algorithm>

using namespace std;
int N, M;
vector<string> jahyo;

int calW(int i, int j, vector<string> jahyo){ // (0,0)이 W인 경우
        int initj = j;
        int cnt = 0;
        for (int a = 0; a < 8; a++){
                for (int b = 0; b < 8; b++){
                        if ((i+ j) % 2 == 0){
                                if (jahyo[i][j] == 'W') cnt++;
                        } else {
                                if (jahyo[i][j] == 'B') cnt++;
                        }
                        j++;
                }
                j = initj;
                i++;
        }
        return cnt;
}

int calB(int i, int j, vector<string> jahyo){ // (0,0)이 B인 경우
        int initj = j;
        int cnt = 0;
        for (int a = 0; a < 8; a++){
                for (int b = 0; b < 8; b++){
                        if ((i + j) % 2 == 0){
                                if (jahyo[i][j] == 'B')
                                        cnt++;
                        } else {
                                if (jahyo[i][j] == 'W')
                                        cnt++;
                        }
                        j++;
                }
                j = initj;
                i++;
        }
        return cnt;
}

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        cin >> N >> M;
        priority_queue<int, vector<int>, greater<int> > dap;
        for (int i = 0; i < N; i++){
                string s; cin >> s;
                jahyo.push_back(s);
        }
        for (int i = 0; i <= N - 8; i++){
                for (int j = 0; j <= M - 8; j++){
                        dap.push(min(calW(i, j, jahyo), calB(i, j, jahyo)));
                }
        }
        cout << dap.top();
        return 0;
}