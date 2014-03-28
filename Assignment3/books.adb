with Ada.Characters.Handling;
use Ada.Characters.Handling;

package body Books is

   -----------------
   -- create_book --
   -----------------

   function create_book
     (author: in String;
      title: in String;
      leaves: in PAGES)
      return Book
   is
      boo : Book;
   begin
      if author'Length > MAX_AUTHOR_NAME_SIZE then
         boo.author := author(1 .. MAX_AUTHOR_NAME_SIZE);
      else
         boo.author (1 .. author'Length) := author;
      end if;
      if title'Length > MAX_TITLE_SIZE then
         boo.title := title(1 .. MAX_TITLE_SIZE);
      else
         boo.title (1 .. title'Length) := title;
      end if;

        boo.leaves := leaves;
      return boo;
   end create_book;

   ----------------
   -- get_author --
   ----------------

   function get_author (s: in Book) return String is
   begin
      return s.author;
   end get_author;

   ---------------
   -- get_title --
   ---------------

   function get_title (s: in Book) return String is
   begin
      return s.title;
   end get_title;

   ---------------
   -- get_pages --
   ---------------

   function get_pages (s: in Book) return PAGES is
   begin
      return s.leaves;
   end get_pages;

end Books;
