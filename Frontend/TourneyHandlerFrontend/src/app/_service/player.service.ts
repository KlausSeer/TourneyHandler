import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  private baseURL = 'http://localhost:8080/api/players';
  
    constructor(private http:HttpClient) { }
  
    createPlayer(player: Object): Observable<Object>{
      return this.http.post(`${this.baseURL}`, player);
    }
  
    updatePlayer(player: Object): Observable<Object>{
      return this.http.put(`${this.baseURL}`, player);
    }
  
    deletePlayer(id:number): Observable<any>{
      return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
    }
  
    getPlayersList(): Observable<any>{
      return this.http.get(`${this.baseURL}`);
    }
  
    getPlayerById(id: number): Observable<any>{
      return this.http.get(`${this.baseURL}/${id}`);
    }
  
}
