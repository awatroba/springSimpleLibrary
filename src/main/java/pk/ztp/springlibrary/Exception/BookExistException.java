package pk.ztp.springlibrary.Exception;

import pk.ztp.springlibrary.beans.Book;

public class BookExistException extends Exception {
    public BookExistException(Book book) {
        super(book+ " already exists!");
    }
}
