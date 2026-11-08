package danilovich.dev.forvikalove.controller;

import danilovich.dev.forvikalove.model.HamsterClicker;
import danilovich.dev.forvikalove.service.HamsterClickerService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/hamster")
public class HamsterController {
    private final HamsterClickerService hamsterClickerService;

    public HamsterController(HamsterClickerService hamsterClickerService) {
        this.hamsterClickerService = hamsterClickerService;
    }

    @GetMapping
    public HamsterClicker getClickers() {
        return hamsterClickerService.getClickerById(1L);
    }

    @PostMapping("/kiss")
    public HamsterClicker kissHamster(@RequestParam(defaultValue = "1") int count, Long id) {
        return hamsterClickerService.kiss(count);
    }
}
