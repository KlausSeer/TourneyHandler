import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {

  private baseURL = 'http://localhost:8080/api/tournaments';
  
    constructor(private http:HttpClient) { }
  
    createTournament(tournament: Object): Observable<Object>{
      return this.http.post(`${this.baseURL}`, tournament);
    }
  
    updateTournament(tournament: Object): Observable<Object>{
      return this.http.put(`${this.baseURL}`, tournament);
    }
  
    deleteTournament(id:number): Observable<any>{
      return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
    }
  
    getTournamentsList(): Observable<any>{
      return this.http.get(`${this.baseURL}`);
    }
  
    getTournamentById(id: number): Observable<any>{
      return this.http.get(`${this.baseURL}/${id}`);
    }  

}
