package starter;

import java.util.Arrays;
import java.util.List;

import enums.StrikeType;
import models.Coins;
import models.Player;
import utils.DeciderUtil;

public class CarromBoard {	
	
	private final int NO_OF_PLAYERS = 2;
	
	private final List<Integer> nonStrikerList = Arrays.asList(4,5,6);
	
	private Player[] startGame(Integer[] inputs) {
		Player[] players = getPlayers(); 
		Coins coin = Coins.getInstance();
		int playerNo = 0;
		
		for (Integer i = 0; i < inputs.length; i++) {
			StrikeType strike = StrikeType.getStrike(inputs[i]);
			playerNo = i % NO_OF_PLAYERS;
			if (strike.getPoints() < 0) {
				players[playerNo].setFoulCount(players[playerNo].getFoulCount() + 1);
			}

			if(nonStrikerList.contains(strike.getStrikeType())) {
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

			if (DeciderUtil.checkForFoul(players[playerNo])) {
				players[playerNo].setScore(players[playerNo].getScore() - 1);
				players[playerNo].setFoulCount(0);
			}
			if (strike.getCoinRemoved() == 5) {
				players[playerNo].setLastCoinRed(true);
				coin.setRedCoin(0);
			}else if(players[playerNo].isLastCoinRed() && (strike.getStrikeType() == 1
					|| strike.getStrikeType() == 2)) {
				players[playerNo].setLastCoinRed(false);
			}else {
				if(players[playerNo].isLastCoinRed()) {
					players[playerNo].setLastCoinRed(false);	
				}
				coin.setBlackCoin(coin.getBlackCoin() - strike.getCoinRemoved());
			}
			
			if (DeciderUtil.checkForWin(players) || DeciderUtil.hasCoinsExhausted(coin)) {
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
		players[0] = new Player(1);
		players[1] = new Player(2);
		return players;
	}
	
	public String playCarrom(Integer[] inputs) {
		Player[] players = startGame(inputs);
		return getResult(players);
	}

}