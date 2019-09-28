package models;

public class Player{
	private Integer id;
	private Integer score;
	/**
	 * stores the count for flagging foul
	 * foul -- happens when a player looses at least one point three times
	 */
	private Integer foulCount;
	private boolean isLastCoinRed;
	private Integer nonStrikeCount;

	public Player(Integer id, Integer score, Integer foulCount) {
		this.id = id;
		this.score = score;
		this.foulCount = foulCount;
		this.isLastCoinRed = false;
		this.nonStrikeCount = 0;
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
