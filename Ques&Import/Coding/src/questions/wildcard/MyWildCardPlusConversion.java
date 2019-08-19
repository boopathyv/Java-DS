package questions.wildcard;

public class MyWildCardPlusConversion {

		public static void main(String[] args) {
			String pattern = "*****+ba***+";
			String word = "baaabaeaa";
			System.out.println(test(pattern,word));
		}

		private static boolean test(String patternString, String word) {
			patternString = shrinkPattern(patternString);
			char[] pattern = patternString.toCharArray();
			char[] str = word.toCharArray();
			int m = pattern.length;
			int n = str.length;

			// empty pattern can only match with 
			// empty string 
			if (m == 0) 
				return (n == 0); 

			// If first character of pattern is '+' 
			if (pattern[0] == '+') 
				return false; 

			// lookup table for storing results of 
			// subproblems 
			Dataz[][] lookup = new Dataz[m + 1][n + 1]; 

			// initialize lookup table to false 
			for (int i = 0; i <= m; i++) 
				for (int j = 0; j <= n; j++) { 
					lookup[i][j] = new Dataz(' ',false); 
				} 
				
			// empty pattern can match with 
			// empty string 
			lookup[0][0].value = true; 

			// Only '*' can match with empty string 
			for (int j = 1; j <= m; j++) 
				if (Character.valueOf(pattern[j - 1]).equals(Character.valueOf('*'))) 
					lookup[j][0].value = lookup[j - 1][0].value; 

			// fill the table in bottom-up fashion 
			for (int i = 1; i <= m; i++) { 
				for (int j = 1; j <= n; j++) { 

					// Two cases if we see a '*' 
					// a) We ignore ‘*’ character and move 
					// to next character in the pattern, 
					// i.e., ‘*’ indicates an empty sequence. 
					// b) '*' character matches with ith 
					// character in input 
					if (Character.valueOf(pattern[i - 1]).equals(Character.valueOf('*'))) { 
						lookup[i][j].value = lookup[i][j - 1].value || lookup[i - 1][j].value; 
						lookup[i][j].ch = str[j - 1]; 
					} 

					// Current characters are considered as 
					// matching in two cases 
					// (a) current character of pattern is '?' 
					else if (Character.valueOf(pattern[i - 1]).equals(Character.valueOf('?'))) { 
						lookup[i][j].value = 
								lookup[i - 1][j - 1].value; 
						lookup[i][j].ch = str[j - 1]; 
					} 

					// (b) characters actually match 
					else if (Character.valueOf(str[j - 1]).equals(Character.valueOf(pattern[i - 1]))) { 
						lookup[i][j].value = lookup[i - 1][j - 1].value; 
					}
					// Current character match 
					else if (Character.valueOf(pattern[i - 1]).equals(Character.valueOf('+'))) { 

						// case 1: if previous character is 
						// not symbol 
						if (!Character.valueOf(pattern[i - 2]).equals(Character.valueOf('+')) ||
								!Character.valueOf(pattern[i - 2]).equals(Character.valueOf('*')) ||
								!Character.valueOf(pattern[i - 2]).equals(Character.valueOf('?'))) 
							if (Character.valueOf(pattern[i - 2]).equals(Character.valueOf(str[j - 1]))) { 
								lookup[i][j].value = lookup[i - 1][j - 1].value; 
								lookup[i][j].ch = str[j - 1]; 
							} 

							// case 2 : if previous character 
							// is symbol (+, *, ? ) then we 
							// compare current text character 
							// with the character that is used by 
							// the symbol at that point. we 
							// access it by lookup[i-1][j-1]
							else if(Character.valueOf(str[j-1]).equals(Character.valueOf(lookup[i-1][j-1].ch))){ 
								lookup[i][j].value = lookup[i - 1][j - 1].value; 
								lookup[i][j].ch = lookup[i - 1][j - 1].ch; 
							} 

							// If characters don't match 
							else
								lookup[i][j].value = false; 
					}
				} 
			} 

			return lookup[m][n].value; 
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

	class Dataz {
		public Dataz(char ch,boolean value) {
			this.ch = ch;
			this.value = value;
		}
		char ch;
		boolean value;
	}