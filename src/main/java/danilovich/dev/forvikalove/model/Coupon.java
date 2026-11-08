package danilovich.dev.forvikalove.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "category", nullable = false)
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(name = "used", nullable = false)
    private CouponStatus status;

    @Column(name = "used_at")
    private LocalDate usedAt;

    public Coupon(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.status = CouponStatus.AVAILABLE;
        this.usedAt = null;
    }

    public Coupon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CouponStatus getStatus() {
        return status;
    }

    public void setStatus(CouponStatus status) {
        this.status = status;
    }

    public LocalDate getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(LocalDate usedAt) {
        this.usedAt = usedAt;
    }
}
