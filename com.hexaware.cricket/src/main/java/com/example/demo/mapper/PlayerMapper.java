package com.example.demo.mapper;
 
import com.example.demo.entities.*;
import com.example.demo.dto.PlayerDTO;



public class PlayerMapper {
    public static PlayerDTO toDto(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setJerseyNo(player.getJerseyNo());
        dto.setRole(player.getRole());
        dto.setMatches(player.getMatches());
        dto.setTeam(player.getTeam());
        dto.setCountryState(player.getCountryState());
        dto.setDescription(player.getDescription());
        return dto;
    }

    public static Player toEntity(PlayerDTO dto) {
        Player player = new Player();
        player.setPlayerId(dto.getPlayerId());
        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNo(dto.getJerseyNo());
        player.setRole(dto.getRole());
        player.setMatches(dto.getMatches());
        player.setTeam(dto.getTeam());  // Corrected this line
        player.setCountryState(dto.getCountryState());
        player.setDescription(dto.getDescription());
        return player;
    }
}
