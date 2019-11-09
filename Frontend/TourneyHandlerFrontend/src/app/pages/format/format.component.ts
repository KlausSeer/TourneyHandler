import { Component, OnInit } from '@angular/core';
import { FormatService } from 'src/app/_service/format.service';
import { Format } from 'src/app/_model/format';


@Component({
  selector: 'app-format',
  templateUrl: './format.component.html',
  styleUrls: ['./format.component.css']
})
export class FormatComponent implements OnInit {

  formats: Format[];

  constructor(private formatService: FormatService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.formatService.getFormatsList()
    .subscribe(formats=>this.formats=formats)
  }

  deleteFormat(format:Format){
    this.formatService.deleteFormat(format.id)
    .subscribe(data =>{this.loadData();})
  }
}
