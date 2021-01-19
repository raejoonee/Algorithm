#include <iostream>
#include <string>

using namespace std;


double combination(int a, int r);

int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(0); cout.tie(0);
        int N; cin >> N;
        int cnt = 0; int devil = 0;
        while (N - cnt){
                devil++;
                string dev = to_string(devil);
                for (int i = 0; i < dev.size(); i++){
                        if (i >= dev.size()-2) break;
                        if (dev[i] == '6'){
                                if (dev[i+1] == '6'){
                                        if (dev[i+2] == '6'){
                                                cnt++;
                                                break;
                                        }
                                }
                        }
                }
        }
        cout << devil;
        return 0;
}