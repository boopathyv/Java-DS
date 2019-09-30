package enums;

import java.util.stream.Stream;

public enum StrikeType {
	  STRIKE(1, 1, 1),
	  MULTI_STRIKE(2, 2, 0), 
	  RED_STRIKE(3, 3, 5), // 5 denotes that the red coin has been striked
	  STRIKER_STRIKE(4, -1, 0),
	  DEFUNCT_COIN(5, -2, 1),
	  NO_STRIKE(6,0,0),
	  NONE(0,0,0);
	
    private Integer strikeType;

	private Integer points;
	
	private Integer coinToBeRemoved;
	
	private StrikeType(Integer strikeType, Integer points, Integer coinToBeRemoved) {
		this.strikeType = strikeType;
		this.points = points;
		this.coinToBeRemoved = coinToBeRemoved;
	}
	
	public static StrikeType getStrike(int strikeType) {
		return Stream.of(StrikeType.values())
				.filter(choice -> choice.strikeType == strikeType)
				.findFirst().orElse(NONE);
	}
	
	public Integer getStrikeType() {
		return strikeType;
	}

	public Integer getPoints() {
		return points;
	}

	public Integer getCoinRemoved() {
		return coinToBeRemoved;
	}	
}