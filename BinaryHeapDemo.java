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