Write a Java Program To implement BoyerMoore Algorithm

Aim:To implement BoyerMoore Algorithm using Java programming

Description:

Program:
import java.util.*;
class BoyerMoore
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Text");
        String t=s.nextLine();
        System.out.println("Enter Pattern");
        String p=s.nextLine();
        int n=t.length();
        int m=p.length();
        int i,j;
        int last[]=new int[128];
        for(i=0;i<128;i++)
            last[i]=-1;
        for(i=0;i<m;i++)
            last[p.charAt(i)]=i;
        i=m-1;
        j=m-1;
        while(i<n)
        {
            while(j>=0)
            {
                if(t.charAt(i)==p.charAt(j))
                {
                    j--;
                    i--;
                }
                else
                    break;
            }
            if(j<0)
            {
                System.out.println("Pattern matched");
                return;
            }
            else
            {
                i=i+m-min(j,1+last[t.charAt(i)]);
                j=m-1;

            }
        }
        System.out.println("Pattern not Found");
    }
    static int min(int a,int b)
    {
        if(a<b)
            return a;
        return b;
    }
}

Input and output:
Enter Text
prasanth
Enter Pattern
santh
Pattern matched

