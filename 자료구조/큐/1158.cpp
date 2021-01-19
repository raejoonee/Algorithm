#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        queue<int> ans;
        vector<int> go;
        int N, K;
        cin >> N >> K;
        for (int i = 1; i <= N; i++){
                ans.push(i);
        }
        int iii = 1;
        while(!ans.empty()){
                if (iii != K){
                        int ttt = ans.front();
                        ans.pop();
                        ans.push(ttt);
                        iii++;
                } else {
                        go.push_back(ans.front());
                        ans.pop();
                        iii = 1;
                }
        }
        cout << '<';
        for (int i =0; i < go.size(); i++){
                cout << go[i];
                if (i != go.size()-1) cout << ", ";
        }
        cout << '>';
        return 0;
}