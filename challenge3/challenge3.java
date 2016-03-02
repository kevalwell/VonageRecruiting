import java.util.Scanner;

public class challenge3
{
	public static int break_chocolate(int n, int m)
	{
		if (n == 0 || m == 0)
		{
			return 0;
		}
		else if (n == 1 && m == 1)
		{
			return 0; // no breaks when 1 x 1 pieces are present
		}
		else if ((m != 1) && (m % 2 == 0))
		{
			return break_chocolate(n, m/2) + break_chocolate(n, m/2) + 1;
		}
		else if ((m != 1) && (m % 2 != 0))
		{
			return break_chocolate(n, m/2) + break_chocolate(n, (m+1)/2) + 1;
		}
		else if ((n != 1 && m == 1) && (n % 2 == 0))
		{
			return break_chocolate(n/2, 1) + break_chocolate(n/2, 1) + 1;
		}
		else if ((n != 1 && m == 1) && (n % 2 != 0))
		{
			return break_chocolate(n/2, 1) + break_chocolate((n+1)/2, 1) + 1;
		}
		else
		{
			return break_chocolate(n, m/2) + break_chocolate(n, m/2) + 1;
		}
	}
}
