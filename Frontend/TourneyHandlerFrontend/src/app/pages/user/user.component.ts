import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/_service/user.service';
import { User } from 'src/app/_model/user';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.userService.getUsersList()
    .subscribe(users=>this.users=users)
  }

  deleteUser(user:User){
    this.userService.deleteUser(user.id)
    .subscribe(data =>{this.loadData();})
  }
}
