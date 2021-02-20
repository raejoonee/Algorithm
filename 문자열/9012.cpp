#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

string dist(string s)
{
        int open = 0;
        for (int i = 0; i < s.size(); i++)
        {
                if (s[i] == '(')
                {
                        open++;
                }
                else
                {
                        if (open <= 0)
                                return "NO";
                        open--;
                }
        }
        if (open == 0)
                return "YES";
        return "NO";
}

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        int T;
        cin >> T;
        for (int i = 0; i < T; i++)
        {
                string s;
                cin >> s;
                cout << dist(s) << '\n';
        }
        return 0;
}
