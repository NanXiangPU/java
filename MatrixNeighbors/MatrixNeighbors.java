import java.lang.StringBuilder;

public class MatrixNeighbors{
	int rows;
	int columns;
	int[][] matrix;

	public MatrixNeighbors(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.matrix = new int[rows][columns];
	}

	public String neighbors(int row, int column) {
		if(row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length) {
			System.out.println("cell does not exist");
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int[][] DIR = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
		for(int[] dir: DIR) {
			int newRow = row + dir[0];
			int newCol = column + dir[1];
			if(newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length) {
				sb.append(newRow + "," + newCol + ";");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MatrixNeighbors mn = new MatrixNeighbors(3,3);
		System.out.println(mn.neighbors(0,0));
		System.out.println(mn.neighbors(2,2));
		System.out.println(mn.neighbors(1,1));
		System.out.println(mn.neighbors(3,0));
	}
}