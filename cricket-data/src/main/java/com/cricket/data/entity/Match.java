package com.cricket.data.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private int score;
    private String stadium;
    @ManyToOne
    private Player player;

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for score
    public int getScore() {
        return score;
    }

    // Setter for score
    public void setScore(int score) {
        this.score = score;
    }

    // Getter for stadium
    public String getStadium() {
        return stadium;
    }

    // Setter for stadium
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    // Getter for playerDto
    public Player getPlayerDto() {
        return player;
    }

    // Setter for playerDto
    public void setPlayerDto(Player playerDto) {
        this.player = playerDto;
    }
}
