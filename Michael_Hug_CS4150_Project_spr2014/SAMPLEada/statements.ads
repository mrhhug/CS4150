with Expressions, Ids, Boolean_Expressions;
use Expressions, Ids, Boolean_Expressions;

private with Ada.Containers.Doubly_Linked_Lists;

package Statements is

   type Statement_Type is (ASSIGN_STMT, IF_STMT, PRINT_STMT, WHILE_STMT,
                           UNTIL_STMT);

   type Statement (stmt_type: Statement_Type) is private;

   type Statement_Access is access Statement;

   type Code_Block is private;

   function create_assignment_statement (var: in Id; expr: in Expression_Access)
                                         return Statement_Access
   with pre => expr /= null;

   function create_if_statement (expr: in Boolean_Expression; cb1, cb2: in Code_Block)
                                 return Statement_Access;

   function create_print_statement (expr: in Expression_Access) return Statement_Access
   with pre => expr /= null;

   function create_while_statement (expr: in Boolean_Expression; cb: in Code_Block)
                                    return Statement_Access;

   function create_until_statement (expr: in Boolean_Expression; cb: in Code_Block)
                                    return Statement_Access;

   procedure execute (stmt: in Statement_Access)
   with pre => stmt /= null;

   procedure add (cb: in out Code_Block; stmt: in Statement_Access)
   with pre => stmt /= null;

   procedure execute (cb: in Code_Block);

private
   type Statement (stmt_type: Statement_Type) is
      record
         case stmt_type is
            when ASSIGN_STMT =>
               var: Id;
               expr: Expression_Access;
            when IF_STMT =>
               b_expr: Boolean_Expression;
               cb1: Code_Block;
               cb2: Code_Block;
            when PRINT_STMT =>
               pr_expr: Expression_Access;
            when WHILE_STMT =>
               w_expr: Boolean_Expression;
               cb: Code_Block;
            when UNTIL_STMT =>
               u_expr: Boolean_Expression;
               u_cb: Code_Block;
         end case;
      end record;

   package Statement_Lists is new Ada.Containers.Doubly_Linked_Lists(Statement_Access);

   type Code_Block is
      record
         l: Statement_Lists.List;
      end record;

end Statements;
