with Expressions;
use Expressions;

package Boolean_Expressions is

   type Relational_Operator is (EQ_OP, NE_OP, LT_OP, LE_OP, GT_OP, GE_OP);

   type Boolean_Expression is private;

   function create_boolean_expression (op: in Relational_Operator;
                                       expr1, expr2: in Expression_Access)
                                       return Boolean_Expression;

   function evaluate (expr: in Boolean_Expression) return Boolean;

private
   type Boolean_Expression is
      record
         op: Relational_Operator;
         expr1: Expression_Access;
         expr2: Expression_Access;
      end record;

end Boolean_Expressions;
