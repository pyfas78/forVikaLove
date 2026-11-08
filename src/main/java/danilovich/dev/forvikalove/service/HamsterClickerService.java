package danilovich.dev.forvikalove.service;

import danilovich.dev.forvikalove.exception.NoExistHamsterException;
import danilovich.dev.forvikalove.model.HamsterClicker;
import danilovich.dev.forvikalove.repository.HamsterClickerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HamsterClickerService {
    private final HamsterClickerRepository hamsterClickerRepository;

    public HamsterClickerService(HamsterClickerRepository hamsterClickerRepository) {
        this.hamsterClickerRepository = hamsterClickerRepository;
    }

    @PostConstruct
    public void init() {
        if (hamsterClickerRepository.count() == 0) {
            HamsterClicker hamsterClicker = new  HamsterClicker();
            hamsterClicker.setTotalKisses(0);
            hamsterClicker.setLevel("level_1");
            hamsterClickerRepository.save(hamsterClicker);
        }
    }

    public HamsterClicker getClickerById(Long id) {
        return hamsterClickerRepository.findById(id).orElse(null);
    }


    public HamsterClicker kiss(int count) {
        HamsterClicker hamster = hamsterClickerRepository.findById(1L).orElse(null);
        hamster.setTotalKisses(hamster.getTotalKisses() + count);
        if(hamster.getTotalKisses() < 50) {
            hamster.setLevel("Скромный хомячОк");
        } if(hamster.getTotalKisses() < 200) {
            hamster.setLevel("Довольный хомяк Олег");
        } else if(hamster.getTotalKisses() < 500) {hamster.setLevel("Любими Олег");}
        else if (hamster.getTotalKisses() < 1000) {hamster.setLevel("зацелованный Олег"); }
        else { hamster.setLevel("Абсолютно довольный хомячок");}
        hamster.setLastKissData(LocalDate.now());
        return hamsterClickerRepository.save(hamster);
    }
}
