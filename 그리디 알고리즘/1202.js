const fs = require("fs");
const stdin = (process.platform === "linux"
    ? fs.readFileSync("/dev/stdin").toString()
    : `3 2
1 65
5 23
2 99
10
2
`
)
    .trim()
    .split("\n");
class Node {
    constructor(weight, price) {
        this.weight = weight
        this.price = price
    }
}
class PriorityQueue {
    constructor() {
        this.heap = [];
        this.count = 0;
    }
    isEmpty() {
        return this.count === 0
    }
    insert(weight, price) {
        const node = new Node(weight, price);
        this.count += 1;
        let currentNode = this.count;
        let parentNode = currentNode >> 1;
        while (parentNode >= 1) {
        if (this.heap[parentNode].price >= price) break;
        this.heap[currentNode] = this.heap[parentNode]
        currentNode = parentNode;
        parentNode = currentNode >> 1;
        }
        this.heap[currentNode] = node;
    }
    delete() {
        if (this.isEmpty())
        return;
        const deleteNode = this.heap[1];
        this.heap[1] = this.heap[this.count];
        const tempNode = this.heap.pop();
        this.count -= 1;
        if (this.isEmpty()) return deleteNode;
        let currentNode = 1;
        let childNode = currentNode * 2;
        while (childNode <= this.count) {
        if (childNode + 1 <= this.count) {
            if (this.heap[childNode].price <= this.heap[childNode + 1].price)
            childNode += 1;
        }
        if (tempNode.price >= this.heap[childNode].price) break;
        this.heap[currentNode] = this.heap[childNode];
        currentNode = childNode;
        childNode *= 2;
        }
        this.heap[currentNode] = tempNode;
        return deleteNode;
    }
}

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

class jewel {
    constructor(weight, value) {
        this.weight = weight;
        this.value = value;
    }
}

const [N, K] = input().split(" ").map(Number);
let jewelList = [];
for (let i = 0; i < N; i++) {
    jewelList.push(new jewel(...input().split(" ").map(Number)));
}
let bagList = [];
for (let i = 0; i < K; i++) {
    bagList.push(parseInt(input()));
}
jewelList.sort((a, b) => a.weight - b.weight);
// console.log(jewelList);
bagList.sort((a, b) => a - b);
// console.log(bagList);
let answer = 0n;
let pq = new PriorityQueue();
let index = 0;
for (let i = 0; i < K; i++) {
    while (index < N && jewelList[index].weight <= bagList[i]) {
        pq.insert(jewelList[index].weight, jewelList[index].value);
        index++;
    }
    if (!pq.isEmpty()) {
        answer += BigInt(pq.delete().price);
    }
}
console.log((""+answer).replace(/n/g, ""));
