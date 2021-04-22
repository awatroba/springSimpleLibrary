package pk.ztp.springlibrary.Services;

import org.springframework.stereotype.Service;
import pk.ztp.springlibrary.Exception.BookExistException;
import pk.ztp.springlibrary.Exception.BookNotFoundException;
import pk.ztp.springlibrary.beans.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {
    private List<Book> books;

    public DashboardService() {
        books = new ArrayList();
        books.add(new Book("Później","Stephen King",2021));
        books.add(new Book("Łzy diabła","Magdalena Kozak",2021));
        books.add(new Book("Sekta","Marek Stelar",2021));
        books.add(new Book("Schronisko","Sam Lloyd",2020));
        books.add(new Book("Rozkwit magii","Nora Roberts",2021));
        books.add(new Book("Prion","Konrad Lorens",2001));
        books.add(new Book("Mroczny tunel","Ross MacDonald",2004));
    }
    public Book getBookById(int id) throws BookNotFoundException
    {
        Book book = null;
        for(Book b : books){
            if(b.getId()==id){
                return b;
            }
        }
        if(book == null )
            throw new BookNotFoundException(id);
        return book;
    }

    public Book deleteBook(int id) throws BookNotFoundException
    {
        Book book = null;
        book=getBookById(id);
        books.remove(book);
        return book;
    }

    public List<Book> addBook(Book newBookRequest) throws BookExistException {
        for(Book b : books){
            if(b.getAuthor().equals(newBookRequest.getAuthor())
                    || b.getTitle().equals(newBookRequest.getTitle())
                    || b.getYear()==newBookRequest.getYear()){
                throw new BookExistException(newBookRequest);
            }
        }
        books.add(newBookRequest);
        return books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
