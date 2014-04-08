with RelationalOperator,Expression;
use  RelationalOperator,Expression;


package BooleanExpression is

   type Boolean_Expression is private;

   function evaluate return boolean;

   procedure create_BooleanExpression(op: in Relational_Operator; expr1: in expre_ssion; expr2: in expre_ssion);

   private
   type Boolean_Expression is
      record
         op: Relational_Operator;
         expr1: Expre_ssion;
         expr2: Expre_ssion;
      end record;

end BooleanExpression;
