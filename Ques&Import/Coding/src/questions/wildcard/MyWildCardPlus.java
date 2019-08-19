package questions.wildcard;

public class MyWildCardPlus {

		public static void main(String[] args) {
			String pattern = "*c+??***+ba***+";
			String word = "jwsccuhokojojjbajijijj";
			test(pattern,word);
		}

		private static void test(String pattern, String word) {
			pattern = shrinkPattern(pattern);
			char[] patternArray = pattern.toCharArray();
			char[] wordArray = word.toCharArray();
			int patternLength = patternArray.length+1;
			int wordLength = wordArray.length+1;
			Datas[][] twoDArray = new Datas[wordLength][patternLength];
			for (int i = 0; i < wordLength; i++) {
				for (int j = 0; j < patternLength; j++) {
					twoDArray[i][j] = new Datas(false);
				}
			}
			
			twoDArray[0][0].value = true;
			for (int i = 1; i < patternLength; i++) {
				if (Character.valueOf(patternArray[i - 1]).equals(Character.valueOf('*'))) { 
					twoDArray[0][i].value = twoDArray[0][i - 1].value;
				}
			}
			
			for (int i = 1; i < wordLength; i++) {
				for (int j = 1; j < patternLength; j++) {
					if(Character.valueOf(wordArray[i-1]).equals(Character.valueOf(patternArray[j-1]))
							|| Character.valueOf(patternArray[j-1]).equals(Character.valueOf('?'))) {
						twoDArray[i][j].value = twoDArray[i-1][j-1].value;
						twoDArray[i][j].character = wordArray[i-1];
					}else if(Character.valueOf(patternArray[j-1]).equals(Character.valueOf('*'))) {
						twoDArray[i][j].value = twoDArray[i][j-1].value || twoDArray[i-1][j].value;
						twoDArray[i][j].character = wordArray[i-1];
					}else if(Character.valueOf(patternArray[j-1]).equals(Character.valueOf('+'))) {
						if(!Character.valueOf(patternArray[j-2]).equals(Character.valueOf('+'))
								|| !Character.valueOf(patternArray[j-2]).equals(Character.valueOf('*'))
								|| !Character.valueOf(patternArray[j-2]).equals(Character.valueOf('?'))) {
							if(Character.valueOf(patternArray[j-2]).equals(Character.valueOf(wordArray[i-1]))) {
								twoDArray[i][j].value = twoDArray[i-1][j-1].value;	
								twoDArray[i][j].character = wordArray[i-1];
							}else if(Character.valueOf(twoDArray[i-1][j-1].character).equals(Character.valueOf(wordArray[i-1]))) {
								twoDArray[i][j].value = twoDArray[i-1][j-1].value;	
								twoDArray[i][j].character = twoDArray[i-1][j-1].character;
							}
						}
					}
				}
			}
			
			print(twoDArray,wordLength,patternLength);
			System.out.println();
			System.out.println("Final OUTPUT : "+twoDArray[wordLength-1][patternLength-1].value);
		}

		private static void print(Datas[][] twoDArray,int patternLength,int wordLength) {
			for (int i = 0; i < patternLength; i++) {
				System.out.println("");
				for (int j = 0; j < wordLength; j++) {
					System.out.print(twoDArray[i][j].value + " ");
				}
			}
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

	class Datas {
		public Datas(boolean value) {
			this.value = value;
		}
		char character;
		boolean value;
	}