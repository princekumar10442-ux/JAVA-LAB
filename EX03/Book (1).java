import java.time.LocalDate;

public class Book {

    public String name;
    public String authorName;
    public double price;
    public String publisherName;
    public String genre;
    public String ISBN;
    public LocalDate dateOfPublishing;

    public Book() {
        name = "unknown";
        price = 0.0;
        authorName = "unknown";
        publisherName = "unknown publisher";
        genre = "uncategorized";
        ISBN = "0000000";
        dateOfPublishing = LocalDate.parse("2020-01-01");
    }

    public Book(String n, String a, double p, String isbn)
            throws InvalidPriceException {

        name = n;
        authorName = a;

        if (p < 0) {
            throw new InvalidPriceException("Price cannot be negative");
        }

        price = p;
        ISBN = isbn;
        genre = "uncategorized";
        publisherName = "unknown publisher";
        dateOfPublishing = LocalDate.now();
    }

    public Book(String n, String a, String g, double p)
            throws InvalidPriceException, InvalidGenreException {

        name = n;
        authorName = a;

        if (!g.equalsIgnoreCase("fiction") &&
            !g.equalsIgnoreCase("autobiography")) {
            throw new InvalidGenreException("Invalid genre");
        }

        genre = g;

        if (p < 0) {
            throw new InvalidPriceException("Price cannot be negative");
        }

        price = p;
        ISBN = "0000000";
        publisherName = "unknown publisher";
        dateOfPublishing = LocalDate.now();
    }
}
