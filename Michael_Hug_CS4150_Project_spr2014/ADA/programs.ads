with Statements;
use Statements;

package Programs is

   type Program is private;

   function create_program (cb: in Code_Block) return Program;

   procedure execute (prog: in Program);

private
   type Program is
      record
         cb: Code_Block;
      end record;

end Programs;
