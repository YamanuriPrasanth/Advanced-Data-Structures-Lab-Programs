Write a Java Program To implement Brute Force Algorithm

Aim:To implement Brute Force Algorithm using java programming

Description:

Program:
import java.util.*;
class BruteForce
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
        for(int i=0;i<=n-m;i++)
        {
            int j;
            for(j=0;j<m;j++)
            {
                if(t.charAt(i+j)==p.charAt(j)){}
                else
                    break;
            }
            if(j==m)
            {
                System.out.println("Pattern Matched");
                return;
            }
        }
        System.out.println("Pattern not matched");
    }
}

Input and Output:
Enter Text
prasanth
Enter Pattern
santh
Pattern Matched
