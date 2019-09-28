package models;

public class Coins {
	private Integer redCoin;
	private Integer blackCoin;
	
	private Coins() {
		redCoin = 1;
		blackCoin = 9;
	}
	
	public static Coins getInstance() {
		return new Coins();
	}

	public Integer getRedCoin() {
		return redCoin;
	}

	public void setRedCoin(Integer redCoin) {
		this.redCoin = redCoin;
	}

	public Integer getBlackCoin() {
		return blackCoin;
	}

	public void setBlackCoin(Integer blackCoin) {
		this.blackCoin = blackCoin;
	}
}
