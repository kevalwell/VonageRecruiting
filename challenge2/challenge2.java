import java.util.Scanner;

public class challenge2
{
	public static int calcLeast(int[] numbers)
	{
		int smallest = Integer.MAX_VALUE;
		for(int j = 0; j < numbers.length; j++)
		{
			if (numbers[j] < smallest)
			{
				smallest = numbers[j];
			}
		}
		return smallest;
	}
}