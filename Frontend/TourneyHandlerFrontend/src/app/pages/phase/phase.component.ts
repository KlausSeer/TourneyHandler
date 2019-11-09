import { Component, OnInit } from '@angular/core';
import { PhaseService } from 'src/app/_service/phase.service';
import { Phase } from 'src/app/_model/phase';


@Component({
  selector: 'app-phase',
  templateUrl: './phase.component.html',
  styleUrls: ['./phase.component.css']
})
export class PhaseComponent implements OnInit {

  phases: Phase[];

  constructor(private phaseService: PhaseService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.phaseService.getPhasesList()
    .subscribe(phases=>this.phases=phases)
  }

  deletePhase(phase:Phase){
    this.phaseService.deletePhase(phase.id)
    .subscribe(data =>{this.loadData();})
  }
}
