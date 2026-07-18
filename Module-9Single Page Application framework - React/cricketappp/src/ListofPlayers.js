import React from "react";

function ListofPlayers() {

const players=[
{name:"Virat",score:90},
{name:"Rohit",score:75},
{name:"Gill",score:65},
{name:"Rahul",score:85},
{name:"Pant",score:55},
{name:"Hardik",score:80},
{name:"Jadeja",score:68},
{name:"Ashwin",score:60},
{name:"Bumrah",score:95},
{name:"Shami",score:72},
{name:"Siraj",score:50}
];

const below70=players.filter(player=>player.score<70);

return(

<div>

<h2>List of Players</h2>

<ul>

{players.map((player,index)=>

<li key={index}>
{player.name} - {player.score}
</li>

)}

</ul>

<h2>Players with Score Below 70</h2>

<ul>

{below70.map((player,index)=>

<li key={index}>
{player.name} - {player.score}
</li>

)}

</ul>

</div>

);

}

export default ListofPlayers;