package StackQueue;


public class QuickUnionUF {
	private int [] id;
	private int count;
	
	public QuickUnionUF(int N){
		id = new int [N];
		count = N;
		for(int i=0;i<N;i++){
			id[i] = i;
		}
	}
	
	public int count(){
		return count;
	}
	
	public int find(int p){
		validate(p);
		while(p!=id[p])
		{
			p=id[p];
		}
		return p;
	}
	
	private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
        }
    }
	
	public boolean connected(int p,int q){
		validate(p);
		validate(q);
		return find(p)==find(q);
		
	}
	
	public void union(int p,int q){
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP==rootQ) return;
		id[rootP] = rootQ;
		count--;
	}

}
