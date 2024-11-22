package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Player;
import com.example.demo.exceptions.PlayerNotFoundException;

public interface IPlayerService {
	
	    List<Player> getAllPlayers();
	    Optional<Player> getPlayerById(Integer id) throws PlayerNotFoundException;
	    Player addPlayer(Player player);
	    Player updatePlayer(Integer id, Player newPlayer) throws PlayerNotFoundException;
	    void deletePlayer(Integer id);
	

}
