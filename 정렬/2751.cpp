#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        priority_queue<int, vector<int>, greater<int>> num;
        int N;
        cin >> N;
        for (int i = 0; i < N; i++)
        {
                int a;
                cin >> a;
                num.push(a);
        }
        int T = num.size();
        for (int i = 0; i < T; i++)
        {
                cout << num.top() << '\n';
                num.pop();
        }
        return 0;
}
