package com.library.services;

import com.library.Library;
import com.library.models.Book;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookService
{
    private static BookService bookService;

    public static BookService getInstance()
    {
        if (bookService == null)
        {
            bookService = new BookService();
        }
        return bookService;
    }

    public Library library = Library.getInstance();

    public void addBook(final Book book)
    {
        library.books.add(book);
    }

    public List<Book> findBookByYear(final int year)
    {
        Predicate<Book> matchBook = book -> book.getYear() == year;
        Stream<Book> bookStream = library.books.stream();
        return bookStream.filter(matchBook).collect(Collectors.toList());
    }

    public void editBook(final int index, final Book bookUpdate)
    {
        Book book = findBookByIndex(index);
        book.setTitle(bookUpdate.getTitle());
        book.setAuthor(bookUpdate.getAuthor());
        book.setYear(bookUpdate.getYear());
        book.setGenre(bookUpdate.getGenre());
    }

    public Book findBookByIndex(final int index)
    {
        return library.books.get(index);
    }


    public int getBookIndex(final Book book)
    {
        return library.books.indexOf(book);
    }


    public List<Book> findAll()
    {
        return library.books;
    }

    public void remove(final Book bookToRemove)
    {
        library.books.remove(bookToRemove);
    }

    public void initBooks()
    {
        library.initBooks();
    }

    public void clearBooks()
    {
        library.books.clear();
    }
}
