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

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private LocalDate usedAt;

    public Coupon(String title, String description, String category, boolean active, LocalDate usedAt) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.active = false;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(LocalDate usedAt) {
        this.usedAt = usedAt;
    }
}
