CodingChallenge02-Round Table Version 1.0 20/12/2017

-----------------------
Description The Problem
-----------------------
- N children stand around a circle.
- Starting with a given child and working clockwise, each child has a sequential number (refer to ID).
- Starting with the first child, they count out from 1 to k, the k'th child has to be out and leave the circle.
- The count starts again with the child immediately next to the eliminated one.
- The winner is the child left standing last.

----------
Parameters
----------
- n: number of children play the game
- k: the number of children skipped

-------
Results
-------
- This program will print a list of children who is out and then print the winner of the game.

-------------------------------------
Expected Results Based on Mathematics
-------------------------------------
- This is the Josephus Problem
- If k = 1: the winner has the largest id
- If k = 2: there is a simple formula
    Choose p (as large as possible) and m satisfy: n = 2^p + m
    The ID of the winner equals 2*m + 1
- If k > 2: there is a recursive structure
    josephus(n. k) = (josephus(n-1, k) + k - 1) % n + 1
    josephus(1, k) = 1