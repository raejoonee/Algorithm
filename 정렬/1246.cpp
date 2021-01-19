#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        int N, M; cin >> N >> M;
        vector<int> customers;
        for (int i = 0; i < M; i++){
                int a; cin >> a;
                customers.push_back(a);
        }
        sort(customers.begin(), customers.end());
        priority_queue<pair<int, int> > dap;
        int start;
        if (N >= M) start = 0;
        else start = M-N;
        for (int i = start; i < M; i++){
                int idx = customers[i];
                int ans = 0;
                for (int j = i; j < M; j++){
                        ans += customers[i];
                }
                // cout << "pair: " <<ans << ", " << idx << endl;
                dap.push(make_pair(ans, idx));
        }
        cout << dap.top().second << ' ' << dap.top().first;
        return 0;
}