#include <iostream>
#include <string>

using namespace std;

int arr[26] = {0};

int main()
{
        ios::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        string s;
        cin >> s;
        for (int i = 0; i < s.length(); i++)
        {
                int idx = (s[i] >= 'a' && s[i] <= 'z') ? s[i] - 'a' : s[i] - 'A';
                arr[idx]++;
        }
        int comparer = 0;
        int curidx = 0;
        bool question = false;
        for (int i = 0; i < 26; i++)
        {
                if (arr[i] > comparer)
                {
                        comparer = arr[i];
                        curidx = i;
                        question = true;
                }
                else if (arr[i] == comparer)
                {
                        question = false;
                }
        }
        if (!question)
                cout << '?';
        else
        {
                char ans = curidx + 'A';
                cout << ans;
        }
        return 0;
}