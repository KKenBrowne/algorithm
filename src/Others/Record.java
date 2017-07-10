package Others;

public class Record implements Comparable<Record>{
	private String word;
	private int freq;
	
	public Record(String word,int freq){
		this.word = word;
		this.freq = freq;
	}
	public String getWord() {
		return word;
	}

	public int getFreq() {
		return freq;
	}

	@Override
	public int compareTo(Record that)
	{
		if (this.freq > that.freq) {
			return 1;
		} else if (this.freq < that.freq) {
			return -1;
		} else {
			return 0;
		}
		
	}
	
	public String toString(){
		return word+":"+freq;
		
	}
	
	

}
