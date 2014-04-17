with Ids;
use Ids;

package Memory is

   function fetch (var: in Id) return Integer;

   procedure store (var: in Id; value: in Integer);

end Memory;
