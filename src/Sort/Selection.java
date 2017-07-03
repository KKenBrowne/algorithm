package Sort;

import java.util.concurrent.Exchanger;
import Sort.SortDemo;
import com.sun.xml.internal.bind.v2.runtime.InlineBinaryTransducer;

public class Selection {
	public static void sort(Comparable a[]){
		int N = a.length;
		for(int i=0;i<N;i++){
			int min = i;
			for(int j=i+1;j<N;j++){
				if(SortDemo.less(a[j],a[min])) min = j;
			}
			SortDemo.exch(a, i, min);
			
		}
	}

}
