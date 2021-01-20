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
        int X, L, R;
        cin >> X >> L >> R;
        if (X >= R)
        {
                cout << R;
        }
        else if (X >= L && X < R)
        {
                cout << X;
        }
        else
        {
                cout << L;
        }
        return 0;
}