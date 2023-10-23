package com.cricket.data.repository;

import com.cricket.data.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByCountry(String country);

    @Query("SELECT p, AVG(m.score) " +
            "FROM Player p " +
            "LEFT JOIN Match m ON p.id = m.player.id " +
            "GROUP BY p.id " +
            "HAVING AVG(m.score) > :x")
    List<Object[]> findPlayersWithAverageScoreGreaterThanX(double x);
}
