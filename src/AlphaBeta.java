import java.util.ArrayList;

public class AlphaBeta {
	
	/* The Main AI Logic i.e. Alpha Beta Pruning Algorithm */
	public static Evaluation alphaBetaPruningAlgorithm(NineMensMorris board, int depth, boolean isWhite, int alpha, int beta, boolean isOpeningPhase) {
		/* finalEvaluation will  */
		Evaluation finalEvaluation = new Evaluation();
		
		/* Terminate the recursion if the depth reaches Zero */
		if (depth != 0) {
			ArrayList<NineMensMorris> possibleBoardConfigurations = null;
			Evaluation currentEvaluation = new Evaluation();
			
			/* Generate all board configurations for White */
			if (isWhite) {
				if(isOpeningPhase){
					possibleBoardConfigurations = NineMensMorrisLogic.addPiecesForOpeningMoves(board);
				}
				else{
					possibleBoardConfigurations = NineMensMorrisLogic.addPiecesforMidgameAndEndGame(board);
				}
			}
			/* Generate all board configurations for Black */
			else {
				if(isOpeningPhase){
					possibleBoardConfigurations = NineMensMorrisLogic.addPiecesForOpeningMovesBlack(board);
				}
				else{
					possibleBoardConfigurations = NineMensMorrisLogic.addPiecesforMidgameAndEndgameBlack(board);
				}
			}

			/* For every possible board configuration, run the heuristic/recurse */
			for (NineMensMorris boardIterator : possibleBoardConfigurations) {
				
				/* Update the current evaluation and potential final board if this board has a 
				 * value greater than Alpha */
				if (isWhite) {
					currentEvaluation = alphaBetaPruningAlgorithm(boardIterator, depth - 1, false, alpha, beta, isOpeningPhase);
					finalEvaluation.setPositionsEvaluated(finalEvaluation.getPositionsEvaluated() + currentEvaluation.getPositionsEvaluated());
					
					if (currentEvaluation.getEvaluation() > alpha) {
						alpha = currentEvaluation.getEvaluation();
						finalEvaluation.setNineMensMorrisBoard(boardIterator);
					}
				}
				/* For black, update the current evaluation and potential final Board if the board has a 
				 * value lesser than Beta */
				else {
					currentEvaluation = alphaBetaPruningAlgorithm(boardIterator, depth - 1, true, alpha, beta, isOpeningPhase);
					finalEvaluation.setPositionsEvaluated(finalEvaluation.getPositionsEvaluated() + currentEvaluation.getPositionsEvaluated());
					
					if (currentEvaluation.getEvaluation() < beta) {
						beta = currentEvaluation.getEvaluation();
						finalEvaluation.setNineMensMorrisBoard(boardIterator);
					}

				}
				/* If Alpha is at least Beta, then pruning condition is satisfied */ 
				if(alpha >= beta) {
					//System.out.println("Pruning Scenario!");
					break;
				}
					
			}
			/* Set the Final Evaluation */ 
			if(isWhite) {
				finalEvaluation.setEvaluation(alpha);
			}	
			else {
				finalEvaluation.setEvaluation(beta);
			}
				
			
		}
		/* Once Depth reaches zero, evaluate the board with the heuristics */
		else {
			if(isWhite){
				if(isOpeningPhase){
					finalEvaluation.setEvaluation(NineMensMorrisLogic.getEvaluationImproved(board, isOpeningPhase));
				}
				else{
					finalEvaluation.setEvaluation(NineMensMorrisLogic.getEvaluationImproved(board, isOpeningPhase));
				}
			}
			else{
				if(isOpeningPhase){
					finalEvaluation.setEvaluation(NineMensMorrisLogic.getEvaluationImproved(board.getInvertedBoard(), isOpeningPhase));
				}
				else{
					finalEvaluation.setEvaluation(NineMensMorrisLogic.getEvaluationImproved(board.getInvertedBoard(), isOpeningPhase));
				}
			}
			
			finalEvaluation.setPositionsEvaluated(finalEvaluation.getPositionsEvaluated() + 1);
		}
		return finalEvaluation;
	}
}
