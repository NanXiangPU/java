Write a class MatrixNeighbors with the following fields:

int rows
int columns
int[][] matrix
the following constructor:

MatrixNeighbors(int rows, int columns) : sets both the rows and columns fields, then creates a new matrix of size [rows]x[columns].
and the following method:

String neighbors(int row, int column) : returns a String containing all the cell neighbors of the cell at row, column, starting directly above the specified cell and moving clockwise. If the cell is along any edge, be sure to omit the non-existent neighbors. See below for formatting.
Strings will be formatted as such: “<above cell row>,<above cell column>;<next cell clockwise row>,<next cell clockwise column>;…<last cell row>,<last cell column>;”.

Handle a nonexistent cell, one that exists outside of the matrix boundaries, by returning the string “cell does not exist”.

Consider the following diagram and code:

-------------------
|     |     |     |
| 0,0 | 0,1 | 0,2 |
|     |     |     |
-------------------
|     |     |     |
| 1,0 | 1,1 | 1,2 |
|     |     |     |
-------------------
|     |     |     |
| 2,0 | 2,1 | 2,2 |
|     |     |     |
-------------------
MatrixNeighbors m = new MatrixNeighbors(3, 3);
System.out.println(m.neighbors(0, 0)); //prints "0,1;1,1;1,0;"
System.out.println(m.neighbors(2, 2)); //prints "1,2;2,1;1,1;"
System.out.println(m.neighbors(1, 1)); //prints "0,1;0,2;1,2;2,2;2,1;2,0;1,0;0,0;"
System.out.println(m.neighbors(3, 0)); //prints "cell does not exist"
