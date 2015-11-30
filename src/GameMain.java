
public class GameMain {
	/* Constants for the Game */
	public static final int alpha = Integer.MIN_VALUE;
	public static final int beta  = Integer.MAX_VALUE;
	public static final int depth = 5;
	
	public static void printBoard(NineMensMorris board){
		
		System.out.println(board.getValueAtPosition(0)+"(00)----------------------"+board.getValueAtPosition(1)+"(01)----------------------"+board.getValueAtPosition(2)+"(02)");
		System.out.println("|                           |                           |");
		System.out.println("|       "+board.getValueAtPosition(8)+"(08)--------------"+board.getValueAtPosition(9)+"(09)--------------"+board.getValueAtPosition(10)+"(10)     |");
		System.out.println("|       |                   |                    |      |");
		System.out.println("|       |                   |                    |      |");
		System.out.println("|       |        "+board.getValueAtPosition(16)+"(16)-----"+board.getValueAtPosition(17)+"(17)-----"+board.getValueAtPosition(18)+"(18)       |      |");
		System.out.println("|       |         |                   |          |      |");
		System.out.println("|       |         |                   |          |      |");
		System.out.println(board.getValueAtPosition(3)+"(03)---"+board.getValueAtPosition(11)+"(11)----"+board.getValueAtPosition(19)+"(19)               "+board.getValueAtPosition(20)+"(20)----"+board.getValueAtPosition(12)+"(12)---"+board.getValueAtPosition(4)+"(04)");
		System.out.println("|       |         |                   |          |      |");
		System.out.println("|       |         |                   |          |      |");
		System.out.println("|       |        "+board.getValueAtPosition(21)+"(21)-----"+board.getValueAtPosition(22)+"(22)-----"+board.getValueAtPosition(23)+"(23)       |      |");
		System.out.println("|       |                   |                    |      |");
		System.out.println("|       |                   |                    |      |");
		System.out.println("|       "+board.getValueAtPosition(13)+"(13)--------------"+board.getValueAtPosition(14)+"(14)--------------"+board.getValueAtPosition(15)+"(15)     |");
		System.out.println("|                           |                           |");
		System.out.println("|                           |                           |");
		System.out.println(board.getValueAtPosition(5)+"(05)----------------------"+board.getValueAtPosition(6)+"(06)----------------------"+board.getValueAtPosition(7)+"(07)");
		
	}
	public static void main(String args[]){
		Evaluation evalBoard = new Evaluation();
		/* Initialize the board to all X's */
		NineMensMorris board = new NineMensMorris();
		
		/* Begin the game with the opening phase with 9 moves for each player */
		for(int iter = 1; iter <= 9; iter++){
			
			/* Take input from the user and display the board */
			printBoard(board);
			
			if(NineMensMorrisLogic.getEvaluationForOpeningPhase(board) == 10000){
				/* Human Wins! */
				System.out.println("You Win!!");
				System.exit(0);
			}
			/* AI's turn */
			printBoard(board);
			
			evalBoard = AlphaBeta.alphaBetaPruningAlgorithm(board, depth, false, alpha, beta, true);
			if(evalBoard.getEvaluation() == -10000){
				/* AI Wins! */
				System.out.println("You Lost!");
				System.exit(0);
			}
			else{
				board = evalBoard.getNineMensMorrisBoard();
			}
		}
		/* Entering the 2nd and Last phase of the game */
		while(true){
			/* Take input from the user and display the board */
			if(NineMensMorrisLogic.getEvaluationForMidGameAndEndGame(board) == 10000){
				/* Human Wins! */
				System.out.println("You Win!!");
				System.exit(0);
			}
			/* AI's turn */
			evalBoard = AlphaBeta.alphaBetaPruningAlgorithm(board, depth, false, alpha, beta, false);
			if(evalBoard.getEvaluation() == -10000){
				/* AI Wins! */
				System.out.println("You Lost!");
				System.exit(0);
			}
			else{
				board = evalBoard.getNineMensMorrisBoard();
			}
		}
	}
}
