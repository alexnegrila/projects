package com.library.menus;

import com.library.services.BookService;
import com.library.models.AcademicJournals;
import com.library.models.DVDs;
import com.library.models.LoanableLaptopComputers;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuSystem {
    public static Scanner in = new Scanner(System.in);

    public static ArrayList<AcademicJournals> myacademicjournals = new ArrayList<AcademicJournals>();
    public static ArrayList<DVDs> mydvds = new ArrayList<DVDs>();
    public static ArrayList<LoanableLaptopComputers> myloanablelaptopcomputers = new ArrayList<LoanableLaptopComputers>();
    public static BookService bookService = BookService.getInstance();
    // global scanner and arraylist

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //Calls a method that puts some values into the arraylists
        bookService.initBooks();
        hardValues1();
        hardValues2();
        hardValues3();



        //Calls the method to display the main menu to the screen
        mainMenu();


    } //ends the main method

    public static void mainMenu() {
		/*...................................................................................
		 * Displays the main menu to the screen
		 * ..................................................................................
		 */

        int menu = 0;
        System.out.println(" **** University Learning Resource Centre Menu ****  ");
        System.out.println("    ");
        System.out.println("1. com.library.models.Book");
        System.out.println("2. com.library.models.AcademicJournals ");
        System.out.println("3. com.library.models.DVDs");
        System.out.println("4. com.library.models.LoanableLaptopComputers");
        System.out.println("");
        System.out.println("0. Quit");
        System.out.println("");
        System.out.println("Enter menu choice ->");

        menu = in.nextInt();
        switch(menu) {

            case 1:
                BookMenu.booksMenu();
                break;

            case 2:
                academicJournalsMenu();
                break;
            case 3:
                dvdsMenu();
                break;

            case 4:
                loanableLaptopComputersMenu();
                break;

            case 0:
                System.out.println("You have chosen to quit. Good Bye!");
                break;

        } //end switch

    }



    private static void loanableLaptopComputersMenu() {

		/*.........................................................
		 * This method displays the 'com.library.models.LoanableLaptopComputers' sub menu to the screen*
		 * .........................................................
		 */

        int menu = 0; //create a variable to hold the menu choice
        // display menu to the screen

        System.out.println(" **** University books Menu **** ");
        System.out.println("");
        System.out.println("1. Add Loanable Laptop Computers");
        System.out.println("2. Remove Loanable Laptop Computers");
        System.out.println("3. List Loanable Laptop Computers");
        System.out.println("4. Find Loanable Laptop Computers");
        System.out.println("5. Edit Loanable Laptop Computers");
        System.out.println("");
        System.out.println("6. com.library.Main Menu");
        System.out.println("");
        System.out.println("Enter your choice - >");

        menu=in.nextInt();


        //use a switch to check the value of the menu variable and branch the code accordingly
        //processing the user's choice

        switch(menu) {

            case 1:
                addloanableLaptopComputers();
                break;

            case 2:
                removeloanableLaptopComputers();
                break;

            case 3:
                listLoanableLaptopComputers();
                break;

            case 4:
                findloanableLaptopComputers();
                break;

            case 5:
                editLoanableLaptopComputers();
                break;

            case 6:
                mainMenu();
                break;



        }



    }

    private static void addloanableLaptopComputers() {

        //Asking the user to tell me about the LoanablelaptopComputers

        //Create a new instance of the LoanablelaptopComputers ( using the com.library.models.LoanableLaptopComputers class as a 'blueprint')
        LoanableLaptopComputers newloanableLaptopComputers = new LoanableLaptopComputers();


        System.out.println("Name:");
        String name = in.next();

        System.out.println("Windows:");
        int windows = in.nextInt();

        System.out.println("Year:");
        int year = in.nextInt();

        System.out.println("Processor:");
        String processor = in.next();

        System.out.println("Availability:");
        String availability = in.next();

        //Tell the new LoanablelaptopComputers all about themselves



		/* Use the setLoanableLaptopComputers method in com.library.models.LoanableLaptopComputers class to set the values of the attributes that describe the com.library.models.LoanableLaptopComputers */

        newloanableLaptopComputers.setLoanableLaptopComputers(name, windows, year, processor, availability);

        //Now that my loanablelaptopcomputers are all set up, I can add them to my myloanablelaptopcomputers array list
        myloanablelaptopcomputers.add(newloanableLaptopComputers);

        //Return back to the com.library.models.LoanableLaptopComputers menu
        loanableLaptopComputersMenu();
    }


    private static void findloanableLaptopComputers() {

		/*...........................................................................................
		 * This method finds the loanableLaptopComputers in the arrayist based on an entered windows.
	     *................................................
		 */

        //Asks the user to enter the windows of the com.library.models.LoanableLaptopComputers that they want to find
        System.out.println("Please type windows:");
        int windows = in.nextInt();

        // Loop through the array to find matches to the value in the 'windows' variable..

        for(int i=0; i<myloanablelaptopcomputers.size(); i++) {

            // Where the windows of the LoanablelaptopComputers matches the contents of the windows variable....
            if(myloanablelaptopcomputers.get(i).GetWindows() == windows) {
                System.out.println("Name: " + myloanablelaptopcomputers.get(i).getName() + "\n"
                        + "Windows: " + myloanablelaptopcomputers.get(i).GetWindows()
                        + "\n" + "Year: " + myloanablelaptopcomputers.get(i).getYear() + "\n"
                        + "Processor: " + myloanablelaptopcomputers.get(i).getProcessor() + "\n"
                        + "Availability: " + myloanablelaptopcomputers.get(i).getAvailability());

            }
        }

        //return the user back to the LoanablelaptopComputers menu
        loanableLaptopComputersMenu();


    }

    private static void hardValues1() {
		/*........................................................................
		 * This method creates three com.library.models.LoanableLaptopComputers and adds them to the myloanablelaptopcomputers arraylist
		 * ........................................................................
		 *
		 */

        //Use the com.library.models.LoanableLaptopComputers class to make three new instances of com.library.models.LoanableLaptopComputers
        LoanableLaptopComputers loanablelaptopcomputer1 = new LoanableLaptopComputers();
        LoanableLaptopComputers loanablelaptopcomputer2 = new LoanableLaptopComputers();
        LoanableLaptopComputers loanablelaptopcomputer3= new LoanableLaptopComputers();

        //set the values for those three com.library.models.LoanableLaptopComputers

        loanablelaptopcomputer1.setLoanableLaptopComputers("Lenovo", 8, 2015, "Intel Core I3", "Available");
        loanablelaptopcomputer2.setLoanableLaptopComputers("HP", 10, 2017, "Intel Core I9", "Not Available");
        loanablelaptopcomputer3.setLoanableLaptopComputers("Asus", 7, 2010, "Intel Pentium", "Available");


        //add those three loanablelaptopcomputers to the array list called myloanablelaptopcomputers
        myloanablelaptopcomputers.add(loanablelaptopcomputer1);
        myloanablelaptopcomputers.add(loanablelaptopcomputer2);
        myloanablelaptopcomputers.add(loanablelaptopcomputer3);

    }

    private static void listLoanableLaptopComputers() {

		/*...................................................................
		 * This method loops through the myloanablelaptopcomputers array list and displays
		 * the contents on the screen
		 *
		 * ..................................................................
		 */


        // loop through the myloanablelaptopcomputers array list
        for(int i=0; i < myloanablelaptopcomputers.size(); i++) {
            // display the details of each book to screen
            System.out.println("Name: " + myloanablelaptopcomputers.get(i).getName() + "\n"
                    + "Windows: " + myloanablelaptopcomputers.get(i).GetWindows() + "\n"
                    + "Year: " + myloanablelaptopcomputers.get(i).getYear() + "\n"
                    + "Processor: " + myloanablelaptopcomputers.get(i).getProcessor() + "\n"
                    + "Availability: " + myloanablelaptopcomputers.get(i).getAvailability() + "\n");




        }
        // return to the menu
        loanableLaptopComputersMenu();




    }

    private static void removeloanableLaptopComputers() {
		/*.................................................................................................
		 * This method finds a loanableLaptopComputers in the myloanablelaptopcomputers array list based on a year entered by
		 * the user.
		 * .................................................................................................
		 *
		 */

        //Ask the user to enter a year
        System.out.println("Please type a year:");
        int year = in.nextInt();

        //Loop through the arraylist to find a match
        for(int i=0; i < myloanablelaptopcomputers.size(); i++) {

            if(myloanablelaptopcomputers.get(i).getYear() == year) {
                myloanablelaptopcomputers.remove(i);
                // removes item from arraylist

            }
        }

        // return to the LoanablelaptopComputers menu
        loanableLaptopComputersMenu();

    } //ends remove loanablelaptopcomputers

    private static void editLoanableLaptopComputers() {

		/*.....................................................................
		 * Need to write a method to edit a loanablelaptopcomputer. You could find a loanablelaptopcomputer and then
		 * ask the user to enter the details again. These could then be re-written
		 * to that specific element in the arraylist.
		 * .........................................................................
		 */

        loanableLaptopComputersMenu();

    }

    private static void dvdsMenu() {

		/*.........................................................
		 * This method displays the 'com.library.models.DVDs' sub menu to the screen*
		 * .........................................................
		 */

        int menu = 0; //create a variable to hold the menu choice
        // display menu to the screen

        System.out.println(" **** University com.library.models.DVDs Menu **** ");
        System.out.println("");
        System.out.println("1. Add com.library.models.DVDs");
        System.out.println("2. Remove com.library.models.DVDs");
        System.out.println("3. List com.library.models.DVDs");
        System.out.println("4. Find com.library.models.DVDs");
        System.out.println("5. Edit com.library.models.DVDs");
        System.out.println("");
        System.out.println("6. com.library.Main Menu");
        System.out.println("");
        System.out.println("Enter your choice - >");

        menu=in.nextInt();


        //use a switch to check the value of the menu variable and branch the code accordingly
        //processing the user's choice

        switch(menu) {

            case 1:
                adddvds();
                break;

            case 2:
                removedvds();
                break;

            case 3:
                listdvds();
                break;

            case 4:
                finddvds();
                break;

            case 5:
                editdvds();
                break;

            case 6:
                mainMenu();
                break;



        }



    }

    private static void adddvds() {

        //Asking the user to tell me about the dvds

        //Create a new instance of the dvds ( using the com.library.models.DVDs class as a 'blueprint')
        DVDs newdvds = new DVDs();


        System.out.println("Title:");
        String title = in.next();

        System.out.println("Author:");
        String author = in.next();

        System.out.println("Genre:");
        String genre = in.next();

        System.out.println("Year:");
        int year = in.nextInt();

        System.out.println("More Info:");
        String more_info = in.next();

        //Tell the new dvds all about themselves



		/* Use the setDVDs method in com.library.models.DVDs class to set the values of the attributes that describe the com.library.models.DVDs */

        newdvds.setDVDs(title, author, genre, year, more_info);


        //Now that my dvds are all set up, I can add them to my mydvds array list
        mydvds.add(newdvds);

        //Return back to the com.library.models.DVDs menu
        dvdsMenu();
    }


    private static void finddvds() {

		/*...........................................................................................
		 * This method finds the dvds in the arrayist based on an entered year.
		 * ..........................................................................................
		 */

        //Asks the user to enter the year of the com.library.models.DVDs that they want to find
        System.out.println("Please type year:");
        int year = in.nextInt();

        // Loop through the array to find matches to the value in the 'year' variable..

        for(int i=0; i<mydvds.size(); i++) {

            // Where the year of the book matches the contents of the year variable....
            if(mydvds.get(i).getYear() == year) {
                System.out.println("Title: " + mydvds.get(i).getTitle() + "\n"
                        + "Author: " + mydvds.get(i).getAuthor()
                        + "\n" + "Genre: " + mydvds.get(i).getGenre() + "\n"
                        + "Year: " + mydvds.get(i).getYear() + "\n"
                        + "More Info: " + mydvds.get(i).getMore_Info());

            }
        }

        //return the user back to the dvds menu
        dvdsMenu();


    }

    private static void hardValues2() {
		/*........................................................................
		 * This method creates three com.library.models.DVDs and adds them to the mydvds arraylist
		 * ........................................................................
		 *
		 */

        //Use the com.library.models.DVDs class to make three new instances of com.library.models.DVDs
        DVDs dvd1 = new DVDs();
        DVDs dvd2 = new DVDs();
        DVDs dvd3= new DVDs();

        //set the values for those three com.library.models.DVDs

        dvd1.setDVDs("The Lord of The Rings", "Peter Jackson", "Fantasy", 2001, "The Lord of the Rings is a film series " + "\n"
                + "consisting of three high fantasy adventure films directed by Peter Jackson. " + "\n"
                + "They are based on the novel The Lord of the Rings by J. R. R. Tolkien. " + "\n"
                + "The films are subtitled The Fellowship of the Ring (2001), The Two Towers (2002) and The Return of the King (2003). " + "\n"
                + "They are a New Zealand-American venture produced by WingNut Films and The Saul Zaentz Company and distributed by New Line Cinema.");
        dvd2.setDVDs("Escape from Sobibor", "Jack Gold", "Drama", 1987, "Escape from Sobibor is a 1987 British television film which aired on CBS.[1] " + "\n"
                + "It is the story of the mass escape from the extermination camp at Sobibor, " + "\n"
                + "the most successful uprising by Jewish prisoners of German extermination camps (uprisings also took place at " + "\n"
                + "Auschwitz-Birkenau and Treblinka). The film was directed by Jack Gold and shot in Avala, Yugoslavia (now Serbia).");
        dvd3.setDVDs("The Godfather", "Francis Ford Coppola", "Crime", 1972, "The Godfather is a 1972 American crime film directed " + "\n"
                + "by Francis Ford Coppola and produced by Albert S. Ruddy, based on Mario Puzo's best-selling eponymous novel. " + "\n"
                + "It stars Marlon Brando and Al Pacino as the leaders of a fictional New York crime family. " + "\n"
                + "The story, spanning 1945 to 1955, chronicles the family under the patriarch Vito Corleone (Brando), " + "\n"
                + "focusing on the transformation of Michael Corleone (Pacino) from reluctant family outsider to ruthless mafia boss.");


        //add those three dvds to the array list called mydvds
        mydvds.add(dvd1);
        mydvds.add(dvd2);
        mydvds.add(dvd3);

    }

    private static void listdvds() {

		/*...................................................................
		 * This method loops through the mydvds array list and displays
		 * the contents on the screen
		 *
		 * ..................................................................
		 */


        // loop through the mydvds array list
        for(int i=0; i < mydvds.size(); i++) {
            // display the details of each dvd to screen
            System.out.println("Title: " + mydvds.get(i).getTitle() + "\n"
                    + "Author: " + mydvds.get(i).getAuthor() + "\n"
                    + "Genre: " + mydvds.get(i).getGenre() + "\n"
                    + "Year: " + mydvds.get(i).getYear() + "\n"
                    + "More Info: " + mydvds.get(i).getMore_Info() + "\n");




        }
        // return to the menu
        dvdsMenu();




    }

    private static void removedvds() {
		/*.................................................................................................
		 * This method finds a dvd in the mydvds array list based on a genre entered by
		 * the user.
		 * .................................................................................................
		 *
		 */

        //Ask the user to enter a genre
        System.out.println("Please type a genre:");
        String genre = in.next();

        //Loop through the arraylist to find a match
        for(int i=0; i < mydvds.size(); i++) {

            if(mydvds.get(i).getGenre() == genre) {
                mydvds.remove(i);
                // removes item from arraylist

            }
        }

        // return to the dvds menu
        dvdsMenu();

    } //ends remove dvd

    private static void editdvds() {

		/*.....................................................................
		 * Need to write a method to edit a dvd. You could find a dvd and then
		 * ask the user to enter the details again. These could then be re-written
		 * to that specific element in the arraylist.
		 * .........................................................................
		 */

        dvdsMenu();

    }


    private static void academicJournalsMenu() {

		/*.........................................................
		 * This method displays the 'com.library.models.AcademicJournals' sub menu to the screen*
		 * .........................................................
		 */

        int menu = 0; //create a variable to hold the menu choice
        // display menu to the screen

        System.out.println(" **** University Academic Journals Menu **** ");
        System.out.println("");
        System.out.println("1. Add Academic Journals");
        System.out.println("2. Remove Academic Journals");
        System.out.println("3. List Academic Journals");
        System.out.println("4. Find Academic Journals");
        System.out.println("5. Edit Academic Journals");
        System.out.println("");
        System.out.println("6. com.library.Main Menu");
        System.out.println("");
        System.out.println("Enter your choice - >");

        menu=in.nextInt();


        //use a switch to check the value of the menu variable and branch the code accordingly
        //processing the user's choice

        switch(menu) {

            case 1:
                addAcademicJournals();
                break;

            case 2:
                removeAcademicJournals();
                break;

            case 3:
                listAcademicJournals();
                break;

            case 4:
                findAcademicJournals();
                break;

            case 5:
                editAcademicJournals();
                break;

            case 6:
                mainMenu();
                break;



        }



    }

    private static void addAcademicJournals() {

        //Asking the user to tell me about the com.library.models.AcademicJournals

        //Create a new instance of the com.library.models.AcademicJournals( using the com.library.models.AcademicJournals class as a 'blueprint')
        AcademicJournals newacademicjournals = new AcademicJournals();

        System.out.println("Title:");
        String title = in.next();

        System.out.println("Author:");
        String author = in.next();

        System.out.println("Year:");
        int year = in.nextInt();

        System.out.println("Articles:");
        String articles = in.next();

        System.out.println("Frequency:");
        int frequency = in.nextInt();

        System.out.println("Cost:");
        int cost = in.nextInt();

        System.out.println("Journal Size:");
        String journal_size = in.next();

        System.out.println("Article Length:");
        String article_length = in.next();

        //Tell the new com.library.models.AcademicJournals all about themselves



		/* Use the setAcademicJournals method in com.library.models.AcademicJournals class to set the values of the attributes that describe the com.library.models.AcademicJournals */

        newacademicjournals.setAcademicJournals(title, author, year, articles, frequency, cost, journal_size, article_length);

        //Now that my Academic Journals are all set up, I can add them to my myacademicjournals array list
        myacademicjournals.add(newacademicjournals);

        //Return back to the com.library.models.AcademicJournals menu
        academicJournalsMenu();
    }


    private static void findAcademicJournals() {

		/*...........................................................................................
		 * This method finds the com.library.models.AcademicJournals in the arrayist based on an entered year.
		 * ..........................................................................................
		 */

        //Asks the user to enter the year of the com.library.models.AcademicJournals that they want to find
        System.out.println("Please type year:");
        int year = in.nextInt();

        // Loop through the array to find matches to the value in the 'year' variable..

        for(int i=0; i<myacademicjournals.size(); i++) {

            // Where the year of the book matches the contents of the year variable....
            if(myacademicjournals.get(i).getYear() == year) {
                System.out.println("Title: " + myacademicjournals.get(i).getTitle() + "\n"
                        + "Author: " + myacademicjournals.get(i).GetAuthor()
                        + "\n" + "Year: " + myacademicjournals.get(i).getYear() + "\n"
                        + "Articles: " + myacademicjournals.get(i).getArticles() + "\n"
                        + "Frequency: " + myacademicjournals.get(i).getFrequency() + "\n"
                        + "Cost: " + myacademicjournals.get(i).getCost() + "\n"
                        + "Journal Size: " + myacademicjournals.get(i).getJournal_Size() + "\n"
                        + "Article Length: " + myacademicjournals.get(i).getArticle_Length());


            }
        }

        //return the user back to the academicJournals menu
        academicJournalsMenu();


    }

    private static void hardValues3() {
		/*........................................................................
		 * This method creates three academic journals and adds them to the myacademicjournals arraylist
		 * ........................................................................
		 *
		 */

        //Use the AcademicJournal class to make three new instances of Academic Journals
        AcademicJournals academicjournal1 = new AcademicJournals();
        AcademicJournals academicjournal2 = new AcademicJournals();
        AcademicJournals academicjournal3 = new AcademicJournals();

        //set the values for those three Academic Journals

        academicjournal1.setAcademicJournals("The Historical Journal", "Cambridge University Press", 1958, "54 Articles", 300, 30, "10000 pages", "185 pages");
        academicjournal2.setAcademicJournals("International Journal of Cardiovascular Medicine", "Karger", 1937, "25 Articles", 250, 100, "5000 pages", "200pages");
        academicjournal3.setAcademicJournals("African Journal of Mathematics and Computer Science Research", "Harvard University", 2008, "223 Articles", 450, 65, "9624 pages", "43 pages");


        //add those three academicjournals to the array list called myacademicjournals
        myacademicjournals.add(academicjournal1);
        myacademicjournals.add(academicjournal2);
        myacademicjournals.add(academicjournal3);


    }

    private static void listAcademicJournals() {

		/*...................................................................
		 * This method loops through the myacademicjournals array list and displays
		 * the contents on the screen
		 *
		 * ..................................................................
		 */


        // loop through the myacademicjournals array list
        for(int i=0; i < myacademicjournals.size(); i++) {
            // display the details of each academic journal to screen
            System.out.println("Title: " + myacademicjournals.get(i).getTitle() + "\n"
                    + "Author: " + myacademicjournals.get(i).GetAuthor()
                    + "\n" + "Year: " + myacademicjournals.get(i).getYear() + "\n"
                    + "Articles: " + myacademicjournals.get(i).getArticles() + "\n"
                    + "Frequency: " + myacademicjournals.get(i).getFrequency() + "\n"
                    + "Cost: " + myacademicjournals.get(i).getCost() + "\n"
                    + "Journal Size: " + myacademicjournals.get(i).getJournal_Size() + "\n"
                    + "Article Length: " + myacademicjournals.get(i).getArticle_Length() + "\n");




        }
        // return to the menu
        academicJournalsMenu();




    }

    private static void removeAcademicJournals() {
		/*.................................................................................................
		 * This method finds a book in the myacademicjournals array list based on a year entered by
		 * the user.
		 * .................................................................................................
		 *
		 */

        //Ask the user to enter a year
        System.out.println("Please type a year:");
        int year = in.nextInt();

        //Loop through the arraylist to find a match
        for(int i=0; i < myacademicjournals.size(); i++) {

            if(myacademicjournals.get(i).getYear() == year) {
                myacademicjournals.remove(i);
                // removes item from arraylist

            }
        }

        // return to the academic journals menu
        academicJournalsMenu();

    } //ends remove academic journals

    private static void editAcademicJournals() {

		/*.....................................................................
		 * Need to write a method to edit an academic journal. You could find an academic journal and then
		 * ask the user to enter the details again. These could then be re-written
		 * to that specific element in the arraylist.
		 * .........................................................................
		 */

        academicJournalsMenu();

    }


}  // end class

