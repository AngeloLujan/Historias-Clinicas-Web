import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Antecedentes } from '../model/antecedentes';
import { Observable} from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class AntecedentesService {

  private urlBase = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) { }

  getAllAntecedentes(): Observable<Antecedentes[]>{
    return this.http.get<Antecedentes[]>(this.urlBase + '/antecedentes');
  }
}
