package Others;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Frenquency {
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Arrays.sort(a);
		
		Record [] records = new Record[a.length];
		int freq = 1;
		String word = a[0];
		int m = 0;
		
		for (int i = 1; i < a.length; i++) {
            if (!a[i].equals(word)) {
                records[m++] = new Record(word, freq);
                word = a[i];
                freq = 0;
            }
            freq++;
        }
		records[m++] = new Record(word, freq);
		
		Arrays.sort(records, 0, m);
        for (int i = m-1; i >= 0; i--){
            StdOut.println(records[i]);
        }
    }

}
