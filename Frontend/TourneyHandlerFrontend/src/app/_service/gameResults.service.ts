import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameResultsService {
  
  private baseURL = 'http://localhost:8080/api/gameResultss';
  
    constructor(private http:HttpClient) { }
  
    createGameResults(gameResults: Object): Observable<Object>{
      return this.http.post(`${this.baseURL}`, gameResults);
    }
  
    updateGameResults(gameResults: Object): Observable<Object>{
      return this.http.put(`${this.baseURL}`, gameResults);
    }
  
    deleteGameResults(id:number): Observable<any>{
      return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
    }
  
    getGameResultssList(): Observable<any>{
      return this.http.get(`${this.baseURL}`);
    }
  
    getGameResultsById(id: number): Observable<any>{
      return this.http.get(`${this.baseURL}/${id}`);
    }

}
