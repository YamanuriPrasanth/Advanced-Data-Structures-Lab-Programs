import java.util.Scanner;
class  BSTNode
{
    BSTNode left;
    int data;
    BSTNode right;
}
class BST
{
    BSTNode root;
    BST()
    {
        root=null;
    }
    void insert(int e)
    {
        BSTNode temp,ptr;
        temp=new BSTNode();
        temp.data=e;
        temp.left=null;
        temp.right=null;
        if(root==null)
        {
            root=temp;
        }
        else
        {
            ptr=root;
            while(ptr!=null)
            {
                if(e>ptr.data)
                {
                    if(ptr.right==null)
                    {
                        ptr.right=temp;
                        break;
                    }
                    else
                        ptr=ptr.right;
                }
                else if(e<ptr.data)
                {
                    if(ptr.left==null)
                    {
                        ptr.left=temp;
                        break;
                    }
                    else
                        ptr=ptr.left;
                }
                else
                {
                    System.out.println("Duplicate value not allowed");
                    break;
                }
            }
        }
    }
    void inOrder(BSTNode t)
    {
        BSTNode stk[]=new BSTNode[10];
        int top=-1;
        if(t==null)
            return ;
        else
        {
            while(true)
            {
                while(t!=null)
                {
                    stk[++top]=t;
                    t=t.left;
                }
                if(top==-1)
                    return ;
                else
                {
                    t=stk[top--];
                    System.out.println(t.data);
                    t=t.right;
                }
            }
        }
    }
    void preOrder(BSTNode t)
    {
        BSTNode stk[]=new BSTNode[10];
        int top=-1;
        if(t==null)
            return ;
        else
        {
            while(true)
            {
                while(t!=null)
                {
                    stk[++top]=t;
                    System.out.println(t.data);
                    t=t.left;
                }
                if(top==-1)
                    return ;
                else
                {
                    t=stk[top--];

                    t=t.right;
                }

            }
        }
    }
    void postOrder(BSTNode t)
    {
        BSTNode temp;
        BSTNode stk1[]=new BSTNode[10];
        BSTNode stk2[]=new BSTNode[10];
        int top1=-1,top2=-1;
        stk1[++top1]=t;
        while(top1>-1)
        {
            temp=stk1[top1--];
            stk2[++top2]=temp;
            if(temp.left!=null)
                stk1[++top1]=temp.left;
            if(temp.right!=null)
                stk1[++top1]=temp.right;
        }
        while(top2>-1)
        {
            temp=stk2[top2--];
            System.out.println(temp.data);
        }
    }
}
class BSTreeNonRecursive
{
    public static void main(String[] args)
    {
        BST b=new BST();
        Scanner s=new Scanner(System.in);
        int ch;
        while (true)
        {
            System.out.println("enter your choice");
            ch=s.nextInt();
            switch(ch)
            {
                case 1: System.out.println("enter the element");
                    b.insert(s.nextInt());
                    break;
                case 2: b.inOrder(b.root);
                    System.out.println("");
                    break;
                case 3: b.preOrder(b.root);
                    System.out.println("");
                    break;
                case 4: b.postOrder(b.root);
                    System.out.println("");
                    break;
                default:return;
            }
        }
    }
}
