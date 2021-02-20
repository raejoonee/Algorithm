#include <iostream>

using namespace std;

int N;

int main()
{
        cin >> N;
        if (N == 1 || N == 3)
        {
                cout << -1 << endl;
                return 0;
        }
        if (N % 5 == 0)
        {
                cout << N / 5 << endl;
        }
        else if (N % 5 == 1 || N % 5 == 4)
        {
                cout << N / 5 + 2 << endl;
        }
        else if (N % 5 == 2)
        {
                cout << N / 5 + 1 << endl;
        }
        else
        {
                cout << N / 5 + 3 << endl;
        }
}
