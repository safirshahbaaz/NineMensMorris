import java.util.ArrayList;
import java.util.Arrays;

/* Main logic class of Nine Mens Morris */
public class NineMensMorrisLogic {
	
	/* Get array of neighbors for the given position */
	public static ArrayList<Integer> adjacentLocations(int position) {
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		
		switch(position) {
			case 0  : neighbors.addAll(Arrays.asList(1, 3)); break;
			case 1  : neighbors.addAll(Arrays.asList(0, 2, 9)); break;
			case 2  : neighbors.addAll(Arrays.asList(1, 4)); break;
			case 3  : neighbors.addAll(Arrays.asList(0, 5, 11)); break;
			case 4  : neighbors.addAll(Arrays.asList(2, 7, 12)); break;
			case 5  : neighbors.addAll(Arrays.asList(3, 6)); break;
			case 6  : neighbors.addAll(Arrays.asList(5, 7, 14)); break;
			case 7  : neighbors.addAll(Arrays.asList(4, 6)); break;
			case 8  : neighbors.addAll(Arrays.asList(9, 11));break;
			case 9  : neighbors.addAll(Arrays.asList(1, 8, 10, 17)); break;
			case 10 : neighbors.addAll(Arrays.asList(9, 12)); break;
			case 11 : neighbors.addAll(Arrays.asList(3, 8, 13, 19)); break;
			case 12 : neighbors.addAll(Arrays.asList(4, 10, 15, 20)); break;
			case 13 : neighbors.addAll(Arrays.asList(11, 14)); break;
			case 14 : neighbors.addAll(Arrays.asList(6, 13, 15, 22)); break;
			case 15 : neighbors.addAll(Arrays.asList(12, 14)); break;
			case 16 : neighbors.addAll(Arrays.asList(17, 19)); break;
			case 17 : neighbors.addAll(Arrays.asList(9, 16, 18)); break;
			case 18 : neighbors.addAll(Arrays.asList(17, 20)); break;
			case 19 : neighbors.addAll(Arrays.asList(11, 16, 21)); break;
			case 20 : neighbors.addAll(Arrays.asList(12, 18, 23)); break;
			case 21 : neighbors.addAll(Arrays.asList(19, 22)); break;
			case 22 : neighbors.addAll(Arrays.asList(21, 23, 14)); break;
			case 23 : neighbors.addAll(Arrays.asList(20, 22)); break;
			default : System.out.println("Invalid position on the board"); break;
		}
		return neighbors;
	}
	
	/* Check if a mill has been formed with the current piece placement */
	public static boolean checkMillFormation(int position, NineMensMorris board, PositionValue c){
		boolean value = false;
		
		switch(position){
			case 0  : value = (isMill(c, board, 1, 2)   || isMill(c, board, 3, 5)); break;
			case 1  : value = (isMill(c, board, 0, 2)   || isMill(c, board, 9, 17)); break;
			case 2  : value = (isMill(c, board, 0, 1)   || isMill(c, board, 4, 7)); break;
			case 3  : value = (isMill(c, board, 0, 5)   || isMill(c, board, 11, 19)); break;
			case 4  : value = (isMill(c, board, 2, 7)   || isMill(c, board, 12, 20)); break;
			case 5  : value = (isMill(c, board, 0, 3)   || isMill(c, board, 6, 7)); break;
			case 6  : value = (isMill(c, board, 5, 7)   || isMill(c, board, 14, 22)); break;
			case 7  : value = (isMill(c, board, 2, 4)   || isMill(c, board, 5, 6)); break;
			case 8  : value = (isMill(c, board, 9, 10)  || isMill(c, board, 11, 13)); break;
			case 9  : value = (isMill(c, board, 8, 10)  || isMill(c, board, 1, 17)); break;
			case 10 : value = (isMill(c, board, 8, 9)   || isMill(c, board, 12, 15)); break;
			case 11 : value = (isMill(c, board, 3, 19)  || isMill(c, board, 8, 13)); break;
			case 12 : value = (isMill(c, board, 20, 4)  || isMill(c, board, 10, 15)); break;
			case 13 : value = (isMill(c, board, 8, 11)  || isMill(c, board, 14, 15)); break;
			case 14 : value = (isMill(c, board, 13, 15) || isMill(c, board, 6, 22)); break;
			case 15 : value = (isMill(c, board, 13, 14) || isMill(c, board, 10, 12)); break;
			case 16 : value = (isMill(c, board, 17, 18) || isMill(c, board, 19, 21)); break; 
			case 17 : value = (isMill(c, board, 1, 9)   || isMill(c, board, 16, 18)); break;
			case 18 : value = (isMill(c, board, 16, 17) || isMill(c, board, 20, 23)); break;
			case 19 : value = (isMill(c, board, 16, 21) || isMill(c, board, 3, 11)); break;
			case 20 : value = (isMill(c, board, 12, 4)  || isMill(c, board, 18, 23)); break;
			case 21 : value = (isMill(c, board, 16, 19) || isMill(c, board, 22, 23)); break;
			case 22 : value = (isMill(c, board, 6, 14)  || isMill(c, board, 21, 23)); break;
			case 23 : value = (isMill(c, board, 18, 20) || isMill(c, board, 21, 22)); break;
			default : System.out.println("Invalid board position"); break;
		}
		return value;
	}
	
	/* Return true if there are three pieces of the same color in a row or column */
	public static boolean isMill(PositionValue c, NineMensMorris morrisBoard, int position1, int position2){
		boolean value = false;
		
		if ((morrisBoard.getValueAtPosition(position1) == c) && (morrisBoard.getValueAtPosition(position2) == c)){
			value = true;
		}
		return value;
	}
	
	/* Return true if a mill has been formed by the placement of the piece */
	public static boolean isCloseMill(int pos, NineMensMorris board) {
		boolean value = false;
		PositionValue c = board.getValueAtPosition(pos);
		
		if (c != PositionValue.X) {
			/* Check if Mill has formed */
			value = checkMillFormation(pos, board, c);
		} 
		else {
			/* Mill has not been formed */
		}
		return value;
	}
	
	/* Add a white piece to all possible empty positions for the purpose of heuristics */
	public static ArrayList<NineMensMorris> addPieces(NineMensMorris mb) 
	{
		ArrayList<NineMensMorris> boardList = new ArrayList<NineMensMorris>();
		
		for(int iter = 0; iter < mb.boardPositions.size(); iter++) {
			
			/* If the position has an X, then it is empty */
			if(mb.getValueAtPosition(iter) == PositionValue.X) {
				NineMensMorris boardCopy = mb.getBoardCopy();
				
				boardCopy.setPositionValue(PositionValue.W, iter);
				
				if(isCloseMill(iter, boardCopy)) {
					boardList = removePiece(boardCopy, boardList);
				} 
				else {
					boardList.add(boardCopy);
				}
			}
		}
		return boardList;
	}
	
	/* Add pieces to the board on only adjacent positions as 
	 * Mid game phase requires */
	public static ArrayList<NineMensMorris> addPiecesForMidgame(NineMensMorris board) 
	{
		ArrayList<NineMensMorris> boardList = new ArrayList<NineMensMorris>();
		
		for (int iter = 0; iter < board.boardPositions.size(); iter++) {
			
			if (board.getValueAtPosition(iter) == PositionValue.W) {
				
				/* Get the adjacent locations for the current position */
				ArrayList<Integer> adjLocations = adjacentLocations(iter);
				
				for (Integer loc : adjLocations) {
					
					/* Place the piece at an empty location if found */
					if (board.getValueAtPosition(loc) == PositionValue.X){
						
						NineMensMorris boardCopy = board.getBoardCopy();
						
						boardCopy.setPositionValue(PositionValue.X, iter);
						boardCopy.setPositionValue(PositionValue.W, loc);
						
						if (isCloseMill(loc, boardCopy)) {
							boardList = removePiece(boardCopy, boardList);
						} 
						else {
							boardList.add(boardCopy);
						}
					}
				}
			}
		}
		return boardList;
	}
	
	/* Remove piece if a Mill has formed */
	public static ArrayList<NineMensMorris> removePiece(NineMensMorris boardCopy, ArrayList<NineMensMorris> boardList) {
		for (int iter = 0; iter < boardCopy.boardPositions.size(); iter++) 
		{
			if (boardCopy.getValueAtPosition(iter) == PositionValue.B) 
			{
				// if not a close Mill
				if (!isCloseMill(iter, boardCopy)) 
				{
					NineMensMorris newBoardCopy = boardCopy.getBoardCopy();
					newBoardCopy.setPositionValue(PositionValue.X, iter);
					boardList.add(newBoardCopy);
				}
			}
		}
		return boardList;
	}
	
	/* Create moves for the end game where restrictions of adjacency are removed */
	public static ArrayList<NineMensMorris> addPiecesForHopping(NineMensMorris mb){
		ArrayList<NineMensMorris> boardList = new ArrayList<NineMensMorris>();

		/* for every location (i) - alpha in the board */
		for (int i = 0; i < mb.boardPositions.size(); i++) {
			/* Find a position with piece W */
			if (mb.getValueAtPosition(i) == PositionValue.W) {
				
				/* For every position on the board that is empty*/
				for (int j = 0; j < mb.boardPositions.size(); j++) {
					
					if (mb.getValueAtPosition(j) == PositionValue.X) {
						NineMensMorris boardCopy = mb.getBoardCopy();
						
						boardCopy.setPositionValue(PositionValue.X, i);
						boardCopy.setPositionValue(PositionValue.W, j);
						
						/* If a Mill is closed */
						if (isCloseMill(j, boardCopy)) {
							boardList = removePiece(boardCopy, boardList);
						} 
						else {
							boardList.add(boardCopy);
						}
					}
				}
			}
		}
		return boardList;
	}
	
	/* Generate Moves for Opening Phase for White */
	public static ArrayList<NineMensMorris> addPiecesForOpeningMoves(NineMensMorris mb){
		return addPieces(mb);
	}
	
	/* Generate Moves for Opening Phase for Black */
	public static ArrayList<NineMensMorris> addPiecesForOpeningMovesBlack(NineMensMorris mb){
		/* Get Inverted version of the board for Black */
		NineMensMorris boardBlack = mb.getInvertedBoard();
		
		ArrayList<NineMensMorris> listPositionsBlack = addPiecesForOpeningMoves(boardBlack);
		
		/* Possible Moves for Black */
		ArrayList<NineMensMorris> possibleMovesBlack = generateInvertedBoardList(listPositionsBlack);

		return possibleMovesBlack;
	}
	
	/* Moves for the 2nd and last phase of the game for White */
	public static ArrayList<NineMensMorris> addPiecesforMidgameAndEndGame(NineMensMorris mb){
		/* Check if game has entered end phase to enable hopping i.e. restrictions of adjacency are removed */
		if (mb.getNumberOfPieces(PositionValue.W) == NineMensMorris.END_GAME_PIECES){
			return addPiecesForHopping(mb);
		} 
		/* Game is in the second phase */
		else{
			return addPiecesForMidgame(mb);
		}
	}
	
	/* Moves for the 2nd and last phase for Black */
	public static ArrayList<NineMensMorris> addPiecesforMidgameAndEndgameBlack(NineMensMorris mb){
		NineMensMorris invertedBoard = mb.getInvertedBoard();
		
		/* Return the Inverted board list for Black */
		return generateInvertedBoardList(addPiecesforMidgameAndEndGame(invertedBoard));
	}
	
	/* Get the inverted board for each of the boards */
	public static ArrayList<NineMensMorris> generateInvertedBoardList(ArrayList<NineMensMorris> listPositionsBlack){
		int iter;
		// for every possible board positions in the list- flip the pieces
		for (iter = 0; iter < listPositionsBlack.size(); iter++) {
			NineMensMorris tempBoard = listPositionsBlack.get(iter).getInvertedBoard();
			listPositionsBlack.set(iter, tempBoard);
		}
		return listPositionsBlack;
	}
	
	/*  */
	public static int getPossibleMillCount(NineMensMorris board, PositionValue value){
		int millCount = 0;
		
		for(int iter = 0; iter < board.boardPositions.size(); iter++){
			
			if(board.getValueAtPosition(iter) == PositionValue.X){
				
				if(checkMillFormation(iter, board, value)){
					millCount++;
				}
			}
		}
		return millCount;
	}
	
	/* Evaluation Function for the 1st phase of the game.
	 * Number of White Pieces - Number of Black Pieces + Number of Mills Possible */
	public static int getEvaluationForOpeningPhase(NineMensMorris board){
		int numWhitePieces = board.getNumberOfPieces(PositionValue.W); 
		int numBlackPieces = board.getNumberOfPieces(PositionValue.B);
		int numPossibleMills = getPossibleMillCount(board, PositionValue.W);
		
		return numWhitePieces - numBlackPieces + numPossibleMills;
	}
	
	/* Evaluation Function for the 2nd and final phase of the game. */
	public static int getEvaluationForMidGameAndEndGame(NineMensMorris board){

		int numWhitePieces = board.getNumberOfPieces(PositionValue.W); 
		int numBlackPieces = board.getNumberOfPieces(PositionValue.B);
		int numPossibleMills = getPossibleMillCount(board, PositionValue.W);
		int numBlackMoves;
		int evaluationValue = 0;
		
		ArrayList<NineMensMorris> boardList = addPiecesforMidgameAndEndGame(board);
		
		 numBlackMoves = boardList.size();
		
		/* Game is won if the number of black pieces is less than 3 */ 
		if(numBlackPieces <= 2){
			evaluationValue = 10000;
		}
		/* Game is won if all Black pieces are blocked */
		else if (numBlackMoves == 0){
			evaluationValue = 10000;
		}
		/* Game is lost if number of white pieces is less than 3 */
		else if(numWhitePieces <= 2){
			evaluationValue = -10000;
		}
		/* Game still in progress */
		else{
			evaluationValue = (1000 * (numWhitePieces + numPossibleMills - numBlackPieces) - numBlackMoves);
		}
		return evaluationValue;	
	}
	
	public static boolean potentialMillInFormation(int location, NineMensMorris board, PositionValue p){
		boolean value = false;
		ArrayList<Integer> adjLocations = adjacentLocations(location);
		
		for(Integer loc : adjLocations){
			if (board.getValueAtPosition(loc) == p && !checkMillFormation(location, board, p)){
				//System.out.println("I entered this");
				value = true;
			}	
		}
		return value;
	}
	
	public static int getPiecesInPotentialMillFormation(NineMensMorris board, PositionValue p){
		int count = 0;
		
		for(int iter = 0; iter < board.boardPositions.size(); iter++){
			
			if(board.getValueAtPosition(iter) == p){
				
				/* Get the adjacent locations for the current position */
				ArrayList<Integer> adjLocations = adjacentLocations(iter);
				
				for (Integer loc : adjLocations) {
					
					/* Check if there are 2 pieces in adjacent locations but not in a mill */
					if(p == PositionValue.W){
						if (board.getValueAtPosition(loc) == PositionValue.B && potentialMillInFormation(loc, board, PositionValue.B)){
							count++;
						}
					}
					else{
						if (board.getValueAtPosition(loc) == PositionValue.W && potentialMillInFormation(loc, board, PositionValue.W)){
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	
	public static int getEvaluationImproved(NineMensMorris board, boolean isOpeningPhase){
		int evaluationValue = 0;
		
		int numWhitePieces = board.getNumberOfPieces(PositionValue.W); 
		int numBlackPieces = board.getNumberOfPieces(PositionValue.B);
		
		int numPossibleMillsWhite = getPossibleMillCount(board, PositionValue.W);
		int numPossibleMillsBlack = getPossibleMillCount(board, PositionValue.B);
		
		int movablePiecesWhite = 0;
		int movablePiecesBlack = 0;
		
		if(!isOpeningPhase){
			//ArrayList<NineMensMorris> boardListWhite = addPiecesforMidgameAndEndGame(board);
			ArrayList<NineMensMorris> boardListBlack = addPiecesforMidgameAndEndgameBlack(board);
			
			//movablePiecesWhite = boardListWhite.size();
			movablePiecesBlack = boardListBlack.size();
		}
		
		int potentialMillsWhite = getPiecesInPotentialMillFormation(board, PositionValue.W);
		int potentialMillsBlack = getPiecesInPotentialMillFormation(board, PositionValue.B);
		
		if(numBlackPieces <= 2){
			evaluationValue = 100000;
		}
		/* Game is won if all Black pieces are blocked */
		else if (movablePiecesBlack == 0){
			evaluationValue = 100000;
		}
		/* Game is lost if number of white pieces is less than 3 */
		else if(numWhitePieces <= 2){
			evaluationValue = -100000;
		}
		else{
			evaluationValue = 100 * (numWhitePieces - numBlackPieces);
			evaluationValue += 600 * (numPossibleMillsWhite); //- numPossibleMillsBlack);
			evaluationValue -= 10 * movablePiecesBlack;
			evaluationValue += 500 * potentialMillsWhite;
		}
		
		return evaluationValue;
	}
}
