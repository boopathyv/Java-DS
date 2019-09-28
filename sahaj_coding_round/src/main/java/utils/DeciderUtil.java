package utils;

import bean.Coins;
import bean.Player;

public class DeciderUtil {
	
	public static boolean foulCheck(Player player) {
		return player.getFoulCount() == 3;
	}
	
	public static boolean wonCheck(Player[] players) {
		return (Math.abs(players[0].getScore() - players[1].getScore()) >= 3 && 
				(players[0].getScore() >= 5 || players[1].getScore() >= 5));
	}
	
	public static boolean areCoinsExhausted(Coins coin) {
		return coin.getRedCoin() == 0 && coin.getBlackCoin() == 0 ? true : false;
	}
	
	public static String result(Player[] players) {
		StringBuilder result = new StringBuilder();
		if(wonCheck(players)) {
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