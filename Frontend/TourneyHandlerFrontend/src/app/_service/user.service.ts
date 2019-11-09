import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL = 'http://localhost:8080/api/users';
  
  constructor(private http:HttpClient) { }

  createUser(user: Object): Observable<Object>{
    return this.http.post(`${this.baseURL}`, user);
  }

  updateUser(user: Object): Observable<Object>{
    return this.http.put(`${this.baseURL}`, user);
  }

  deleteUser(id:number): Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`, {responseType: 'text'});
  }

  getUsersList(): Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }

  getUserById(id: number): Observable<any>{
    return this.http.get(`${this.baseURL}/${id}`);
  }

}
