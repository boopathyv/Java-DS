package questions.wildcard;

public class MyWildCard {

	public static void main(String[] args) {
		String pattern = "a*****b****c?d*e";
		String word = "atyhjkjboijoooooocodkme";
//		String pattern = "*****+ba***+";
//		String word = "baaabaaa";
		test(pattern,word);
	}

	private static void test(String pattern, String word) {
		pattern = shrinkPattern(pattern);
		char[] patternArray = pattern.toCharArray();
		char[] wordArray = word.toCharArray();
		int patternLength = patternArray.length+1;
		int wordLength = wordArray.length+1;
		Data[][] twoDArray = new Data[wordLength][patternLength];
		for (int i = 0; i < wordLength; i++) {
			for (int j = 0; j < patternLength; j++) {
				twoDArray[i][j] = new Data(false);
			}
		}
		twoDArray[0][0].value = true;
		for (int i = 1; i < wordLength; i++) {
			for (int j = 1; j < patternLength; j++) {
				if(Character.valueOf(wordArray[i-1]).equals(Character.valueOf(patternArray[j-1]))
						|| Character.valueOf(patternArray[j-1]).equals(Character.valueOf('?'))) {
					twoDArray[i][j].value = twoDArray[i-1][j-1].value;
					twoDArray[i][j].character = wordArray[j-1];
				}else if(Character.valueOf(patternArray[j-1]).equals(Character.valueOf('*'))) {
					twoDArray[i][j].value = twoDArray[i][j-1].value || twoDArray[i-1][j].value;
					twoDArray[i][j].character = wordArray[j-1];
				}
//				else if(Character.valueOf(patternArray[j-1]).equals(Character.valueOf('+'))) {
//					if(!Character.valueOf(patternArray[j-2]).equals(Character.valueOf('+'))
//							|| !Character.valueOf(patternArray[j-2]).equals(Character.valueOf('*'))
//							|| !Character.valueOf(patternArray[j-2]).equals(Character.valueOf('?'))) {
//						if(Character.valueOf(patternArray[j-2]).equals(Character.valueOf(wordArray[j-1]))) {
//							twoDArray[i][j].value = twoDArray[i-1][j-1].value;	
//							twoDArray[i][j].character = wordArray[j-1];
//						}else if(Character.valueOf(twoDArray[i-1][j-1].character).equals(Character.valueOf(wordArray[j-1]))) {
//							twoDArray[i][j].value = twoDArray[i-1][j-1].value;	
//							twoDArray[i][j].character = twoDArray[i-1][j-1].character;
//						}
//					}
//				}
			}
		}
		
		System.out.println(twoDArray[wordLength-1][patternLength-1].value);
	}

	private static String shrinkPattern(String pattern) {
		String newPattern = "";
		boolean isStar = false;
		char[] arr = pattern.toCharArray();
		for (int i = 0; i < pattern.length(); i++) {
			if(isStar && !Character.valueOf(arr[i]).equals(Character.valueOf('*'))) {
				isStar = false;
				newPattern += String.valueOf(arr[i]);
			}else if(!isStar && !Character.valueOf(arr[i]).equals(Character.valueOf('*'))) {
				newPattern += String.valueOf(arr[i]);
			}else if(isStar && Character.valueOf(arr[i]).equals(Character.valueOf('*'))) {
				isStar = true;
			}else if(Character.valueOf(arr[i]).equals(Character.valueOf('*'))) {
				isStar = true;
				newPattern += String.valueOf(arr[i]);
			}
		}
		return newPattern;
	}
}

class Data {
	public Data(boolean value) {
		this.value = value;
	}
	char character;
	boolean value;
}