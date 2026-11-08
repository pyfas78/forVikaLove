package danilovich.dev.forvikalove.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "hamster_clicker")
public class HamsterClicker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_kisses")
    private int totalKisses;

    @Column(name = "level")
    private String level;

    @Column(name = "last_kiss_data")
    private LocalDate lastKissData;

    public HamsterClicker(int totalKisses, String level, LocalDate lastKissData) {
        this.totalKisses = 0;
        this.level = "Грустный Одинокий Нелюбимый Ненавистный Никому не нужный Брошенный и т.д. Хомяк";
        this.lastKissData = null;
    }
    public HamsterClicker() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalKisses() {
        return totalKisses;
    }

    public void setTotalKisses(int totalKisses) {
        this.totalKisses = totalKisses;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public LocalDate getLastKissData() {
        return lastKissData;
    }

    public void setLastKissData(LocalDate lastKissData) {
        this.lastKissData = lastKissData;
    }
}
