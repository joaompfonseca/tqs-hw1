package tqs.hw1.envmonitor.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tqs.hw1.envmonitor.service.EnvService;

@Controller
public class WebController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final EnvService envService;

    public WebController(EnvService envService) {
        this.envService = envService;
    }

    @GetMapping("/")
    public String index() {
        logger.info("GET /");
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "q") String location, Model model) {
        logger.info("GET /search?q=" + location);
        if (location == null || location.isBlank()) {
            logger.info("Fallback to GET /");
            return index();
        }
        model.addAttribute("env_current", envService.getCurrentEnv(location));
        model.addAttribute("env_forecast", envService.getForecastEnv(location));
        model.addAttribute("query", location);
        return "index";
    }
}
