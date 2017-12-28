package com.library;

import com.library.models.Book;

import java.util.ArrayList;

public class Library
{
    private static Library library;

    public ArrayList<Book> books = new ArrayList<Book>();

    public static Library getInstance()
    {
        if (library == null)
        {
            library = new Library();
        }
        return library;
    }

    public void initBooks() {
		/*........................................................................
		 * This method creates three books and adds them to the bookService.books arraylist
		 * ........................................................................
		 *
		 */

        //Use the com.library.models.Book class to make three new instances of books
        Book book = new Book();
        book.setTitle("Ten Little Niggers");
        book.setAuthor("Agatha Christie");
        book.setYear(1939);
        book.setGenre("Mystery Novel");
        books.add(book);

        book.setTitle("Les Amoureux de Léningrad");
        book.setAuthor("Charles Exbrayat");
        book.setYear(1969);
        book.setGenre("Drama");
        books.add(book);

        book.setTitle("Faust");
        book.setAuthor("Johann Wolfgang von Goethe");
        book.setYear(1808);
        book.setGenre("Tragey");
        books.add(book);
    }
}
