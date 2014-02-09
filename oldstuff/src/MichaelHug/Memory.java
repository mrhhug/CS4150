package MichaelHug;

public class Memory
{

	private static int[] mem = new int[26];
	
	/**
	 * @param ch
	 * @return value stored for specified variable
	 */
	public static int fetch(char ch)
	{
		return mem[ch - 'A'];
	}
	
	/**
	 * postcondition: value has been stored as the value of the specified variable
	 * @param ch
	 * @param value
	 */
	public static void store (char ch, int value)
	{
		mem[ch - 'A'] = value;
	}

}
