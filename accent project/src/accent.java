//Penelope Shuster
//3/6/20
//this program converts the jaws script into a Boston accent

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class accent {
    public static void main(String args[])throws FileNotFoundException {
	File file = new File("jaws.txt");

	Scanner sc = new Scanner(file);
	sc.useDelimiter("[^\\p{Alpha}']+");


	while (sc.hasNext()) {
	    String word = sc.next();
	    if (word.equals("'")) // ignore lone apostrophes
		continue;
	    System.out.println(word);
	    processor(word);

	}
	sc.close();
		
	}
    public static void processor(String word) {

    	if (endsWithR(word)) {
    		word = (word.substring(0,(word.length()-1)))+ 'h';
    	}	
    	if (rPlural(word)) {
    		word = (word.substring(0,(word.length()-2))+ "hs");
    	}
    	if (wordIsVery(word)) {
    		word = "wicked";
    	}
    	if (rException(word)) {
    		word = (word.substring(0,(word.length()-1))) + "yah";
    	}
    	if (endsWithA(word)) {
    		word += 'r';
    	if (rException2(word)) {
    		word = (word.substring(0,(word.length()-1))) + "wah";
    	}
    	}
    }

    public static boolean endsWithR(String s) {
	if  (((s.charAt(s.length()-1) == 'r') || (s.charAt(s.length()-1)) == 'R')
		&&((s.charAt(s.length()-2)!= 'i')&&((s.charAt(s.length()-2) != 'e'&&(s.charAt(s.length()-3)!='e'))))){
		return true;
	}
	else {
		return false;
}
    
    

}
public static boolean endsWithA(String s) {
	if  (((s.charAt(s.length()-1) == 'a') || ((s.charAt(s.length()-1)) == 'A') && (s.charAt(s.length()-2)!=' '))){
		return true;
	}
	else {
		return false;
	}
	
}


public static boolean wordIsVery(String s) {
	if ((s == "very")||(s == "Very")) {
		return true;
	}
	else  {
		return false;
	}
}
public static boolean rException(String s) {
	if (((s.charAt(s.length()-1) == 'r')||(s.charAt(s.length()-1)) == 'R') &&
			(((s.charAt(s.length()-2)== 'i')||(((s.charAt(s.length()-2) == 'e'&&(s.charAt(s.length()-3)=='e'))))))){
		return true;
	}
	else {
		return false;
	}
}
public static boolean rException2(String s) {
	if ((((s.charAt(s.length()-1) == 'r')||(s.charAt(s.length()-1)) == 'R'))
			&&(((s.charAt(s.length()-2) == 'o'&&(s.charAt(s.length()-3)=='o'))))) {
		return true;
	}
	else {
		return false;
	}
}
public static boolean rPlural(String s) {
	if ((s.charAt(s.length()-1) == 's')&&(s.charAt(s.length()-2) == 'r')) {
		return true;
	}
	else {
	return false;
}



}
}
