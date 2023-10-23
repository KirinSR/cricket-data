package com.cricket.data.dto;

import com.cricket.data.entity.Player;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchDto {

    private Long id;

    private int score;
    private String stadium;

    private PlayerDto playerDto;

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
    public PlayerDto getPlayerDto() {
        return playerDto;
    }

    // Setter for playerDto
    public void setPlayerDto(PlayerDto playerDto) {
        this.playerDto = playerDto;
    }
}
