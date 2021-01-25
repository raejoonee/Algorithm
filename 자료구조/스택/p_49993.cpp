#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

// 스킬이 선행 스킬 순서에 있는지 확인하는 함수
bool isSkill(string skill, char a){
    for (int i = 0; i < skill.size(); i++){
        if (a == skill[i]) return true;
    }
    return false;
}

// 스킬트리가 가능한 스킬트리인지 확인하는 함수
bool val(string skill, string indv, stack<char> temp){
    bool answer = true;
    for (int i = 0; i < indv.size(); i++){
        // 스킬이 스택에 있는 스킬인지 확인한다.
        if (isSkill(skill, indv[i])){
            // 스택의 top()과 다르면 false를 반환한다.
            if (indv[i] != temp.top()){
                answer *= false;
            }
            // 스택의 top()과 같으면 스택을 pop()한다.
            else {
                temp.pop();
            }
        }
    }
    return answer;
}

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    string strtmp = "";
    stack<char> temp;
    for (int i = skill.size()-1; i >= 0; i--){
        temp.push(skill[i]);
    }
    for (int i = 0; i < skill_trees.size(); i++){
        if (val(skill, skill_trees[i], temp)) answer++;
    }
    return answer;
}
