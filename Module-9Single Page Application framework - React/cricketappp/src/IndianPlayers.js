import React from "react";

function IndianPlayers(){

const team=[
"Virat",
"Rohit",
"Gill",
"Rahul",
"Pant",
"Hardik"
];

const oddTeam=team.filter((player,index)=>index%2===0);

const evenTeam=team.filter((player,index)=>index%2!==0);

const T20Players=["Surya","Rinku","Tilak"];

const RanjiPlayers=["Pujara","Rahane","Sarfaraz"];

const mergedPlayers=[...T20Players,...RanjiPlayers];

return(

<div>

<h2>Odd Team Players</h2>

<ul>

{oddTeam.map((player,index)=>

<li key={index}>{player}</li>

)}

</ul>

<h2>Even Team Players</h2>

<ul>

{evenTeam.map((player,index)=>

<li key={index}>{player}</li>

)}

</ul>

<h2>Merged Players</h2>

<ul>

{mergedPlayers.map((player,index)=>

<li key={index}>{player}</li>

)}

</ul>

</div>

);

}

export default IndianPlayers;