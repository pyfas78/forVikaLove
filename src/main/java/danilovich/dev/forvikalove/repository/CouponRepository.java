package danilovich.dev.forvikalove.repository;

import danilovich.dev.forvikalove.model.Coupon;
import danilovich.dev.forvikalove.model.CouponStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    List<Coupon> findByStatus(CouponStatus status);
}
