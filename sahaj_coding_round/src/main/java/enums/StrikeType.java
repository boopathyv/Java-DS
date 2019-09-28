package enums;

import java.util.stream.Stream;

public enum StrikeType {
	  STRIKE(1, 1, 1),
	  MULTI_STRIKE(2, 2, 0), 
	  RED_STRIKE(3, 3, 5), // 5 denotes the red coin has been striked
	  STRIKER_STRIKE(4, -1, 0),
	  DEFUNCT_COIN(5, -2, 1), 
	  NONE(6, 0, 0);
	
    private Integer strikeOptions;

	private Integer points;
	
	private Integer coinToBeRemoved;
	
	private StrikeType(Integer strikeOptions, Integer points, Integer coinToBeRemoved) {
		this.strikeOptions = strikeOptions;
		this.points = points;
		this.coinToBeRemoved = coinToBeRemoved;
	}
	public static StrikeType getStrike(int strikeOption) {
		return Stream.of(StrikeType.values())
				.filter(choice -> choice.strikeOptions == strikeOption)
				.findFirst().orElse(StrikeType.NONE);
	}
	
	public Integer getStrikeOption() {
		return strikeOptions;
	}

	public Integer getPoints() {
		return points;
	}

	public Integer getCoinRemoved() {
		return coinToBeRemoved;
	}	
}