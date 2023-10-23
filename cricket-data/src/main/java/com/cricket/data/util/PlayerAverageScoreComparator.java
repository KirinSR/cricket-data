package com.cricket.data.util;

import com.cricket.data.dto.PlayerWithAverageScore;

import java.util.Comparator;

public class PlayerAverageScoreComparator implements Comparator<PlayerWithAverageScore> {
    @Override
    public int compare(PlayerWithAverageScore player1, PlayerWithAverageScore player2) {
        // Compare by average score in descending order
        int scoreComparison = Double.compare(player2.getAverageScore(), player1.getAverageScore());

        if (scoreComparison == 0) {
            // If average scores are equal, compare by date of birth in ascending order
            return player1.getPlayer().getDateOfBirth().compareTo(player2.getPlayer().getDateOfBirth());
        }

        return scoreComparison;
    }
}