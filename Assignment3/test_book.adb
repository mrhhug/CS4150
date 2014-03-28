with Books, Ada.Text_IO;
use Books, Ada.Text_IO;

procedure Test_Book is

   boo: Book;

   procedure display_book (s: in Book) is

   begin
      put ("Author: ");
      put_line (get_author (s));
      put ("Title: ");
      put_line (get_title (s));
      put ("Pages: ");
      put_line (Positive'Image (Positive(get_pages(s))));
   end display_book;

begin
   boo :=create_book("Hu","The life of me",150);
   display_book(boo);
end Test_Book;
