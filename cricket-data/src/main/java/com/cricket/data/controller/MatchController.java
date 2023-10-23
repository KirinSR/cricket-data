package com.cricket.data.controller;

import com.cricket.data.dto.MatchDto;
import com.cricket.data.entity.Match;
import com.cricket.data.exception.MatchNotFoundException;
import com.cricket.data.repository.MatchRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    @Autowired
    private MatchRepository matchRepository;

    // Create a new match
    @PostMapping("/create")
    public Match createMatch(@RequestBody MatchDto matchDto) {
        Match match = new Match();
        BeanUtils.copyProperties(matchDto, match);
        return matchRepository.save(match);
    }

    // Update an existing match
    @PutMapping("/update/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException(id));

        // Update match details
        match.setScore(updatedMatch.getScore());
        match.setStadium(updatedMatch.getStadium());

        return matchRepository.save(match);
    }

    // Delete a match by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable Long id) {
        matchRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException(id));
        matchRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // Get all matches
    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
}

