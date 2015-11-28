
public class Estimation {
	/* Private Variable Declarations */
	private int estimate = 0;
	private int positionsEvaluated = 0;
	private NineMensMorris board;

	public int getEstimate() {
		return estimate;
	}

	public NineMensMorris getNineMensMorrisBoard() {
		return board;
	}

	public void setNineMensMorrisBoard(NineMensMorris inputBoard) {
		board = inputBoard;
	}

	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	public int getPositionsEvaluated() {
		return positionsEvaluated;
	}

	public void setPositionsEvaluated(int positionsEvaluated) {
		this.positionsEvaluated = positionsEvaluated;
	}
}
