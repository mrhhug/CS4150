
public class Token
{

	private TokenType tok;
	private String lexeme;
	private int lineNum;
	private int columnNum;
	
	
	/**
	 * @param tok
	 * @param lexeme: precondition - cannot be null or empty
	 * @param lineNum: precondition - positive
	 * @param columnNum: precondition - positive
	 * @throws IllegalArgumentException if either lineNum or columnNum is not positive
	 */
	public Token(TokenType tok, String lexeme, int lineNum, int columnNum)
	{
		this.tok = tok;
		if (lexeme == null)
			throw new IllegalArgumentException ("null string argument");
		if (lexeme.length() == 0)
			throw new IllegalArgumentException ("empty lexeme argument");
		this.lexeme = lexeme;
		if (lineNum <= 0)
			throw new IllegalArgumentException ("invalid line number");
		this.lineNum = lineNum;
		if (columnNum <= 0)
			throw new IllegalArgumentException ("invalid column number");
		this.columnNum = columnNum;
	}


	public TokenType getTokenType()
	{
		return tok;
	}


	public String getLexeme()
	{
		return lexeme;
	}


	public int getLineNumber()
	{
		return lineNum;
	}


	public int getColumnNumber()
	{
		return columnNum;
	}


	@Override
	public String toString()
	{
		return tok + ": " + lexeme + " row: " + lineNum + " column: " + columnNum;
	}
	
		
}
