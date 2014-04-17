with Memory, Ada.Text_IO;
use Memory;

package body Statements is

   ---------------------------------
   -- create_assignment_statement --
   ---------------------------------

   function create_assignment_statement (var: in Id; expr: in Expression_Access)
                                         return Statement_Access is

      stmt: Statement_Access;

   begin
      stmt := new Statement(ASSIGN_STMT);
      stmt.var := var;
      stmt.expr := expr;
      return stmt;
   end create_assignment_statement;

   -------------------------
   -- create_if_statement --
   -------------------------

   function create_if_statement (expr: in Boolean_Expression;
                                 cb1, cb2: in Code_Block)
                                 return Statement_Access is

      stmt: Statement_Access;

   begin
      stmt := new Statement (IF_STMT);
      stmt.b_expr := expr;
      stmt.cb1 := cb1;
      stmt.cb2 := cb2;
      return stmt;
   end create_if_statement;

   ----------------------------
   -- create_print_statement --
   ----------------------------

   function create_print_statement (expr: in Expression_Access)
                                    return Statement_Access is

      stmt: Statement_Access;

   begin
      stmt := new Statement (PRINT_STMT);
      stmt.pr_expr := expr;
      return stmt;
   end create_print_statement;

   ----------------------------
   -- create_while_statement --
   ----------------------------

   function create_while_statement (expr: in Boolean_Expression;
                                    cb: in Code_Block)
                                    return Statement_Access is

      stmt: Statement_Access;

   begin
      stmt := new Statement (WHILE_STMT);
      stmt.w_expr := expr;
      stmt.cb := cb;
      return stmt;
   end create_while_statement;

   ----------------------------
   -- create_until_statement --
   ----------------------------

   function create_until_statement (expr: in Boolean_Expression;
                                    cb: in Code_Block)
                                    return Statement_Access is
      stmt: Statement_Access;

   begin
      stmt := new Statement (UNTIL_STMT);
      stmt.u_expr := expr;
      stmt.u_cb := cb;
      return stmt;
   end create_until_statement;

   -------------
   -- execute --
   -------------

   procedure execute (stmt: in Statement_Access) is

   begin
      case stmt.stmt_type is
         when ASSIGN_STMT =>
            store (stmt.var, evaluate (stmt.expr));
         when IF_STMT =>
            if evaluate (stmt.b_expr) then
               execute (stmt.cb1);
            else
               execute (stmt.cb2);
            end if;
         when PRINT_STMT =>
            Ada.Text_IO.Put (Integer'Image (evaluate (stmt.pr_expr)));
         when WHILE_STMT =>
            while evaluate(stmt.w_expr) loop
               execute (stmt.cb);
            end loop;
         when UNTIL_STMT =>
            while not evaluate(stmt.u_expr) loop
               execute (stmt.u_cb);
            end loop;
      end case;
   end execute;

   ---------
   -- add --
   ---------

   procedure add (cb: in out Code_Block; stmt: in Statement_Access) is


   begin
      Statement_Lists.append (cb.l, stmt);
   end add;

   -------------
   -- execute --
   -------------

   procedure execute (cb: in Code_Block) is

      current: Statement_Lists.Cursor;

   begin
      current := Statement_Lists.first(cb.l);
      for i in 1 .. Statement_Lists.Length (cb.l) loop
         execute (Statement_Lists.Element (current));
         Statement_Lists.next (current);
      end loop;
   end execute;

end Statements;
