import java.utils.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class cardNums {
	public int value = 0;
	public int turn = 0;
	public boolean chosen = false;
	
	public cardNums(int assignment) {
		value = assignment;
	}
	
	public void call(int callTurn) {
		turn = callTurn;
		chosen = true;
	}
	
	public int value() {
		return value;
	}
	
	public int turn() {
		return turn;
	}
	
	public boolean chosen() {
		return chosen;
	}
}

class Day4 {
	public final int boardDim = 5;
	public final int maxTurns = 100;
	
	public cardNums[][] createBoard(int[][] inputs) {
		cardNums[][] board = new cardNums[boardRows][boardCol];
		for (int x = 0; x < boardDim; x++) {
			for (int y = 0; y < boardDim; y++) {
				board[x][y] = new cardNum(inputs[x][y]);
			}
		}
		return board;
	}
	
	public void callNums(cardNums[][] board, int num, int turn) {
		for (int x = 0; x < boardDim; x++) {
			for (int y = 0; y < boardDim; y++) {
				if (board[x][y].value() == num) {
					board[x][y].call(turn);
				}
			}
		}
	}

	public int[] checkNums(cardNums[][] board){
		int[] winnerV = int[6];
		int[] winnerH = int[6];
		
		//should be able to combine 
		for (int x = 0; x < boardDim; x++) {
			boolean wonH, wonV = true;
			int turnWonH, turnWonV = maxTurns;
			int[] tempVert, tempHorz = int[5];
			
			for (int y = 0; y < boardDim; y++) {
				tempVert[x] = board[y][x].value();
				tempHorz[x] = board[x][y].value();
				wonH = wonH && board[x][y].chosen();
				wonV = wonV && board[y][x].chosen();
				if (board[x][y].turn() > turnWonH) {
					turnWonH = board[x][y].turn();
				} if (board[y][x] > turnWonV) {
					turnWomV = board[y][x].turn();
				}
			}
			if (wonH && turnWonH < winner[5]) {
				winnerH.copyOfRange(tempHorz, 0, 4);
				winnerH[5] = turnWonH;
			}
			if (wonV && turnWonV < winner[5]) {
				winnerV.copyOfRange(tempVert, 0, 4);
				winnerV[5] = turnWonV;
			}
		}
		return (winnerH[5] > winnerV[5]) ? winnerH : winnerV;
	}
	
	public static void main(String[] args){
		ArrayList bingo = new ArrayList<>;
		ArrayList winningNums = new ArrayList<>;
		
		try {
			File file = new File("day4input.txt");
			Scanner scanner = new Scanner(file);
			
			
		}
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
