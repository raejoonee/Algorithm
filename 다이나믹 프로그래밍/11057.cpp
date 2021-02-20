#include <iostream>
#include <vector>
#include <array>

using namespace std;

int main()
{
        vector<long long> summer;
        for (int i = 0; i < 10; i++)
        {
                summer.push_back(1);
        }
        long long a;
        cin >> a;
        if (a == 1)
        {
                cout << 10;
                return 0;
        }
        long long tmp = 0;
        while (a)
        {
                vector<long long> answer;
                answer.push_back(1);
                for (int j = 0; j < 10; j++)
                {
                        tmp = (answer[j] + summer[j + 1]) % 10007;
                        answer.push_back(tmp);
                }
                summer.swap(answer);
                a--;
        }
        cout << summer[9];
        return 0;
}
