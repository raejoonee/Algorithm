#include <vector>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

struct Lst
{
        int a;
        string b;
};

bool compare(Lst l1, Lst l2)
{
        return l1.a < l2.a;
}

int main()
{
        ios_base::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        int N;
        cin >> N;
        vector<Lst> lists;
        for (int i = 0; i < N; i++)
        {
                int a;
                string b;
                cin >> a >> b;
                Lst tmp = {a, b};
                lists.push_back(tmp);
        }
        stable_sort(lists.begin(), lists.end(), compare);
        for (int i = 0; i < N; i++)
        {
                cout << lists[i].a << ' ' << lists[i].b << '\n';
        }
        return 0;
}
