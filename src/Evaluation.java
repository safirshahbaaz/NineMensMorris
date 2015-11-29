
public class Evaluation {
	/* Private Variable Declarations */
	private int evaluation = 0;
	private int positionsEvaluated = 0;
	private NineMensMorris board;

	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public int getPositionsEvaluated() {
		return positionsEvaluated;
	}

	public void setPositionsEvaluated(int positionsEvaluated) {
		this.positionsEvaluated = positionsEvaluated;
	}
	
	public NineMensMorris getNineMensMorrisBoard() {
		return board;
	}

	public void setNineMensMorrisBoard(NineMensMorris inputBoard) {
		board = inputBoard;
	}
}
