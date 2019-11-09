import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PhaseService {
  
  private baseURL = 'http://localhost:8080/api/phases';
  
    constructor(private http:HttpClient) { }
  
    createPhase(phase: Object): Observable<Object>{
      return this.http.post(`${this.baseURL}`, phase);
    }
  
    updatePhase(phase: Object): Observable<Object>{
      return this.http.put(`${this.baseURL}`, phase);
    }
  
    deletePhase(id:number): Observable<any>{
      return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
    }
  
    getPhasesList(): Observable<any>{
      return this.http.get(`${this.baseURL}`);
    }
  
    getPhaseById(id: number): Observable<any>{
      return this.http.get(`${this.baseURL}/${id}`);
    }
  
}
