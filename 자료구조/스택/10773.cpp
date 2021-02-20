#include <iostream>
#include <stack>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        stack<int> ans;
        int dap = 0;
        int K;
        cin >> K;
        for (int i = 0; i < K; i++)
        {
                int a;
                cin >> a;
                if (!ans.empty() && a == 0)
                {
                        ans.pop();
                        continue;
                }
                else if (ans.empty() && a == 0)
                        continue;
                ans.push(a);
        }
        int sze = ans.size();
        for (int i = 0; i < sze; i++)
        {
                dap += ans.top();
                ans.pop();
        }
        cout << dap;
        return 0;
}
