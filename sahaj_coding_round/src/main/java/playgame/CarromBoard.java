package playgame;

import bean.Coins;
import bean.Player;
import enums.StrikeType;
import utils.DeciderUtil;

public class CarromBoard {	
	
	final static int PLAYERS = 2;
	
	private Player[] startGame(Integer[] inputs) {
		Player[] players = getPlayers(); 
		Coins coin = Coins.getInstance();
		int playerNo;
		
		for (Integer i = 0; i < inputs.length; i++) {
			StrikeType strike = StrikeType.getStrike(inputs[i]);
			playerNo = i % PLAYERS;
			if (strike.getPoints() < 0) {
				players[playerNo].setFoulCount(players[playerNo].getFoulCount() + 1);
			}

			if(strike.getStrikeOption() == 6) {
				int strikeCount = players[playerNo].getNonStrikeCount();
				players[playerNo].setNonStrikeCount(strikeCount+1);
				if(players[playerNo].getNonStrikeCount() == 3) {
					players[playerNo].setScore(players[playerNo].getScore() -1);
					players[playerNo].setNonStrikeCount(0);
				}
			}else {
				players[playerNo].setNonStrikeCount(0);
			}
			
			players[playerNo].setScore(players[playerNo].getScore() + strike.getPoints());

			if (DeciderUtil.foulCheck(players[playerNo])) {
				players[playerNo].setScore(players[playerNo].getScore() - 1);
				players[playerNo].setFoulCount(0);
			}
			if (strike.getCoinRemoved() == 5) {
				players[playerNo].setLastCoinRed(true);
				coin.setRedCoin(0);
			}else if(players[playerNo].isLastCoinRed() && (strike.getStrikeOption() == 1
					|| strike.getStrikeOption() == 2)) {
				players[playerNo].setLastCoinRed(false);
			}else {
				if(players[playerNo].isLastCoinRed()) {
					players[playerNo].setLastCoinRed(false);	
				}
				coin.setBlackCoin(coin.getBlackCoin() - strike.getCoinRemoved());
			}
			
			if (DeciderUtil.wonCheck(players) || DeciderUtil.areCoinsExhausted(coin)) {
				return players;
			}
		}

		return players;
	}
	
	private String getResult(Player[] players) {
		return DeciderUtil.result(players);
	}
	
	private Player[] getPlayers() {
		Player[] players = new Player[2];
		players[0] = new Player(1, 0, 0);
		players[1] = new Player(2, 0, 0);
		return players;
	}
	
	public String playCarrom(Integer[] inputs) {
		return getResult(startGame(inputs));
	}

}