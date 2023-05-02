import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs'
import { HistoriaClinica } from '../model/historia-clinica';

@Injectable({
  providedIn: 'root'
})
export class HistoriaClinicaService {

  URL_SERVICES= 'http://localhost:8080';
  private urlBase = this.URL_SERVICES + '/api';
  private httpHeaders = new HttpHeaders({'Content-type': 'application/json'});

  constructor(private http: HttpClient){}


  createHistoriaClinica(historiaClinica: HistoriaClinica) : Observable<Object>{
    return this.http.post(this.urlBase + '/historiaClinica',historiaClinica ,
    {headers : this.httpHeaders})
  }
}
