class Solution {
    
    public class Tree implements Comparable<Tree>{
        int data;
        Tree left;
        Tree right;
        
        public Tree(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
        public int compareTo(Tree e1)
        {
            if(this.data==e1.data)
            {
                return 1;
            }
            return this.data-e1.data;
        }
    }
    

    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<Tree> pq = new PriorityQueue<Tree>();
        
        for(int ele:f)
        {
            Tree temp = new Tree(ele);
            pq.add(temp);
        }
        
        while(pq.size()!=1)
        {
            Tree leftSide = pq.poll();
            Tree rightSide = pq.poll();
            
            Tree root = new Tree(leftSide.data+rightSide.data);
            root.left = leftSide;
            root.right = rightSide;
            
            pq.add(root);
        }
        
         ArrayList<String> ans = new ArrayList<String>();
        printPreOrder(pq.poll(),"",ans);
        return ans;
    }
    
    
    public void printPreOrder(Tree root,String str,ArrayList<String> ans)
    {
        
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
            ans.add(str);
            return;
        }
        
        printPreOrder(root.left,str+"0",ans);
        printPreOrder(root.right,str+"1",ans);
        
    }
}




