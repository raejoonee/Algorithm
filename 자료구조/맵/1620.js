const fs = require("fs");
const { setPriority } = require("os");
const { stdout } = require("process");
const stdin = (process.platform === 'linux' ?
        fs.readFileSync('/dev/stdin').toString().trim() :
        `26 5
Bulbasaur
Ivysaur
Venusaur
Charmander
Charmeleon
Charizard
Squirtle
Wartortle
Blastoise
Caterpie
Metapod
Butterfree
Weedle
Kakuna
Beedrill
Pidgey
Pidgeotto
Pidgeot
Rattata
Raticate
Spearow
Fearow
Ekans
Arbok
Pikachu
Raichu
25
Raichu
3
Pidgey
Kakuna`
).split('\n');

const input = (() => {
        let line = 0;
        return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(e => parseInt(e));
let map = new Map();
for (let i = 0; i < N; i++) {
    const pokemon = input();
    map.set(i+1, pokemon);
    map.set(pokemon, i+1);
}
for (let i = 0; i < M; i++) {
    let key = input();
    if (!isNaN(key)) key = parseInt(key);
    console.log(map.get(key));
}
