import { Component, OnInit } from '@angular/core';
import { TeamService } from 'src/app/_service/team.service';
import { Team } from 'src/app/_model/team';


@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {

  teams: Team[];

  constructor(private teamService: TeamService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.teamService.getTeamsList()
    .subscribe(teams=>this.teams=teams)
  }

  deleteTeam(team:Team){
    this.teamService.deleteTeam(team.id)
    .subscribe(data =>{this.loadData();})
  }
}
