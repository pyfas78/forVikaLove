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
    public HamsterClicker getClickers(Long id) {
        return hamsterClickerService.getClickerById(id);
    }

    @PostMapping("/kiss")
    public HamsterClicker kissHamster(@RequestParam(defaultValue = "1") int count, Long id) {
        hamsterClickerService.getClickerById(id);
        hamsterClickerService.kiss(count);
        return hamsterClickerService.getClickerById(id);
    }
}
