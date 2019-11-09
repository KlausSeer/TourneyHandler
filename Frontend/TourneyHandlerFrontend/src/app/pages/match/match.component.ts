import { Component, OnInit } from '@angular/core';
import { MatchService } from 'src/app/_service/match.service';
import { Match } from 'src/app/_model/match';


@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent implements OnInit {

  matchs: Match[];

  constructor(private matchService: MatchService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.matchService.getMatchsList()
    .subscribe(matchs=>this.matchs=matchs)
  }

  deleteMatch(match:Match){
    this.matchService.deleteMatch(match.id)
    .subscribe(data =>{this.loadData();})
  }
}
