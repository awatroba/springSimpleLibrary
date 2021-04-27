package pk.ztp.springlibrary.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pk.ztp.springlibrary.Exception.BookExistException;
import pk.ztp.springlibrary.Exception.BookNotFoundException;
import pk.ztp.springlibrary.Services.DashboardService;
import pk.ztp.springlibrary.beans.Book;

@Controller
public class DashboardController {
    private DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping(value = "/dashboard")
    public ModelAndView getAllBooks() {
        ModelAndView mav = new ModelAndView("dashboard");
        mav.addObject("books", dashboardService.getBooks());
        dashboardService.getBooks();
        return mav;
    }

    @PostMapping(value = "/dashboard")
    public ModelAndView addBook(@RequestBody Book book) throws BookExistException {
        dashboardService.addBook(book);
        ModelAndView mav = new ModelAndView("dashboard");
        mav.addObject("books", dashboardService.getBooks());
        dashboardService.getBooks();
        return mav;
    }

    @GetMapping(value = "/dashboard/{id}")
    public ModelAndView deleteBookById(@PathVariable("id") int bookId) throws BookNotFoundException {
        dashboardService.deleteBook(bookId);
        ModelAndView mav = new ModelAndView("dashboard");
        mav.addObject("books", dashboardService.getBooks());
        dashboardService.getBooks();
        return mav;
    }
}
