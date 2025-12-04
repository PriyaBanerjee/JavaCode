package testJava;

public class StringClass {
	
	

	// Remove vowels
	public String vowelsRemove(String st) {
		 StringBuilder result = new StringBuilder();
		for (int i=0; i < st.length(); i++) {
			char ch = st.charAt(i);
			if(ch== 'a' || ch == 'e' || ch =='i' || ch == 'o'|| ch== 'u') {
				continue;
			}
			result.append(ch);
		}
		return result.toString();
		
	}
	
	//Reverse vowels of all string
	public String vowelsReserve(String st) {
		 StringBuilder result = new StringBuilder();
		char[] ch = st.toCharArray();
		int i = 0;
		int j = ch.length-1;
		while(i<j) {
			while(ch[i] != 'a' && ch[i] != 'e' && ch[i] !='i' && ch[i] != 'o'&& ch[i] != 'u') {
				i++;
			}
			
			while (ch[j] != 'a' && ch[j] != 'e' && ch[j] !='i' && ch[j] != 'o'&& ch[j] != 'u') {
				j--;
			}
			
			if(i >= j) {
				break;
			}
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
		for (char temp:ch) {
			result.append(temp);
		}		
		return result.toString();
	}
	
	
	// uppercase to lower case 
	
	public String UpperToLowerCase(String st) {
		 StringBuilder result = new StringBuilder();
		char[] s = st.toCharArray();
		
		for ( int i =0 ; i< st.length(); i++) {
			char ch = s[i];
			if (ch >= 'A' && ch <= 'Z') {
				char ans = (char)(ch - 'A' +'a');
					s[i] = ans;
				
			}
			result.append(s[i]);
				
		}
		
		
		return result.toString();
	}
	

	public String RemoveString(String st,int A) {
		 StringBuilder result = new StringBuilder();
	char[] s = st.toCharArray();
		for(int i=0 ; i< st.length();i++) {
			char ch = st.charAt(i);
			
			 if (i == s.length - 1 || s[i] != s[i + 1]) {
				 result.append(s[i]);
		}		
		
	}
		return result.toString();
	}
	
	
	public String reverseString(String st) {
		 StringBuilder result = new StringBuilder();
		char[] s = st.toCharArray();
		int i =0;
		int j = s.length - 1;
		while(i<j) {
			
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp ;
			
			if (i>j) {
				break;
			}
			i++;
			j--;
			
		}
		for(char temp:s) {
			result.append(temp);
		}
		return result.toString();
	}
}
