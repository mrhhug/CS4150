with Ada.Characters.Handling;
use Ada.Characters.Handling;

package Ids is

   type Id is private;

   function create_id (ch: in Character) return Id
   with pre => is_letter (ch);

   function get_char (var: Id) return Character;

   function get_value (var: Id) return Integer;

private
   type Id is record
      ch: Character;
   end record;

end Ids;
