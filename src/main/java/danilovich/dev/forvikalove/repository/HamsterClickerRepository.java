package danilovich.dev.forvikalove.repository;

import danilovich.dev.forvikalove.model.HamsterClicker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HamsterClickerRepository extends JpaRepository<HamsterClicker, Long> {
}
