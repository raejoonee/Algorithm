#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> tmp;
        int N;
        cin >> N;
        for (int i = 0; i < N; i++)
        {
                int a, b;
                cin >> a >> b;
                tmp.push(make_pair(b, a));
        }
        int k = tmp.size();
        for (int i = 0; i < k; i++)
        {
                cout << tmp.top().second << ' ' << tmp.top().first << '\n';
                tmp.pop();
        }
        return 0;
}
