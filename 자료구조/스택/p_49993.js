function inSkillTree(skill, skillList) {
    return skillList.indexOf(skill) === -1 ? false : true;
}

function validate(skillTree, condition) {
    condition = condition.slice();
    for (let eachSkill of skillTree) {
        if (inSkillTree(eachSkill, condition)) {
            if (eachSkill !== condition[0]) return false;
            else condition.shift();
        } 
    }
    return true;
}

function solution(skill, skill_trees) { 
    let answer = 0;
    let condition = skill.split("");
    skill_trees.forEach(eachTree => {
        if (validate(eachTree, condition)) answer++;
    });
    return answer;
}
