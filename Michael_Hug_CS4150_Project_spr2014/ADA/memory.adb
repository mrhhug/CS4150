with Ada.Characters.Handling;
use Ada.Characters.Handling;

package body Memory is

   up_mem: array (Character range 'A' .. 'Z') of Integer := (others => 0);
   lower_mem: array (Character range 'a' .. 'z') of Integer := (others => 0);

   -----------
   -- fetch --
   -----------

   function fetch (var: in Id) return Integer is
      value: Integer;

   begin
      if is_upper (get_char (var)) then
         value := up_mem (get_char(var));
      else
         value := lower_mem(get_char(var));
      end if;
      return value;
   end fetch;

   -----------
   -- store --
   -----------

   procedure store (var: in Id; value: in Integer) is
   begin
      if is_upper (get_char (var)) then
         up_mem (get_char(var)) := value;
      else
         lower_mem(get_char(var)) := value;
      end if;
   end store;

end Memory;
