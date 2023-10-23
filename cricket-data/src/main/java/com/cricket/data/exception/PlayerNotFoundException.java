package com.cricket.data.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long playerId) {
        super("Player not found with ID: " + playerId);
    }
}
