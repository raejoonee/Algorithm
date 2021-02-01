#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

long long cal (long long n, int p){
        vector<int> jari;
        long long answer = 0;
        // cout << 'a' << endl;
        while (n){
                jari.push_back(n % 10);
                n /= 10;
        }
        // cout << 'b' << endl;
        for (int i = 0; i < jari.size(); i++){
                answer += pow(jari[i], p);
        }
        // cout << 'c' << endl;
        return answer;
}

int main(){
        int a, p;
        cin >> a >> p;
        long long n = a;
        // cout << n << ' ' << cal(n, p) << endl;
        vector<long long> tmp;
        tmp.push_back(n);
        
        vector<long long>::iterator iter;
        while (true){
                iter = find(tmp.begin(), tmp.end(), cal(n, p));
                // cout << cal(n, p) << ' ';
                if (iter == tmp.end()){
                        tmp.push_back(cal(n, p));
                } else {
                        tmp.erase(iter, tmp.end());
                        break;
                }
                n = cal(n,p);
        }
        cout << tmp.size();
        return 0;
}