package com.cricket.data.dto;

import com.cricket.data.entity.Player;

public class PlayerWithAverageScore {
    private Player player;
    private Double averageScore;

    public PlayerWithAverageScore(Player player, Double averageScore) {
        this.player = player;
        this.averageScore = averageScore;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }
}
