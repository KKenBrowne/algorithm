package StackQueue;

public class QuickUnionPathCompressionUF {
    private int[] id;    // id[i] = parent of i
    private int count;   // number of components

    /**
     * Initializes an empty union–find data structure with n isolated components 0 through n-1.
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
        //目的，从p点到根节点的路径上的每个触点都连接到根节点
        //当p节点不是根节点的时候
        while (p != root) {
        	//继续一个个查找根节点，循环
            int newp = id[p];
            //把每个触点连接到根节点
            id[p] = root;
            //把每个新节点赋值给p，通过上面循环验证是否为根节点
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
