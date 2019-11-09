import { Component, OnInit } from '@angular/core';
import { PlayerService } from 'src/app/_service/player.service';
import { Player } from 'src/app/_model/player';


@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {

  players: Player[];

  constructor(private playerService: PlayerService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.playerService.getPlayersList()
    .subscribe(players=>this.players=players)
  }

  deletePlayer(player:Player){
    this.playerService.deletePlayer(player.id)
    .subscribe(data =>{this.loadData();})
  }
}
