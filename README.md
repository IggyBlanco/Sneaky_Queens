# Sneaky_Queens

Problem Statement:
Given a list of coordinate strings for queens on an arbitrarily large chess board,
determine whether any of the queens can attack one another.

In the game of chess, queens can move any number of spaces in any of eight directions: up, down, left, right, or
any of four possible diagonal directions (up-left, up-right, down-left, or down-right).

One standard notation for the location of a chess piece on an 8x8 board is to give its column, followed by its row,
as a single string with no spaces. In this coordinate system, columns are labeled a through h (from left to right),
and rows to be numbered 1 through 8 (from bottom to top).

Essentially, the columns are given in a base 26 numbering scheme, where digits 1 through 26 are represented
using a through z. However, this counting system is a bit jacked up since there’s no character to represent the
value zero. 

-----------------------
COMPILING
Ubuntu Bash Environment
-----------------------

Compile < javac SneakyQueens.java TestCase01.java > 
  - Compiles with TestCase<n>
 
 Test all cases < bash test-all.sh >
