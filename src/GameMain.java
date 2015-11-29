
public class GameMain {
	/* Constants for the Game */
	public static final int alpha = Integer.MIN_VALUE;
	public static final int beta  = Integer.MAX_VALUE;
	public static final int depth = 5;
	
	public static void main(String args[]){
		Evaluation evalBoard = new Evaluation();
		/* Initialize the board to all X's */
		NineMensMorris board = new NineMensMorris();
		
		/* Begin the game with the opening phase with 9 moves for each player */
		for(int iter = 1; iter <= 9; iter++){
			/* Take input from the user and display the board */
			if(NineMensMorrisLogic.getEvaluationForOpeningPhase(board) == 10000){
				/* Human Wins! */
				System.out.println("You Win!!");
				System.exit(0);
			}
			/* AI's turn */
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
