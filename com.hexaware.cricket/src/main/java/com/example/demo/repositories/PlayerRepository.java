package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	

}
