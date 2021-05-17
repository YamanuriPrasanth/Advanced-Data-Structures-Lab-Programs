import java.util.Scanner;
class HeapSort
{
    Scanner s=new Scanner(System.in);
    int n,h[],max;
    HeapSort()
    {
        System.out.println("Enter max");
        max=s.nextInt();
        n=0;
        h=new int[max];
    }
    void percolateDown(int x,int m)
    {
        int e,c;
        e=h[x];
        for(;x*2<=m;x=c)
        {
            c=x*2;
            if(c!=m && h[c+1]>h[c])
                c++;
            if(e<h[c])
                h[x]=h[c];
            else
                break;
        }
        h[x]=e;
    }
    void buildHeap()
    {
        int i;
        System.out.println("Enter n value which should be less than "+max);
        n=s.nextInt();
        System.out.println("Enter n elements");
        for(i=1;i<=n;i++)
        {
            h[i]=s.nextInt();
        }
        for(i=n/2;i>0;i--)
            percolateDown(i,n);
    }
    void heapSort()
    {
        int t,size;
        size=n;
        for(int i=1;i<n;i++)
        {
            t = h[1];
            h[1] = h[size];
            h[size] = t;
            size--;
            percolateDown(1, size);
        }

    }
    void display()
    {
        for(int i=1;i<=n;i++)
        {
            System.out.println(h[i]);
        }
    }
}
class HeapSortDemo
{
    public static void main(String[] args)
    {
        HeapSort hs=new HeapSort();
        hs.buildHeap();
        System.out.println("Elements before sorting");
        hs.display();
        hs.heapSort();
        System.out.println("Elements after sorting");
        hs.display();
    }
}

