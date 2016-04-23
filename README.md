# Nine Mens Morris

## Introduction
This repository contains code to play a console version of the Nine Men's Morris game. The game contains 2 players and in this case the human player is against the AI. The AI has been developed using the Minimax algorithm with Alpha Beta pruning to prevent deep searches into the game tree when it is known that such a move will not yield a positive result to the AI.

## Heuristics
The game initially starts out with the AI playing in a defensive mode and then switches to an offensive mode once there are sufficient pieces of its own on the board. In the defensive mode, the AI looks to block mill formations of the human player by having more points assigned to blocking than to forming mills. In the offensive mode, the reverse happens. The AI will try to form as many mills as possible so that the human player will lose a piece on every alternate turn.

## Scope for Improvement
1. The game heuristics can be improved to obtain better intelligence.
2. GUI for the game board.
3. Machine learning incorporation to make the AI more powerful.
