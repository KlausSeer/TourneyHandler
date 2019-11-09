import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  
  private baseURL = 'http://localhost:8080/api/teams';
  
    constructor(private http:HttpClient) { }
  
    createTeam(team: Object): Observable<Object>{
      return this.http.post(`${this.baseURL}`, team);
    }
  
    updateTeam(team: Object): Observable<Object>{
      return this.http.put(`${this.baseURL}`, team);
    }
  
    deleteTeam(id:number): Observable<any>{
      return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
    }
  
    getTeamsList(): Observable<any>{
      return this.http.get(`${this.baseURL}`);
    }
  
    getTeamById(id: number): Observable<any>{
      return this.http.get(`${this.baseURL}/${id}`);
    }
  
}
