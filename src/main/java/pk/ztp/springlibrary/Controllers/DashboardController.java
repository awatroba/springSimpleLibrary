package pk.ztp.springlibrary.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pk.ztp.springlibrary.Services.DashboardService;

@Controller
public class DashboardController {
    private DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService= dashboardService;
    }

    @GetMapping(value="/dashboard")
    public ModelAndView getAllBooks(){
        ModelAndView mav = new ModelAndView("dashboard");
        mav.addObject("books", dashboardService.getBooks());
        dashboardService.getBooks();
        return mav;
    }
/*
    @PostMapping(value="/dashboard")
    public String  addBook(@RequestBody Book book) throws BookExistException {

        return dashboardService.addBook(book);
    }

    @GetMapping(value="/dashboard/{id}")
    public String  getBookById(@PathVariable ("id") int bookId  ) throws BookNotFoundException {
        return dashboardService.getBookById(bookId);
    }
    @DeleteMapping(value="/dashboard/{id}")
    public String  deleteBookById(@PathVariable("id") int bookId) throws BookNotFoundException{
        return dashboardService.deleteBook(bookId);

    }*/
}
