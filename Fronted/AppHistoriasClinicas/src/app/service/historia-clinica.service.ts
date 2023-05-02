import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs'
import { HistoriaClinica, HistoriaClinicaAlergias, HistoriaClinicaAntecedentes, HistoriaClinicaMedicamentosFrecuentes } from '../model/historia-clinica';

@Injectable({
  providedIn: 'root'
})
export class HistoriaClinicaService {

  private urlBase = 'http://localhost:8080/api';
  private httpHeaders = new HttpHeaders({'Content-type': 'application/json'});

  constructor(private http: HttpClient){}


  createHistoriaClinica(historiaClinica: HistoriaClinica) : Observable<Object>{
    return this.http.post(this.urlBase + '/historiaClinica',historiaClinica ,
    {headers : this.httpHeaders})
  }

  getAllHistoriaClinica(){
    return this.http.get<HistoriaClinica[]>(this.urlBase + '/historiaClinica');
  }

  getHistoriaClinicaById(id : number){
    return this.http.get<HistoriaClinica>(this.urlBase + '/historiaClinica/' + id);
  }

  getAllHistoriaClinicaAlergiasbyHistoriaClinicaId(historiaClinicaId :number){
    return this.http.get<HistoriaClinicaAlergias>(this.urlBase + '/historiaClinicaAlergias/' + historiaClinicaId);
  }

  getAllHistoriaClinicaAntecedentesbyHistoriaClinicaId(historiaClinicaId :number){
    return this.http.get<HistoriaClinicaAntecedentes>(this.urlBase + '/historiaClinicaAntecedentes/' + historiaClinicaId);
  }

  getAllHistoriaClinicaMedicamentosFrecuentesbyHistoriaClinicaId(historiaClinicaId :number){
    return this.http.get<HistoriaClinicaMedicamentosFrecuentes>(this.urlBase + '/historiaClinicaMedicamentosFrecuentes/' + historiaClinicaId);
  }
}
