import { Component, OnInit } from '@angular/core';
import { StatisticsService } from 'src/app/_service/statistics.service';
import { Statistics } from 'src/app/_model/statistics';


@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  statisticss: Statistics[];

  constructor(private statisticsService: StatisticsService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.statisticsService.getStatisticssList()
    .subscribe(statisticss=>this.statisticss=statisticss)
  }

  deleteStatistics(statistics:Statistics){
    this.statisticsService.deleteStatistics(statistics.id)
    .subscribe(data =>{this.loadData();})
  }
}
