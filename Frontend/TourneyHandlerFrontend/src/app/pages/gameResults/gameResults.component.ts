import { Component, OnInit } from '@angular/core';
import { GameResultsService } from 'src/app/_service/gameResults.service';
import { GameResults } from 'src/app/_model/gameResults';


@Component({
  selector: 'app-gameResults',
  templateUrl: './gameResults.component.html',
  styleUrls: ['./gameResults.component.css']
})
export class GameResultsComponent implements OnInit {

  gameResultss: GameResults[];

  constructor(private gameResultsService: GameResultsService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.gameResultsService.getGameResultssList()
    .subscribe(gameResultss=>this.gameResultss=gameResultss)
  }

  deleteGameResults(gameResults:GameResults){
    this.gameResultsService.deleteGameResults(gameResults.id)
    .subscribe(data =>{this.loadData();})
  }
}
