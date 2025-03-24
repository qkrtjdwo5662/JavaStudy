package nested.test.ex1;

public class Library {
    private Book[] books;
    private int bookCount;

    public Library(int size){
        books = new Book[size];
        bookCount = 0;
    }

    public void addBook(String title, String author){
        if(bookCount < books.length){
            books[bookCount ++] = new Book(title, author);
        }else{
            System.out.println("저장공간 부족함");
        }
    }

    public void showBooks(){
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].author + " " + books[i].title);
        }
    }

    private static class Book {
        private String title;
        private String author;

        public Book(String title, String author){
            this.title = title;
            this.author = author;
        }
    }
}
