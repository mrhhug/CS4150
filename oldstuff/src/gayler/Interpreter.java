import java.io.FileNotFoundException;


public class Interpreter
{

	public static void main(String[] args)
	{
		if (args.length == 0)
			System.out.println("java Interpreter file_name expected");
		else
		{
			try
			{
				Parser p = new Parser(args[0]);
				Expression expr = p.parse();
				int value = expr.evaluate();
				System.out.println (value);
			}
			catch (FileNotFoundException e)
			{
				System.out.println("source file not found");
				e.printStackTrace();
			}
			catch (LexException e)
			{
				System.out.println(e.getMessage() + " row: " + e.getRowNumber() + " column: " + e.getColumnNumber());
				e.printStackTrace();
			}			
			catch (ParserException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			catch (IllegalArgumentException e)
			{
				System.out.println (e.getMessage());
				e.printStackTrace();
			}
			catch (Exception e)
			{
				System.out.println("unknown error occurred - terminating");
				e.printStackTrace();
			}
		}
	}

}
