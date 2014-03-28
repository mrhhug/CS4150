with Ada.Characters.Handling;
use Ada.Characters.Handling;

package body Books is

   function create_book
     (author: in String;
      title: in String;
      pag: in PAGES)
      return Book
   is
      b : Book;
   begin
      if author'Length > MAX_AUTHOR then
         b.author := author(1 .. MAX_AUTHOR);
      else
         b.author (1 .. author'Length) := author;
      end if;
      if title'Length > MAX_TITLE then
         b.title := title(1 .. MAX_TITLE);
      else
         b.title (1 .. title'Length) := title;
      end if;

        b.pag := pag;
      return b;
   end create_book;

   function get_author (s: in Book) return String is
   begin
      return s.author;
   end get_author;

   function get_title (s: in Book) return String is
   begin
      return s.title;
   end get_title;

   function get_pages (s: in Book) return PAGES is
   begin
      return s.pag;
   end get_pages;

end Books;
