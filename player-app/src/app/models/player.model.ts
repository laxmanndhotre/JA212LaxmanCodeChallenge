export class Player {
    playerId?: number;
    playerName: string;
    jerseyNo: number;
    role: string;
    matches: number;
    team: string;
    countryState: string;
    description: string;
  
    constructor(playerName: string, jerseyNo: number, role: string, matches: number, team: string, countryState: string, description: string, playerId?: number) {
      this.playerId = playerId;
      this.playerName = playerName;
      this.jerseyNo = jerseyNo;
      this.role = role;
      this.matches = matches;
      this.team = team;
      this.countryState = countryState;
      this.description = description;
    }
  }
  