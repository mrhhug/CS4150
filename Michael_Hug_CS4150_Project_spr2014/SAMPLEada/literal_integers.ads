package Literal_Integers is

   type Literal_Integer is private;

   function create_literal_integer (value: in Integer) return Literal_Integer;

   function get_value (li: in Literal_Integer) return Integer;

private
   type Literal_Integer is
      record
         value: Integer;
      end record;

end Literal_Integers;
