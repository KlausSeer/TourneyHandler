import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormatService {

private baseURL = 'http://localhost:8080/api/formats';

  constructor(private http:HttpClient) { }

  createFormat(format: Object): Observable<Object>{
    return this.http.post(`${this.baseURL}`, format);
  }

  updateFormat(format: Object): Observable<Object>{
    return this.http.put(`${this.baseURL}`, format);
  }

  deleteFormat(id:number): Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
  }

  getFormatsList(): Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }

  getFormatById(id: number): Observable<any>{
    return this.http.get(`${this.baseURL}/${id}`);
  }

}
