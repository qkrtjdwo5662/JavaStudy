package extends1.ex;

public class ShopMain {
    public static void main(String[] args) {
        Book book = new Book("Java", 10000 , "han", "12345");
        Album album = new Album("album1", 15000, "seo");
        Movie movie = new Movie("movie1", 18000, "감독1", "배우1");

        book.print();
        album.print();
        movie.print();

    }
}
