package com.cricket.data.controller;

import com.cricket.data.dto.PlayerDto;
import com.cricket.data.dto.PlayerWithAverageScore;
import com.cricket.data.entity.Player;
import com.cricket.data.exception.PlayerNotFoundException;
import com.cricket.data.repository.PlayerRepository;
import com.cricket.data.util.PlayerAverageScoreComparator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {


    @Autowired
    private PlayerRepository playerRepository;



    // Create Player Details
    @PostMapping("/create")
    public Player createPlayer(@RequestBody PlayerDto playerDto) {
        // Implement logic to create a new player
        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        return playerRepository.save(player);
    }


    // Update by id
    @PutMapping("/update/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        // Implement logic to update an existing player
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));

        player.setName(updatedPlayer.getName());
        player.setDateOfBirth(updatedPlayer.getDateOfBirth());
        player.setCountry(updatedPlayer.getCountry());
        // Update other fields as needed

        return playerRepository.save(player);
    }


    // Delete by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable Long id) {
        // Implement logic to delete a player
        playerRepository.findById(id).ifPresent(player -> playerRepository.delete(player));
        return ResponseEntity.ok().build();
    }


    // Get by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
        return ResponseEntity.ok(player);
    }


    // Get by average score greater than
    @GetMapping("/average-score-greater-than/{x}")
    public List<PlayerWithAverageScore> getPlayersWithAverageScoreGreaterThanX(double x) {
        List<Object[]> playerAverageScores = playerRepository.findPlayersWithAverageScoreGreaterThanX(x);
        List<PlayerWithAverageScore> result = new ArrayList<>();
        for (Object[] data : playerAverageScores) {
            Player player = (Player) data[0];
            Double averageScore = (Double) data[1];

            result.add(new PlayerWithAverageScore(player, averageScore));
        }
        return result;
    }

    // Get by country
    @GetMapping("/by-country/{country}")
    public List<Player> getPlayersByCountry(@PathVariable String country) {
        return playerRepository.findByCountry(country);
    }


    // Get by average score greater than and sorted
    public List<PlayerWithAverageScore> getPlayersSortedByAverageScore(double y) {
        List<Object[]> playerAverageScores = playerRepository.findPlayersWithAverageScoreGreaterThanX(y);
        List<PlayerWithAverageScore> result = new ArrayList<>();
        for (Object[] data : playerAverageScores) {
            Player player = (Player) data[0];
            Double averageScore = (Double) data[1];

            result.add(new PlayerWithAverageScore(player, averageScore));
        }
        // Sort the result list using a custom comparator
        result.sort(new PlayerAverageScoreComparator());

        return result;
    }



}