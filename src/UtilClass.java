import sun.print.resources.serviceui;

public class UtilClass {
	public static String mystery(String s){
		int N = s.length();
		if(N<=1){return s;}
		String a = s.substring(0, N/2);
		String b = s.substring(N/2,N);
		return mystery(b)+mystery(a);
	}

}
