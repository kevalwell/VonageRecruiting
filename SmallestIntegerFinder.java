import java.lang.Integer;

public class SmallestIntegerFinder
{
	// non-static method for finding smallest int in an int array
	public int findSmallestInt(int[] input)
	{
		int min = Integer.MAX_VALUE;

		int len = input.length;

		// loops through array to look for smallest int
		for(int i = 0; i < len; i++)
		{
			if (min > input[i])
				min = input[i];
		}
		return min;
	}

	// main function for testing
	public static void main(String[] args)
	{
		int[] input = {78,56,232,12,0};
		SmallestIntegerFinder sif = new SmallestIntegerFinder();
		System.out.println(sif.findSmallestInt(input));
	}
}