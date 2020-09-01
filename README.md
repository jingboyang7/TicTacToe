# TicTacToe
A simple solution for game TicTacToe

<br><h2>How to run:</h2><br />
<br>Download the whole folder;<br />
<br>Run : cd TicTacToe/TicTacToe_jar<br />
<br>Run : java -jar TicTacToe.jar<br />
<br>Type in string line like "0,0,1" , “1,1,2” and enter.<br />

<br>Two players should type in one by one, others there is error message.<br />
<br>The game would be ended is one player wins or all board fields are full.(3X3).<br />
<br>There are negative cases such as player1 type in twice in row, player try to type in the content with exist row & col.<br />


<br><h2>Input String format:</h2><br />
<br>The format would be defined as A,B,C (A is board row number which could be 0, 1, 2, B is board col number which could be 0, 1, 2, C is player symbol which could be 1,2)<br />
<br>Such as "0,0,1","1,1,2", "2,1,2"..<br />



<br><h2>Test Cases:</h2><br />
<br>Case1:<br />
<br>1, 1, 1<br />
<br>1, 0, 2<br />
<br>2, 0, 1<br />
<br>0, 2, 2<br />
<br>2, 2, 1<br />
<br>2, 1, 2<br />
<br>0, 0, 1<br />
<br>Player1 will win<br />

<br>0, 0, 1<br />
<br>1, 1, 2<br />
<br>2, 0, 1<br />
<br>1, 0, 2<br />
<br>1, 2, 1<br />
<br>0, 2, 2<br />
<br>2, 1, 1<br />
<br>2, 2, 2<br />
<br>0, 1, 1<br />
<br>Game over with no one wins.<br />
