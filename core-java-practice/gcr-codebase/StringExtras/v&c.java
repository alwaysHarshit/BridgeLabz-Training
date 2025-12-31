import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    HashSet<Character> vowels = new HashSet<>();
	    vowels.add('a');
	    vowels.add('e');
	    vowels.add('i');
	    vowels.add('o');
	    vowels.add('u');
	    
	    String s = "sample";
	    int vowelsCount = 0;
	    int consonants = 0;
	    
	    for(char c : s.toCharArray()){
	        if(vowels.contains(c)){
	            vowelsCount++;
	        }else{
	            consonants++;
	        }
	    }
	    System.out.println(consonants);
	    System.out.println(vowelsCount);
	}
}
