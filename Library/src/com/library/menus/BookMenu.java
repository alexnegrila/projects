package com.library.menus;

import com.library.services.BookService;
import com.library.models.Book;

import java.util.List;
import java.util.Scanner;

/**
 * Created by alexandriann on 27/12/2017.
 */
public class BookMenu
{
    public static Scanner in = new Scanner(System.in);

    private static final BookService bookService = BookService.getInstance();

    public static void booksMenu() {

		/*.........................................................
		 * This method displays the 'com.library.models.Book' sub menu to the screen*
		 * .........................................................
		 */

        int menu = 0; //create a variable to hold the menu choice
        // display menu to the screen

        System.out.println(" **** University com.library.models.Book Menu **** ");
        System.out.println("");
        System.out.println("1. Add com.library.models.Book");
        System.out.println("2. Remove com.library.models.Book");
        System.out.println("3. List com.library.models.Book");
        System.out.println("4. Find com.library.models.Book");
        System.out.println("5. Edit com.library.models.Book");
        System.out.println("");
        System.out.println("6. com.library.Main Menu");
        System.out.println("");
        System.out.println("Enter your choice - >");

        menu=in.nextInt();


        //use a switch to check the value of the menu variable and branch the code accordingly
        //processing the user's choice

        switch(menu) {

            case 1:
                addBook();
                break;

            case 2:
                removeBook();
                break;

            case 3:
                listBooks();
                break;

            case 4:
                findBook();
                break;

            case 5:
                editBook();
                break;

            case 6:
                MenuSystem.mainMenu();
                break;



        }



    }

    private static void addBook() {

        //Asking the user to tell me about the books

        //Create a new instance of the books ( using the com.library.models.Book class as a 'blueprint')
        Book newBook = getBookDetails();

        //Tell the new books all about themselves


		/* Use the setBooks method in com.library.models.Book class to set the values of the attributes that describe the books */

        //Now that my books are all set up, I can add them to my bookService.books array list
        bookService.addBook(newBook);

        //Return back to the books menu
        booksMenu();
    }

    private static void removeBook() {
		/*.................................................................................................
		 * This method finds a book in the bookService.books array list based on a year entered by
		 * the user.
		 * .................................................................................................
		 */

        //Ask the user to enter a index
        System.out.println("Please type an index:");
        int index = in.nextInt();

        Book bookToRemove = bookService.findBookByIndex(index);
        bookService.remove(bookToRemove);

        // return to the books menu
        booksMenu();

    } //ends remove books

    private static Book getBookDetails()
    {
        Book newBook = new Book();

        System.out.println("Title:");
        String title = in.next();
        newBook.setTitle(title);

        System.out.println("Author:");
        String author = in.next();
        newBook.setAuthor(author);

        System.out.println("Year:");
        int year = in.nextInt();
        newBook.setYear(year);

        System.out.println("Genre:");
        String genre = in.next();
        newBook.setGenre(genre);

        return newBook;
    }

    private static void findBook() {

		/*...........................................................................................
		 * This method finds the books in the arraylist based on an entered year.
		 * ..........................................................................................
		 */

        //Asks the user to enter the year of the book that they want to find
        System.out.println("Please type year:");
        int year = in.nextInt();

        // Loop through the array to find matches to the value in the 'year' variable..

        List<Book> books = bookService.findBookByYear(year);

        books.stream().forEach(book -> printBook(book));

        //return the user back to the books menu
        booksMenu();


    }

    private static void printBook(final Book book)
    {
        System.out.println("Title: " + book.getTitle() + "\n"
                + "Author: " + book.getAuthor()
                + "\n" + "Year: " + book.getYear() + "\n"
                + "Genre: " + book.getGenre());
    }

    private static void listBooks() {

		/*...................................................................
		 * This method loops through the bookService.books array list and displays
		 * the contents on the screen
		 *
		 * ..................................................................
		 */

        // loop through the bookService.books array list
        for(int i=0; i < bookService.findAll().size(); i++) {
            // display the details of each book to screen
            Book book = bookService.findBookByIndex(i);
            System.out.println("Index: " + i + "\n");
            printBook(book);
        }
        // return to the menu
        booksMenu();

    }

    private static void editBook() {

		/*.....................................................................
		 * Need to write a method to edit a book. You could find a book and then
		 * ask the user to enter the details again. These could then be re-written
		 * to that specific element in the arraylist.
		 * .........................................................................
		 */

        //Ask the user to enter a index
        System.out.println("Please type an index:");
        int index = in.nextInt();

        Book bookUpdate = getBookDetails();

        Book bookToEdit = bookService.findBookByIndex(index);
        System.out.println("Book to edit current details:");
        printBook(bookToEdit);
        bookService.editBook(index, bookUpdate);
        booksMenu();

    }


}
