import java.util.*;;
class KnuthMorrisPratt
{

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Text");
        String t = s.nextLine();
        System.out.println("Enter Pattern");
        String p = s.nextLine();
        int n = t.length();
        int m = p.length();
        int pr[] = new int[m];
        int i = 1, j = 0;
        pr[0] = 0;
        while (i < m)
        {
            if (p.charAt(i) == p.charAt(j))
            {
                pr[i] = j + 1;
                i++;
                j++;
            }
            else if (j > 0)
                j = pr[j - 1];
            else
            {
                pr[i] = 0;
                i = i + 1;
            }

        }
        i=0;j=0;
        while(i<n)
        {
            if(t.charAt(i)==p.charAt(j))
            {
                if (j == m - 1)
                {
                    System.out.println("Pattern Matched");
                    return;

                }
                i++;
                j++;
            }
            else if(j>0)
                    j=pr[j-1];
            else
                    i=i+1;
        }
        System.out.println("Pattern not matched");
    }
}

