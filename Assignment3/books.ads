package Books is

   type Book is private;

   MAX_AUTHOR_NAME_SIZE: constant Positive := 30;

   MAX_TITLE_SIZE: constant Positive := 100;

   MAX_PAGES_SIZE: constant Positive := 10000;

   type PAGES is new Positive range 1 .. MAX_PAGES_SIZE;

   function create_book (author: in String; title: in String; leaves: in PAGES)
                         return Book
   with pre => author'Length > 0 and title'Length > 0;

   function get_author (s: in Book) return String;

   function get_title (s: in Book) return String;

   function get_pages (s: in Book) return PAGES;

private
   type Book is
      record
         author: String (1 .. MAX_AUTHOR_NAME_SIZE) := (others => ' ');
         title: String (1 .. MAX_TITLE_SIZE) := (others => ' ');
         leaves: PAGES;
      end record;

end Books;
