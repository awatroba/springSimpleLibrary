package pk.ztp.springlibrary.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pk.ztp.springlibrary.Exception.BookExistException;
import pk.ztp.springlibrary.Exception.BookNotFoundException;
import pk.ztp.springlibrary.Services.DashboardService;
import pk.ztp.springlibrary.beans.Book;

import java.util.List;

@RestController
public class DashboardController {
    private DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService= dashboardService;
    }

    @GetMapping(value="/dashboard")
    public List<Book> getAllBooks(){
        return dashboardService.getBooks();
    }

    @PostMapping(value="/dashboard")
    public List<Book> addBook(@RequestBody Book book) throws BookExistException {
        return dashboardService.addBook(book);    }

    @GetMapping(value="/dashboard/{id}")
    public Book getBookById(@PathVariable ("id") int bookId  ) throws BookNotFoundException {
        return dashboardService.getBookById(bookId);
    }
    @DeleteMapping(value="/dashboard/{id}")
    public Book deleteBookById(@PathVariable("id") int bookId) throws BookNotFoundException{
        return dashboardService.deleteBook(bookId);

    }
}
