import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Alergias } from '../model/alergias';
import { Observable} from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class AlergiasService {

  private urlBase = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) { }

  getAllAlergias(): Observable<Alergias[]>{
    return this.http.get<Alergias[]>(this.urlBase + '/alergias');
  }
}
