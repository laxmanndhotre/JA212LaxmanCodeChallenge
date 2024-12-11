import { Component, OnInit } from '@angular/core';
import { PlayerService } from '../player.service';
import { Player } from '../models/player.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class PlayerComponent implements OnInit {
  players: Player[] = [];
  isUpdating: boolean = false;
  currentPlayer: Player | null = null;

  constructor(private playerService: PlayerService) { }

  ngOnInit(): void {
    this.loadPlayers();
  }

  loadPlayers(): void {
    this.playerService.getPlayers().subscribe(data => {
      this.players = data;
    });
  }

  onSubmit(formValue: any): void {
    const player: Player = formValue;
    if (this.isUpdating && this.currentPlayer) {
      player.playerId = this.currentPlayer.playerId;
      this.playerService.updatePlayer(player).subscribe({
        next: () => {
          this.resetForm();
          this.loadPlayers(); // Refresh the list
        },
        error: (err) => {
          console.error('Error updating player', err);
        },
        complete: () => {
          console.log('Player update completed');
        }
      });
    } else {
      this.playerService.addPlayer(player).subscribe({
        next: () => {
          this.resetForm();
          this.loadPlayers(); // Refresh the list
        },
        error: (err) => {
          console.error('Error adding player', err);
        },
        complete: () => {
          console.log('Player addition completed');
        }
      });
    }
  }

  loadPlayer(player: Player): void {
    this.currentPlayer = player;
    this.isUpdating = true;
  }

  resetForm(): void {
    this.currentPlayer = null;
    this.isUpdating = false;
  }
}
