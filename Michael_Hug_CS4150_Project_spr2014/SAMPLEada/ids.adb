with Memory;
use Memory;

package body Ids is

   ---------------
   -- create_id --
   ---------------

   function create_id (ch: in Character) return Id is

      var: Id;

   begin
      var.ch := ch;
      return var;
   end create_id;

   --------------
   -- get_char --
   --------------

   function get_char (var: Id) return Character is

   begin
      return var.ch;
   end get_char;

   ---------------
   -- get_value --
   ---------------

   function get_value (var: Id) return Integer is

   begin
      return fetch (var);
   end get_value;

end Ids;
