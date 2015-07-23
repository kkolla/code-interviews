package recursion;

public class Sodoku {
	
	public void solveSudoku(char[][] board) {
		solveSudoku(board, 0, 0);
    }
	
	private boolean solveSudoku(char[][] board, int i, int j) {
		if (j == 9) return solveSudoku(board, i + 1, 0);
		if (i == 9) return true;
		if (board[i][j] != '.') return solveSudoku(board, i, j + 1);
		for (int n = 1; n <= 9; n++) {
			board[i][j] = (char) ('0' + n);
			if (check(board, i, j)) {
				if (solveSudoku(board, i, j + 1)) return true;
			}
		}
		board[i][j] = '.'; // needed for n == 9 case, otherwise false is returned with board modified
		return false;
	}
	
	private boolean check(char[][] board, int row, int col) {
		for (int i = 0; i < board.length; i++) {
			if (i != row && board[i][col] == board[row][col]) return false;
		}
		for (int j = 0; j < board[0].length; j++) {
			if (j != col && board[row][j] == board[row][col]) return false;
		}
		for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++)
			for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
				if ((i != row || j != col) && board[i][j] == board[row][col]) return false;
			}
		return true;
	}
	
	public boolean isValidSudoku(char[][] board) {
        // check each row
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (seen[board[i][j] - '1']) return false;  
                seen[board[i][j] - '1'] = true;
            }    
        }
        
        // check each column
        for (int j = 0; j < 9; j++) {
            boolean[] seen = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                if (seen[board[i][j] - '1']) return false;  
                seen[board[i][j] - '1'] = true;
            }    
        }
        
        // check each box
        for (int k = 0; k < 9; k++) {
            int deltaX = (k / 3) * 3;
            int deltaY = k * 3 % 9;
            boolean[] seen = new boolean[9];
            for (int i = deltaX; i < deltaX + 3; i++) {
                for (int j = deltaY; j < deltaY + 3; j++) {
                    if (board[i][j] == '.') continue;
                    if (seen[board[i][j] - '1']) return false;  
                    seen[board[i][j] - '1'] = true;
                }    
            }
        }
        
        return true;
    }
}
