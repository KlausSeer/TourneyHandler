import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  
  private baseURL = 'http://localhost:8080/api/matchs';
  
    constructor(private http:HttpClient) { }
  
    createMatch(match: Object): Observable<Object>{
      return this.http.post(`${this.baseURL}`, match);
    }
  
    updateMatch(match: Object): Observable<Object>{
      return this.http.put(`${this.baseURL}`, match);
    }
  
    deleteMatch(id:number): Observable<any>{
      return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
    }
  
    getMatchsList(): Observable<any>{
      return this.http.get(`${this.baseURL}`);
    }
  
    getMatchById(id: number): Observable<any>{
      return this.http.get(`${this.baseURL}/${id}`);
    }
  
}
