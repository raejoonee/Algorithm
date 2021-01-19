#include <iostream>
#include <math.h>

using namespace std;

int N, M = 0;
float ans[1000] = {0,};

int main(){
        cin >> N;
        for (int i=0;i<N;i++){
                cin >> ans[i];
        }
        for (int j=0;j<N-1;j++){
                M = max(ans[j], ans[j+1]);
        }
        for (int k=0;k<N;k++){
                ans[k] = ans[k]/M*100;
        }
        float tmp = 0.00;
        for (int p = 0;p<N;p++){
                tmp += ans[p];
        }
        tmp = tmp/N;
        cout << fixed;
        cout.precision(2);
        cout << tmp << endl;
        return 0;
}