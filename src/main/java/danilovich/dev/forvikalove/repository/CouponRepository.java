package danilovich.dev.forvikalove.repository;

import danilovich.dev.forvikalove.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    List<Coupon> findByUsed(boolean used);
}
