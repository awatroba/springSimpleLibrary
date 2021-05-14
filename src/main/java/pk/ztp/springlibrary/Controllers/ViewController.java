package pk.ztp.springlibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}