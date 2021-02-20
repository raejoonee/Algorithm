#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> cut(string s)
{
        vector<string> ans;
        for (int i = 0; i < s.size(); i++)
        {
                ans.push_back(s.substr(i, s.size()));
        }
        return ans;
}
int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        string s;
        cin >> s;
        vector<string> dap = cut(s);
        sort(dap.begin(), dap.end());
        for (int i = 0; i < dap.size(); i++)
        {
                cout << dap[i] << '\n';
        }
        return 0;
}
