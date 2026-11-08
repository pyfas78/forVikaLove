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
    public void init(Long id) {
        if (hamsterClickerRepository.count() == 0) {
            HamsterClicker hamsterClicker = hamsterClickerRepository.findById(1L)
                    .orElseThrow(() -> new NoExistHamsterException(id));
            hamsterClicker.setTotalKisses(0);
            hamsterClicker.setLevel("level_1");
            hamsterClickerRepository.save(hamsterClicker);
        }
    }

    public HamsterClicker getClickerById(Long id) {
        return hamsterClickerRepository.findById(id).orElse(null);
    }


    public HamsterClicker kiss(int count) {
        count = 1;
        HamsterClicker hamster = hamsterClickerRepository.findById(1L).orElse(null);
        hamster.setTotalKisses(hamster.getTotalKisses() + count);
        hamster.setLastKissData(LocalDate.now());
        return hamsterClickerRepository.save(hamster);
    }
}
