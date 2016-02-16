import java.lang.StringBuilder;
import java.util.Scanner;

public class ParseInt
{
	/* This method parses the String input into an integer (also
	returned as a string). It only parses it if it is
	a "pure" integer, in the sense that input only contains 
	a single integer value (and eventually spaces - including 
	tabs, line feeds... - at both ends). For all other strings 
	(including the ones representing float values), it  
	returns NaN. It should assume that all numbers are not signed 
	and written in base 10.
	*/

	public static String myParseInt(String input)
	{
		// Return String when input is not parsed
		String notNum = "NaN";

		// Removes leading and trailing whitespaces
		input = input.trim();

		// if no input is given, then NaN is returned
		if(input.isEmpty())
			return notNum;
		else
		{
			// converts trimed input to a character array
			char[] trimedInput = input.toCharArray();
			// variable to be used later
			int arraylength = trimedInput.length;
			
			// use a string builder instead of concaternating string
			// string builder runs in linear time when building strings
			StringBuilder sb = new StringBuilder(arraylength);

			// loop that examines each character entry 
			for(int i = 0; i < arraylength; i++)
			{
				// gets rid of the leading 0s
				if((trimedInput[i] == '0') && (sb.length() == 0))
				{
					continue;
				}
				// appends the valid digits
				else if(Character.isDigit(trimedInput[i]))
				{
					sb.append(trimedInput[i]);
				}
				// if it is not a digit, do not parse the string
				else
					return notNum;
			}
			// reduce string to appropriate size
			sb.trimToSize();
			if (sb.length() == 0)
				sb.append('0');
			return sb.toString();
		}
	}

	public static void main(String[] args)
	{
		// An infinite loop is usually not a good idea. For the sake of
		// the challenge, I shall make an exception...
		while(true)
		{
			System.out.println("Please enter a string:");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			System.out.println("Parsed result is: " + myParseInt(input));			
		}

	}
}