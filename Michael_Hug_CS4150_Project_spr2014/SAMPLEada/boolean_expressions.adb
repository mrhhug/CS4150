package body Boolean_Expressions is

   -------------------------------
   -- create_boolean_expression --
   -------------------------------

   function create_boolean_expression (op: in Relational_Operator;
                                       expr1, expr2: in Expression_Access)
                                       return Boolean_Expression is
      expr: Boolean_Expression;

   begin
      expr.op := op;
      expr.expr1 := expr1;
      expr.expr2 := expr2;
      return expr;
   end create_boolean_expression;

   --------------
   -- evaluate --
   --------------

   function evaluate (expr: in Boolean_Expression) return Boolean is

      result: Boolean;

   begin
      case expr.op is
         when EQ_OP =>
            result := evaluate (expr.expr1) = evaluate (expr.expr2);
         when NE_OP =>
            result := evaluate (expr.expr1) /= evaluate (expr.expr2);
         when LE_OP =>
            result := evaluate (expr.expr1) <= evaluate (expr.expr2);
         when LT_OP =>
            result := evaluate (expr.expr1) < evaluate (expr.expr2);
         when GE_OP =>
            result := evaluate (expr.expr1) >= evaluate (expr.expr2);
         when GT_OP =>
            result := evaluate (expr.expr1) > evaluate (expr.expr2);
      end case;
      return result;
   end evaluate;

end Boolean_Expressions;
