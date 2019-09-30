package utils;

import models.Coins;
import models.Player;

public class DeciderUtil {
	
	public static boolean checkForFoul(Player player) {
		return player.getFoulCount() == 3;
	}
	
	public static boolean checkForWin(Player[] players) {
		return (Math.abs(players[0].getScore() - players[1].getScore()) >= 3 && 
				(players[0].getScore() >= 5 || players[1].getScore() >= 5));
	}
	
	public static boolean hasCoinsExhausted(Coins coin) {
		return coin.getRedCoin() == 0 && coin.getBlackCoin() == 0 ? true : false;
	}
	
	public static String result(Player[] players) {
		StringBuilder result = new StringBuilder();
		if(checkForWin(players)) {
			 int won = players[0].getScore() > players[1].getScore() ? 0 : 1;
			 
			 result.append("Player ").append(won+1).append(" wins, score ")
			 	.append(players[0].getScore()).append("/").append(players[1].getScore());
		} else {
			 result.append("Draw, score ").append(players[0].getScore())
				.append("/").append(players[1].getScore());
		}
		return result.toString();                   
	}
}