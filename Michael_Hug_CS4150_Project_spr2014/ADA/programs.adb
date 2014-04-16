package body Programs is

   --------------------
   -- create_program --
   --------------------

   function create_program (cb: in Code_Block) return Program is
      prog: Program;
   begin
      prog.cb := cb;
      return prog;
   end create_program;

   -------------
   -- execute --
   -------------

   procedure execute (prog: in Program) is
   begin
      execute (prog.cb);
   end execute;

end Programs;
