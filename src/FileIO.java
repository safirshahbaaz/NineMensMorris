import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* Utility Class for File I/O */
public class FileIO {
	
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
	public static void WriteOutputInFile(String file, Estimation estimate) {
		try {
			FileWriter fileWriter = new FileWriter(file);

			BufferedWriter buffer = new BufferedWriter(fileWriter);

			/* Write the output to file */
			buffer.write(NineMensMorris.BOARD_POSITION + estimate.getNineMensMorrisBoard());
			buffer.write("\n" + NineMensMorris.POSITION_EVALUATED + estimate.getPositionsEvaluated());
			buffer.write("\n" + NineMensMorris.MINIMAX_ESTIMATE + estimate.getEstimate());
			
			buffer.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
