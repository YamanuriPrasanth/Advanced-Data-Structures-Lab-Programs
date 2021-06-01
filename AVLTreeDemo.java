import java.util.*;
class AVLNode
{
    AVLNode left;
    int data;
    AVLNode right;
}
class AVL
{
    AVLNode ll(AVLNode t)
    {
        AVLNode temp=t.left;
        t.left=temp.right;
        temp.right=t;
        return temp;
    }
    AVLNode rr(AVLNode t)
    {
        AVLNode temp=t.right;
        t.right=temp.left;
        temp.left=t;
        return temp;
    }
    AVLNode lr(AVLNode t)
    {
        t.left=rr(t.left);
        return ll(t);
    }
    AVLNode rl(AVLNode t)
    {
        t.right=ll(t.right);
        return rr(t);
    }
    AVLNode insert(AVLNode t,int e)
    {
        if(t==null)
        {
            t=new AVLNode();
            t.data=e;
            t.left=t.right=null;
            return t;
        }
        else if(e<t.data) {
            t.left = insert(t.left, e);
            if(height(t.left)-height(t.right)==2||height(t.left)-height(t.right)==-2)
            {
                if(e<t.left.data)
                    t=ll(t);
                else
                    t=lr(t);
            }

        }
        else
        {
            t.right=insert(t.right,e);
            if(height(t.left)-height(t.right)==2||height(t.left)-height(t.right)==-2)
            {
                if(e>t.right.data)
                    t=rr(t);
                else
                    t=rl(t);
            }
        }
        return t;
    }
    int height(AVLNode t)
    {
        if(t==null)
            return -1;
        else if(t.left==null&&t.right==null)
            return 0;
        else if(t.left==null)
            return 1+height(t.right);
        else if(t.right==null)
            return 1+height(t.left);
        else
            return 1+max(height(t.left),height(t.right));
    }
    int max(int a,int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
    void search(AVLNode t,int e)
    {

        if(t==null)
            System.out.println("there is no such element");
        else if(e<t.data)
            search(t.left,e);
        else if(e>t.data)
            search(t.right,e);
        else
            System.out.println("Element found");
    }
    AVLNode delete(AVLNode t,int e)
    {
        AVLNode temp;
        if(t==null)
        {
            System.out.println("There is no such element");
            return null;
        }
        else if(e<t.data)
        {
            t.left=delete(t.left,e);
            if(height(t.right)-height(t.left)==2)
            {
                if(height(t.right.right)>=height(t.right.left))
                    t=rr(t);
                else
                    t=rl(t);
            }
        }
        else if(e>t.data)
        {
            t.right=delete(t.right,e);
            if(height(t.left)-height(t.right)==2)
            {
                if(height(t.left.left)>=height(t.left.right))
                    t=ll(t);
                else
                    t=lr(t);
            }
        }
        else
        {
            if(t.left==null&&t.right==null)
            {
                t=null;
                return null;
            }
            else if(t.left!=null&&t.right!=null)
            {
                temp=findMin(t.right);
                t.data=temp.data;
                t.right=delete(t.right,temp.data);
            }
            else
            {
                if(t.left==null)
                    t=t.right;
                else
                    t=t.left;
            }
        }
        return t;
    }
    AVLNode findMin(AVLNode t)
    {
        if(t==null||t.left==null)
            return t;
        else
            return findMin(t.left);
    }
    void display(AVLNode t)
    {
        if(t!=null)
        {
            display(t.left);
            System.out.println(t.data);
            display(t.right);
        }
    }
}
class AVLTreeDemo
{
    public static void main(String[] args)
    {
        AVLNode root=null;
        AVL a=new AVL();
        Scanner s=new Scanner(System.in);
        int e,ch;
        while(true)
        {
            System.out.println("enter your choice");
            ch=s.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.println("Enter the element to be inserted");
                    e=s.nextInt();
                    root=a.insert(root,e);
                    break;
                case 2:
                    a.display(root);
                    break;
                case 3:
                    System.out.println("The height tree is"+a.height(root));
                    break;
                case 4:
                    System.out.println("Enter the element to be deleted");
                    e=s.nextInt();
                    root= a.delete(root,e);
                    break;
                case 5:
                    System.out.println("Enter the element to be searched");
                    e=s.nextInt();
                    a.search(root,e);
                    break;
                default:
                    return;
            }
        }
    }
}


