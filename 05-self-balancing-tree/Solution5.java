	Solution5lass node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

	static Solution5 insert(Solution5 root,int val)
    {
         Solution5 newNode = new Solution5();
    newNode.val = val;
    newNode.ht = 0;
    newNode.left = null;
    newNode.right = null;

    if (root==null) {
        root = newNode;
    } else {
        root=avlinsert(newNode, root);
    }

    return root;
}
static public int height(Solution5 x) {
    if (x == null) return -1;
    else return x.ht;
}

static public Solution5 rotatewithleft(Solution5 c) {
    Solution5 p; 

    p = c.left;
    c.left = p.right;
    p.right = c;

    c.ht = Math.max(height(c.left), height(c.right)) + 1;
    p.ht = Math.max(height(p.left), height(p.right)) + 1;

    return p;
}

static public Solution5 rotatewithright(Solution5 c) {
    Solution5 p;  

    p = c.right;
    c.right = p.left;
    p.left = c;

    c.ht = Math.max(height(c.left), height(c.right)) + 1;
    p.ht = Math.max(height(p.left), height(p.right)) + 1;

    return p;
}

static public Solution5 doublerotatewithleft(Solution5 c) {
    Solution5 tmp;

    c.left = rotatewithright(c.left);
    tmp = rotatewithleft(c);

    return tmp;
}

static public Solution5 doublerotatewithright(Solution5 c) {
    Solution5 tmp;

    c.right = rotatewithleft(c.right);
    tmp = rotatewithright(c);

    return tmp;
}

static public Solution5 avlinsert(Solution5 newNode, Solution5 par) {
   Solution5 newpar = par;  

    if (newNode.val < par.val)  {
        if (par.left == null) {
            par.left = newNode;  
        }
    else {
         par.left = avlinsert(newNode, par.left);  
         if ((height(par.left) - height(par.right)) == 2) {
            if (newNode.val < par.left.val) {
                newpar=rotatewithleft(par);
            } else {
                newpar=doublerotatewithleft(par);
            } 
         } 
      } 
   } 
    else if (newNode.val > par.val) { 
        if (par.right == null) {
            par.right = newNode;   
        } else {
            par.right = avlinsert(newNode, par.right);  
            if ((height(par.right) - height(par.left)) == 2) {
                if (newNode.val > par.right.val) {
                    newpar=rotatewithright(par);
                } 
                else {
                    newpar=doublerotatewithright(par);
                } 
            } 
        } 
    }  

    

    if ((par.left == null) && (par.right != null))
        par.ht = par.right.ht + 1;
    else if ((par.right == null) && (par.left != null))
        par.ht = par.left.ht + 1;
    else
        par.ht = Math.max(height(par.left), height(par.right)) + 1;

    return newpar; 
    	
    }