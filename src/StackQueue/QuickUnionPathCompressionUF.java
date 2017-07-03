package StackQueue;

public class QuickUnionPathCompressionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    /**
     * Initializes an empty union�Cfind data structure with n isolated components 0 through n-1.
     * @param n the number of sites
     * @throws java.lang.IllegalArgumentException if n < 0
     */
    public QuickUnionPathCompressionUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }
  
  
    public int find(int p) {
        int root = p;
        while (root != id[root])
            root = id[root];
        //Ŀ�ģ���p�㵽���ڵ��·���ϵ�ÿ�����㶼���ӵ����ڵ�
        //��p�ڵ㲻�Ǹ��ڵ��ʱ��
        while (p != root) {
        	//����һ�������Ҹ��ڵ㣬ѭ��
            int newp = id[p];
            //��ÿ���������ӵ����ڵ�
            id[p] = root;
            //��ÿ���½ڵ㸳ֵ��p��ͨ������ѭ����֤�Ƿ�Ϊ���ڵ�
            p = newp;
        }
        return root;
    }

    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        id[rootP] = rootQ;
        count--;
    }

    
}
