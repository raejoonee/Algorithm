#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <functional>
#include <iostream>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int, vector<int>, greater<int> > PQueue;
    for (int i = 0; i < scoville.size(); i++){
        PQueue.push(scoville[i]);
    }
    while(PQueue.size() > 1 && PQueue.top() < K){
        int a = PQueue.top();
        PQueue.pop();
        int b = PQueue.top();
        PQueue.pop();
        int ada = a + (2 * b);
        PQueue.push(ada);
        answer++;
    }
    return PQueue.top() < K ? -1 : answer;
}
