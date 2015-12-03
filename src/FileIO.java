import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.DataInputStream;
import java.util.Scanner;

/* Utility Class for File I/O */
public class FileIO {
	
	/*###Function to receive input and place piece on the board during game first phase*/
	public static boolean placeNewPiece(NineMensMorris obj) throws IOException{
		while (true){
			try{
			
				System.out.println("\nWhere do you want to place WHITE piece?:");
				//DataInputStream dis = new DataInputStream(System.in);
				Scanner userInput = new Scanner(System.in);
				String charPosition = userInput.next();
				int n = Integer.parseInt(charPosition);
				PositionValue p= obj.getValueAtPosition(n);
				if (p == PositionValue.X) {
					obj.setPositionValue(PositionValue.W, n);
					if (NineMensMorrisLogic.isCloseMill(n, obj)) removePiece(obj);
					return true;
				}
				else{
					System.out.println("\nThere's already a piece there genius!");
				}
			}
			catch(Exception e){
				System.out.println("\nError while accepting Input...");
			}
		}
	}
	
	/*###Function to receive input and place piece on board: during mid game*/
	public static boolean movePiece(NineMensMorris obj) throws IOException{
		while (true){
			try{
				System.out.println("\nWhich WHITE piece do you want to move?:");
				//DataInputStream dis = new DataInputStream(System.in);
				Scanner userInput = new Scanner(System.in);
				String charPosition = userInput.next();
				int from = Integer.parseInt(charPosition);
				PositionValue p= obj.getValueAtPosition(from);
				if (p != PositionValue.W) {
					System.out.println("\nYou do realize there is no WHITE piece there?");
					continue;
				}
				while (true){
					System.out.println("Where do you want to place your WHITE piece?:");
					Scanner userInput2 = new Scanner(System.in);
					String charPosition2 = userInput.next();
					//DataInputStream diss = new DataInputStream(System.in);
					int to = Integer.parseInt(charPosition2);
					PositionValue p1= obj.getValueAtPosition(to); 
					if (p1 == PositionValue.X) {
							obj.setPositionValue(PositionValue.W,to);
							obj.setPositionValue(PositionValue.X,from);
							
							System.out.println("\nWHITE moved...");
							
							if (NineMensMorrisLogic.isCloseMill(to, obj)){
								removePiece(obj);
							}
							return true;
					}
					else {
							System.out.println("\nNope, Can't move there buddy!");
							continue;
					}
				}
			}
			catch(Exception e){
				System.out.println("Error while accepting Input!");
			}
		}
	}
	
	
	/*### Function to remove opponent's piece once your mill is formed...take note that you cannot remove pieces that are part of a mill*/
	public static boolean removePiece(NineMensMorris obj) throws IOException{
		while (true){
			try{
				System.out.println("\nWhich BLACK piece do you want to remove?:");
				//DataInputStream dis = new DataInputStream(System.in);
				Scanner userInput = new Scanner(System.in);
				String charPosition = userInput.next();
				int n = Integer.parseInt(charPosition);
				PositionValue p= obj.getValueAtPosition(n);
				if (p == PositionValue.B && !NineMensMorrisLogic.isCloseMill(n, obj)){
					obj.setPositionValue(PositionValue.X,n);	
					return true;
				}
				else System.out.println("\nInvalid Position, Can't remove that buddy!");
				continue;
			}
			catch(Exception e){
				System.out.println("Error while accepting Input");
			}
		}
	}
	

	
	/* Read from the file and initialize the board */
	public static NineMensMorris getInputPositions(String path) throws IOException {
		NineMensMorris board = null;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";

			/* Read the line from the file and insert into Character List */
			if ((line = br.readLine()) != null){
				board = new NineMensMorris(line.toCharArray());
			}
			/* Fail safe: Return an empty board filled with X's */
			else{
				board = new NineMensMorris();
			}

			br.close();
		} 
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return board;
	}
	
	/* Write the results of computation to the result file */
	public static void WriteOutputInFile(String file, Evaluation evaluation) {
		try {
			FileWriter fileWriter = new FileWriter(file);

			BufferedWriter buffer = new BufferedWriter(fileWriter);

			/* Write the output to file */
			buffer.write(NineMensMorris.BOARD_POSITION + evaluation.getNineMensMorrisBoard());
			buffer.write("\n" + NineMensMorris.POSITION_EVALUATED + evaluation.getPositionsEvaluated());
			buffer.write("\n" + NineMensMorris.MINIMAX_ESTIMATE + evaluation.getEvaluation());
			
			buffer.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
