import java.util.ArrayList;

public class ArrayListOfBooks {

    public static void main(String[] args)
            throws InvalidPriceException, InvalidGenreException {

        ArrayList<Book> bList = new ArrayList<>();

        // Default Book
        Book b1 = new Book();
        bList.add(b1);

        // -------- TRY 1 : Invalid Genre --------
        try {
            Book b2 = new Book("Eclipse", "Stephenie Meyer", "fantasy", 455.99);
            bList.add(b2);
        }
        catch (InvalidGenreException e) {
            System.out.println("Genre Error: " + e.getMessage());
        }

        // -------- TRY 2 : Invalid Price --------
        try {
            Book b3 = new Book("Atomic Habits", "James Clear", -899.99, "HLP12345");
            bList.add(b3);
        }
        catch (InvalidPriceException e) {
            System.out.println("Price Error: " + e.getMessage());
        }

        // -------- Valid Books (No try-catch) --------
        Book b4 = new Book("The Alchemist", "Paulo Coelho", "fiction", 399.99);
        Book b5 = new Book("Wings of Fire", "A.P.J Abdul Kalam", "autobiography", 499.99);

        bList.add(b4);
        bList.add(b5);

        // -------- Display All Book Details --------
        System.out.println("\nAll Book Details:\n");

        for (Book b : bList) {
            System.out.println("Name: " + b.name);
            System.out.println("Author: " + b.authorName);
            System.out.println("Price: " + b.price);
            System.out.println("Genre: " + b.genre);
            System.out.println("---------------------------");
        }

        // -------- Display Books Grouped By Genre --------
        System.out.println("\nBooks Grouped According To Genre:\n");

        ArrayList<String> printedGenres = new ArrayList<>();

        for (Book b : bList) {

            if (!printedGenres.contains(b.genre)) {

                System.out.println("Genre: " + b.genre);

                for (Book book : bList) {
                    if (book.genre.equalsIgnoreCase(b.genre)) {
                        System.out.println("   " + book.name);
                    }
                }

                System.out.println();
                printedGenres.add(b.genre);
            }
        }

        // -------- Calculate Average Price --------
        double total = 0;

        for (Book b : bList) {
            total += b.price;
        }

        if (!bList.isEmpty()) {
            double avg = total / bList.size();
            System.out.println("Average Price of Books = " + avg);
        }
    }
}
