import { Component, OnInit } from '@angular/core';
import { Tournament } from 'src/app/_model/tournament';
import { TournamentService } from 'src/app/_service/tournament.service';


@Component({
  selector: 'app-tournament',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css']
})
export class TournamentComponent implements OnInit {

  tournaments: Tournament[];

  constructor(private tournamentService: TournamentService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.tournamentService.getTournamentsList()
    .subscribe(tournaments=>this.tournaments=tournaments)
  }

  deleteTournament(tournament:Tournament){
    this.tournamentService.deleteTournament(tournament.id)
    .subscribe(data =>{this.loadData();})
  }
}
