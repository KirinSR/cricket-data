package com.cricket.data.exception;

public class MatchNotFoundException extends RuntimeException {
    public MatchNotFoundException(Long matchId) {
        super("Match not found with ID: " + matchId);
    }
}
