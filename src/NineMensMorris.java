import java.util.ArrayList;

enum PositionValue {
	/* Enums to define position states */
	X('x'), W('W'), B('B');
	char position;
	
	PositionValue(char tempPosition) {
		position = tempPosition;
	}
}

/* Utility class for Nine Mens Morris */
public class NineMensMorris {
	/* Constants needed for Nine Mens Morris */
	public static final int BOARD_SIZE = 24;
	public static final String BOARD_POSITION = "BoardPosition: ";
	public static final String POSITION_EVALUATED = "Positions Evaluated By Static Estimation: ";
	public static final String MINIMAX_ESTIMATE = "Minimax Estimate: ";
	public static final int END_GAME_PIECES = 3;
	
	ArrayList<PositionValue> boardPositions;
	
	/* Constructor to initialize the board */
	public NineMensMorris(){
		boardPositions = new ArrayList<PositionValue>();
		/* Initialize the board to all X's to denote empty board */
		for(int iter = 0; iter < BOARD_SIZE; iter++){
			boardPositions.add(PositionValue.X);
		}
	}
	
	/* Constructor to set up the board using an input file */
	public NineMensMorris(char inputTextFileString[]){
		boardPositions = new ArrayList<PositionValue>();
		
		if(inputTextFileString.length == BOARD_SIZE){
			for(char c : inputTextFileString){
				if(c == 'W'){
					boardPositions.add(PositionValue.W);
				}
				else if(c == 'B'){
					boardPositions.add(PositionValue.B);
				}
				else if(c == 'X'){
					boardPositions.add(PositionValue.X);
				}
				else{
					System.out.println("Invalid character found in the input string!");
				}
			}
		}
		else{
			System.out.println("Number of characters in the input string are less than board positions");
		}
	}
	
	/* Return the Board Positions String */
	public String toString(){
		char outputString [] = new char[boardPositions.size()];
		
		for (int iter = 0; iter < boardPositions.size(); iter++){
			outputString[iter] = boardPositions.get(iter).position;
		}
		
		String outputPositions = new String(outputString);
		return outputPositions;
	}
	
	/* Get a copy of the board */
	public NineMensMorris getBoardCopy(){
		NineMensMorris board = null;
		char positionValues[] = new char[boardPositions.size()];
		
		for (int iter = 0; iter < boardPositions.size(); iter++){
			positionValues[iter] = boardPositions.get(iter).position;
		}

		board = new NineMensMorris(positionValues);
		return board;
	}
	
	/* Get the piece placed in the given index */
	public PositionValue getValueAtPosition(int position){
		PositionValue p = boardPositions.get(position);
		return p;
	}
	
	/* Get the number of pieces on the board */
	public int getNumberOfPieces(PositionValue p){
		int count = 0;
		for (PositionValue temp : boardPositions){
			if (temp == p){
				count++;
			}
		}
		return count;
	}
	
	/* Insert a piece at the specified index */
	public void setPositionValue(PositionValue p, int index){
		boardPositions.set(index, p);
	}
	
	/* Get inverted copy of the board */
	public NineMensMorris getInvertedBoard(){
		NineMensMorris invertedBoard = new NineMensMorris();
		
		for (int iter = 0; iter < boardPositions.size(); iter++){
			PositionValue boardPV = boardPositions.get(iter);
			
			/* If the value is W, then invert it to B */
			if (boardPV == PositionValue.W){
				invertedBoard.setPositionValue(PositionValue.B, iter);
			}
			/* If the value is B, then invert it to W */
			else if (boardPV == PositionValue.B){
				invertedBoard.setPositionValue(PositionValue.W, iter);
			} 
			else{
				invertedBoard.setPositionValue(PositionValue.X, iter);
			}
		}
		return invertedBoard;
	}
}
