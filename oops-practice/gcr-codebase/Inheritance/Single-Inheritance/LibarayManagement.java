class Book
{
    protected String title;
    protected int publicationYear;
    // Book()
    // {
    //     this.title = title;
    //     this.publicationYear = publicationYear;
    // }
}

class Author extends Book
{
    protected String name;
    protected String bio;

    Author(String name, String bio, String title, int publicationYear)
    {
        this.name = name;
        this.bio = bio;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayDetails()
    {
        System.out.println("Book name is "+ title + ". \nWritten by " + name + ". \nPublished in year " + publicationYear +". \n"+bio);

    }
}


public class LibarayManagement 
{
    public static void main(String[] args) 
    {
        Book book1 = new Book();
        Author author1 = new Author("Prem Chand", "The was a great writer.", "2 bhelo ki katha", 1954);
        author1.displayDetails();


    }    
}
