package com.henry.interview;

public class IsValidSudoku {

	  public boolean isValidSudoku(char[][] board) {
	        int[] row = new int[9];
	        int[] col = new int[9];
	        int[][] subm = new int[3][3];
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[i].length; j++) {
	                if(board[i][j]=='.'){
	                    continue;
	                }
	                int val=board[i][j]-'0';
	                if (((row[i] & (1 << val)) != 0) || ((col[j] & (1 << val)) != 0) || ((subm[i / 3][j / 3] & (1 << val)) != 0)) {
	                    return false;
	                } else {
	                    row[i] = row[i] | (1 << val);
	                    col[j] = col[j] | (1 << val);
	                    subm[i / 3][j / 3] = subm[i / 3][j / 3] | (1 << val);
	                }
	            }
	        }
	        return true;
	    }
}
