package com.example.demo.services;


import java.util.List;
import java.util.Optional;
import com.example.demo.mapper.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Player;
import com.example.demo.repositories.PlayerRepository;


import java.util.stream.Collectors;

import com.example.demo.dto.*;
@Service
public class PlayerServiceImpl implements IPlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(PlayerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PlayerDTO> getPlayerById(Integer id) {
        return playerRepository.findById(id)
                .map(PlayerMapper::toDto);
    }

    @Override
    public PlayerDTO addPlayer(PlayerDTO dto) {
        Player player = PlayerMapper.toEntity(dto);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMapper.toDto(savedPlayer);
    }

    @Override
    public PlayerDTO updatePlayer(Integer id, PlayerDTO dto) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setPlayerName(dto.getPlayerName());
            player.setJerseyNo(dto.getJerseyNo());
            player.setRole(dto.getRole());
            player.setMatches(dto.getMatches());
            player.setTeam(dto.getTeam());
            player.setCountryState(dto.getCountryState());
            player.setDescription(dto.getDescription());
            Player updatedPlayer = playerRepository.save(player);
            return PlayerMapper.toDto(updatedPlayer);
        } else {
            throw new RuntimeException("Player not found");
        }
    }

    @Override
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }
}
