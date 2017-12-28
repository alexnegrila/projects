package com.library;

import static org.junit.Assert.*;

import com.library.models.Book;
import com.library.services.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookServiceTest
{

    public static final int TEST_YEAR = 1969;

    public static final String TEST_TITLE = "test title";

    public static final int FIRST_INDEX = 0;

    public static final String TEST_AUTHOR = "test author";

    public static final String TEST_GENRE = "test genre";

    public static final int TEST_INDEX = 1;

    public BookService bookService = BookService.getInstance();

    private Book bookStub;

    @Before
    public void setUp()
    {
        bookStub = new Book();
        bookService.addBook(bookStub);
    }

    @Test
    public void addBookTest() {
        Book book = bookService.findBookByIndex(FIRST_INDEX);
        assertEquals(bookStub, book);
    }

    @Test
    public void removeBookTest() {
        bookService.remove(bookStub);
        assertTrue(bookService.findAll().isEmpty());
    }

    @Test
    public void findBookByIndexTest() {
        Book bookStub = new Book();
        bookService.addBook(bookStub);
        Book book = bookService.findBookByIndex(bookService.findAll().size()-1);
        assertEquals(bookStub, book);
    }

    @Test
    public void findBookByYearTest() {
        Book bookStub = new Book();
        bookStub.setYear(TEST_YEAR);
        bookService.addBook(bookStub);

        List<Book> books = bookService.findBookByYear(TEST_YEAR);

        assertEquals(bookStub, books.get(0));
    }

    @Test
    public void findBookByYearEmptyTest() {
        List<Book> books = bookService.findBookByYear(1);
        assertTrue(books.isEmpty());
    }

    @Test
    public void editBookTest() {
        Book bookStub = new Book();
        bookService.addBook(bookStub);
        Book bookEditStub = new Book();
        bookEditStub.setTitle(TEST_TITLE);
        bookEditStub.setYear(TEST_YEAR);
        bookEditStub.setAuthor(TEST_AUTHOR);
        bookEditStub.setGenre(TEST_GENRE);

        bookService.editBook(FIRST_INDEX, bookEditStub);

        assertEquals(TEST_TITLE, bookService.findBookByIndex(FIRST_INDEX).getTitle());
        assertEquals(TEST_AUTHOR, bookService.findBookByIndex(FIRST_INDEX).getAuthor());
        assertEquals(TEST_YEAR, bookService.findBookByIndex(FIRST_INDEX).getYear());
        assertEquals(TEST_GENRE, bookService.findBookByIndex(FIRST_INDEX).getGenre());
    }

    @After
    public void tearDown()
    {
        bookService.clearBooks();
    }
}
