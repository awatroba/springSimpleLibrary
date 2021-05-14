package pk.ztp.springlibrary.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pk.ztp.springlibrary.Exception.BookExistException;
import pk.ztp.springlibrary.Exception.BookNotFoundException;
import pk.ztp.springlibrary.Services.DashboardService;
import pk.ztp.springlibrary.Services.ServiceResponse;
import pk.ztp.springlibrary.beans.Book;

import java.util.List;

@RestController
public class DashboardController {
    private DashboardService dashboardService;
    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @PostMapping("/saveBook")
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        ServiceResponse<Book> response;
        try {
            dashboardService.addBook(book);
            response = new ServiceResponse<Book>("success", book);
        } catch (BookExistException e) {
            response = new ServiceResponse<Book>("Error: "+e.getMessage(), book);
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getBooks")
    public ResponseEntity<Object> getAllBooks() {
        ServiceResponse<List<Book>> response;
        response= new ServiceResponse<>("success", dashboardService.getBooks());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
    @DeleteMapping(value = "/dashboard/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable int bookId) {
        Book deleteBook= null;
        ServiceResponse<Book> response;
        try {
            deleteBook = dashboardService.deleteBook(bookId);
            response=new ServiceResponse<Book>("success",deleteBook );
        } catch (BookNotFoundException e) {
            e.printStackTrace();
            response=new ServiceResponse<Book>("Error: "+e.getMessage(),deleteBook );
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/dashboard/{bookId}")
    public ResponseEntity<Object> getBookById(@PathVariable int bookId) {
        Book searchBook= null;
        ServiceResponse<Book> response;
        try {
            searchBook = dashboardService.getBookById(bookId);
            response=new ServiceResponse<Book>("success",searchBook );
        } catch (BookNotFoundException e) {
            e.printStackTrace();
            response=new ServiceResponse<Book>("Error: "+e.getMessage(),searchBook );
        }
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
