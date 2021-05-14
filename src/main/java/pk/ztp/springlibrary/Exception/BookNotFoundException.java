package pk.ztp.springlibrary.Exception;

public class BookNotFoundException  extends Exception{
    public BookNotFoundException(int id) {
        super("Book with id "+id+" not found!");
    }
}
