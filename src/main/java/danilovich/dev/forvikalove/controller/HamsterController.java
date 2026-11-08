package danilovich.dev.forvikalove.controller;

import danilovich.dev.forvikalove.model.HamsterClicker;
import danilovich.dev.forvikalove.service.HamsterClickerService;
import org.springframework.web.bind.annotation.*;


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
    public HamsterClicker kissHamster(@RequestParam(defaultValue = "1") int count) {
        return hamsterClickerService.kiss(count);
    }
}
