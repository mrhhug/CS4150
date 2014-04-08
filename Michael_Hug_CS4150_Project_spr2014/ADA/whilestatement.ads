with BooleanExpression;
use  BooleanExpression;

package WhileStatement is

   type While_Statement is private;

   procedure create_WhileStatement( expr: in Boolean_Expression; cb: in Code_Block);

   overriding procedure execute;

   private
   type While_Statement is
      record
         expr: Boolean_Expression;
         cb: Code_Block;
      end record;

end WhileStatement;
