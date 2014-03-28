with Books, Ada.Text_IO;
use Books, Ada.Text_IO;

procedure Test_Book is

   b: Book;
   procedure display_book (s: in Book) is

   begin
      put ("name of author: ");
      put_line (get_author (s));
      put ("number of pages: ");
      put_line (Positive'Image (Positive(get_pages(s))));
      put ("book title: ");
      put_line (get_title (s));

   end display_book;

begin
   b :=create_book("tolstoy","war and peac",675);
   display_book(b);
end Test_Book;
