package models;

public class Player{
	private Integer id;
	private Integer score;
	private Integer foulCount;
	private Integer nonStrikeCount;
	private boolean isLastCoinRed;

	public Player(Integer id) {
		this.id = id;
		this.score = 0;
		this.foulCount = 0;
		this.nonStrikeCount = 0;
		this.isLastCoinRed = false;
	}
	
	public int getNonStrikeCount() {
		return this.nonStrikeCount;
	}

	public void setNonStrikeCount(int count) {
		this.nonStrikeCount = count;
	}

	public boolean isLastCoinRed() {
		return this.isLastCoinRed;
	}

	public void setLastCoinRed(boolean isRed) {
		this.isLastCoinRed = isRed;
	}
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getFoulCount() {
		return foulCount;
	}

	public void setFoulCount(Integer foulCount) {
		this.foulCount = foulCount;
	}

	public Integer getId() {
		return id;
	}
}