import java.io.FileNotFoundException;


public class Parser
{

	private LexicalAnalyzer lex;
	
	/**
	 * precondition: fileName is not null
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws LexException 
	 * @throws IllegalArgumentException if fileName is null
	 */
	public Parser (String fileName) throws FileNotFoundException, LexException
	{
		if (fileName == null)
			throw new IllegalArgumentException ("null string argument");
		lex = new LexicalAnalyzer (fileName);
	}
	
	/**
	 * postcondition: Program object has been created from source code
	 * @return
	 * @throws ParserException if a parse error occurred
	 */
	public Expression parse () throws ParserException
	{
		return getExpression();
	}

	private Expression getExpression() throws ParserException
	{
		Expression expr;
		Token tok = lex.getLookaheadToken();
		if (tok.getTokenType() == TokenType.IDENT || tok.getTokenType() == TokenType.INT_LIT)
			expr = getUnaryExpression();
		else
		{
			expr = getBinaryExpression();
		}
		return expr;
	}

	private Expression getBinaryExpression() throws ParserException
	{
		ArithmeticOperator op = getArithmeticOperator();
		Expression expr1 = getExpression();
		Expression expr2 = getExpression();
		return new BinaryExpression (op, expr1, expr2);
	}

	private UnaryExpression getUnaryExpression() throws ParserException
	{
		UnaryExpression expr;
		Token tok = lex.getLookaheadToken();
		if (tok.getTokenType() == TokenType.IDENT)
			expr = getId();
		else if (tok.getTokenType() == TokenType.INT_LIT)
			expr = getLiteralInteger();
		else
			throw new ParserException ("identifier or literal integer expected at line number: "
					+ tok.getLineNumber() + " column number: " + tok.getColumnNumber());

		return expr;
	}

	private ArithmeticOperator getArithmeticOperator() throws ParserException
	{
		ArithmeticOperator op;
		Token tok = lex.getNextToken();
		if (tok.getTokenType() == TokenType.ADD_OP)
			op = ArithmeticOperator.ADD;
		else if (tok.getTokenType() == TokenType.SUB_OP)
			op = ArithmeticOperator.SUB;
		else if (tok.getTokenType() == TokenType.MULT_OP)
			op = ArithmeticOperator.MUL;
		else if (tok.getTokenType() == TokenType.DIV_OP)
			op = ArithmeticOperator.DIV;
		else
			throw new ParserException ("arithmetic operator expected at line number: " + tok.getLineNumber() + 
				" column number: " + tok.getColumnNumber());
		return op;
	}

	private LiteralInteger getLiteralInteger() throws ParserException
	{
		Token tok = lex.getNextToken();
		int value = 0;
		try
		{
			value = Integer.parseInt(tok.getLexeme());
		}
		catch (NumberFormatException e)
		{
			throw new ParserException ("literal integer expected at line number: " + tok.getLineNumber() + 
				" column number: " + tok.getColumnNumber());
		}
		return new LiteralInteger (value);
	}

	private Id getId() throws ParserException
	{
		Token tok = lex.getNextToken();
		return new Id (tok.getLexeme().charAt(0));
	}
	
}
