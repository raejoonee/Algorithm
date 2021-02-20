#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        vector<int> ans;
        int N;
        cin >> N;
        for (int i = 0; i < N; i++)
        {
                int a;
                cin >> a;
                ans.push_back(a);
        }
        sort(ans.begin(), ans.end());
        int nujeok = 0;
        int dap = 0;
        for (int i = 0; i < N; i++)
        {
                nujeok += ans[i];
                dap += nujeok;
        }
        cout << dap;
        return 0;
}
