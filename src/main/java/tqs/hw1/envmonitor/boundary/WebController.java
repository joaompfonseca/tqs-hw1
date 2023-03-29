package tqs.hw1.envmonitor.boundary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tqs.hw1.envmonitor.service.EnvService;

@Controller
public class WebController {

    private final EnvService envService;

    public WebController(EnvService envService) {
        this.envService = envService;
    }

    @GetMapping("/")
    public String index() {
        return "layout";
    }

    @GetMapping("/search")
    public String current(@RequestParam(value = "q", defaultValue = "") String location, @RequestParam(value = "type", defaultValue = "") String type, Model model) {
        if (type.equals("current")) {
            model.addAttribute("env", envService.getCurrentEnv(location));
        }
        if (type.equals("forecast")) {
            model.addAttribute("env", envService.getForecastEnv(location));
        }
        model.addAttribute("query", location);
        return "layout";
    }
}
