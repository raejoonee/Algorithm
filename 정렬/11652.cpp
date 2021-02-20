#include <algorithm>
#include <iostream>
using namespace std;

long long arr[1000000];

int main()
{
        int N;
        cin >> N;

        for (int i = 0; i < N; i++)
        {
                scanf("%lld", &arr[i]);
        }

        sort(arr, arr + N);

        long long max = arr[0];
        int count = 0, temp = 0;
        for (int i = 0; i < N - 1; i++)
        {
                if (arr[i] == arr[i + 1])
                {
                        temp++;
                        if (temp > count)
                        {
                                count = temp;
                                max = arr[i];
                        }
                }
                else if (arr[i] != arr[i + 1])
                {
                        temp = 0;
                }
        }
        cout << max;
        return 0;
}
