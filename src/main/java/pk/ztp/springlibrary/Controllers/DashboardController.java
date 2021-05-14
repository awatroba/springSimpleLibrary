package pk.ztp.springlibrary.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pk.ztp.springlibrary.Exception.BookExistException;
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

    @PostMapping("/dashboard")
    public ResponseEntity<Object> addBook(@RequestBody Book book) throws BookExistException {
        dashboardService.addBook(book);
        ServiceResponse<Book> response = new ServiceResponse<Book>("success", book);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Object> getAllBooks() {
        ServiceResponse<List<Book>> response =
                new ServiceResponse<>("success", dashboardService.getBooks());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
    @DeleteMapping(value = "/dashboard/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable int bookId) {
        Book deleteBook=dashboardService.deleteBook(bookId);
        ServiceResponse<Book> response =
                new ServiceResponse<Book>("success",deleteBook );
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/dashboard/{bookId}")
    public ResponseEntity<Object> getBookById(@PathVariable int bookId) {
        Book searchBook=dashboardService.getBookById(bookId);
        ServiceResponse<Book> response =
                new ServiceResponse<Book>("success",searchBook );
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
