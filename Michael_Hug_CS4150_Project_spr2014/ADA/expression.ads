package Expression is

   type expre_ssion is private;

   function execute return Positive is abstract;

private
   type expre_ssion is
   record
	name: Positive;
    end record;

end Expression;
