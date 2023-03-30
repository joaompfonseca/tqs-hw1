package tqs.hw1.envmonitor.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tqs.hw1.envmonitor.data.env.EnvDTO;
import tqs.hw1.envmonitor.service.EnvService;

@RestController
@RequestMapping("/api/env")
public class EnvRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final EnvService envService;

    public EnvRestController(EnvService envService) {
        this.envService = envService;
    }

    @GetMapping("/current")
    public EnvDTO getCurrentEnv(@RequestParam("q") String location) {
        logger.info("GET /api/env/current?q=" + location);
        return envService.getCurrentEnv(location);
    }

    @GetMapping("/forecast")
    public EnvDTO getForecastEnv(@RequestParam("q") String location) {
        logger.info("GET /api/env/forecast?q=" + location);
        return envService.getForecastEnv(location);
    }
}
