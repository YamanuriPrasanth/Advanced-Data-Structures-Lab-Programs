Write a java program to implement Binary Heap Operations 

Aim:To implement Binary Heap Operations using java programming

Description:

Program:
import java.util.Scanner;
class BinaryHeap
{
    Scanner s=new Scanner(System.in);
    int h[],max,n;
    BinaryHeap()
    {
        System.out.println("Enter maximum");
        max=s.nextInt();
        n=0;
        h=new int[max];
    }
    void insert(int e)
    {
        if(n==max)
            System.out.println("overflow");
        else
        {
            int i;
            n++;
            for(i=n;i!=1 && e>h[i/2];i=i/2)
                h[i]=h[i/2];
            h[i]=e;
        }
    }
    void delete()
    {
        h[1]=h[n];
        n--;
        int i,c,e;
        e=h[1];
        for(i=1;i*2<=n;i=c)
        {
            c=2*i;
            if(c!=n && h[c+1]>h[c])
                c++;
            if(h[c]>e)
                h[i]=h[c];
            else
                break;
        }
        h[i]=e;
    }
    void display()
    {
        for(int i=1;i<=n;i++)
            System.out.println(h[i]);
    }
}
class BinaryHeapDemo
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        BinaryHeap d=new BinaryHeap();
        int ch;
        while(true)
        {
            System.out.println("Enter your choice");
            ch=s.nextInt();
            switch(ch)
            {
                case 1:System.out.println("Enter the key to be inserted");
                    d.insert(s.nextInt());
                    break;
                case 2:d.display();
                    break;
                case 3: d.delete();
                    break;
                default:return;
            }
        }
    }
}


Input and output:
Enter maximum
20
Enter your choice
1
Enter the key to be inserted
24
Enter your choice
1
Enter the key to be inserted
13
Enter your choice
1
Enter the key to be inserted
48
Enter your choice
1
Enter the key to be inserted
17
Enter your choice
1
Enter the key to be inserted
20
Enter your choice
1
Enter the key to be inserted
56
Enter your choice
1
Enter the key to be inserted
70
Enter your choice
2
70
20
56
13
17
24
48
Enter your choice
3
Enter your choice
2
56
20
48
13
17
24
Enter your choice
3
Enter your choice
2
48
20
24
13
17
Enter your choice
10

