import java.io.FileNotFoundException;


public class TestLex
{

	public static void main(String[] args)
	{
		if (args.length == 0)
			System.out.println("expected java TextLex file_name");
		else
		{
			try
			{
				LexicalAnalyzer lex = new LexicalAnalyzer (args[0]) ;
				while (lex.moreTokens())
					System.out.println(lex.getNextToken());
			}
			catch (LexException e)
			{
				System.out.println (e.getMessage() + " row: " + e.getRowNumber() + " column: " + e.getColumnNumber());
			}
			catch (FileNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			catch (Exception e)
			{
				System.out.println("unknown error - terminating");
			}
		}
	}

}
