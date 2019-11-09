import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  private baseURL = 'http://localhost:8080/api/statisticss';
  
    constructor(private http:HttpClient) { }
  
    createStatistics(statistics: Object): Observable<Object>{
      return this.http.post(`${this.baseURL}`, statistics);
    }
  
    updateStatistics(statistics: Object): Observable<Object>{
      return this.http.put(`${this.baseURL}`, statistics);
    }
  
    deleteStatistics(id:number): Observable<any>{
      return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
    }
  
    getStatisticssList(): Observable<any>{
      return this.http.get(`${this.baseURL}`);
    }
  
    getStatisticsById(id: number): Observable<any>{
      return this.http.get(`${this.baseURL}/${id}`);
    }
  
}
