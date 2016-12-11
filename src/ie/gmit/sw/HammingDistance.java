package ie.gmit.sw;

/**
 * Algorithm that implements Algos interface and overrides the distance method.  Result is cast from Integer to String
 * 
 * @author Yvonne Grealy
 *
 */

public class HammingDistance implements Algos {
	public String distance(String s, String t) {
		if (s.length() != t.length()) return Integer.toString(-1); //Similar length strings only
		int counter = 0;
		
		for (int i = 0; i < s.length(); ++i){
			if (s.charAt(i) != t.charAt(i)) counter++;
		}
		return Integer.toString(counter);
	}

}
