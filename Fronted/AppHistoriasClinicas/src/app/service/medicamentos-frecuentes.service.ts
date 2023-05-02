import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs'
import { MedicamentosFrecuentes } from '../model/medicamentos-frecuentes';

@Injectable({
  providedIn: 'root'
})
export class MedicamentosFrecuentesService {

  private urlBase = 'http://localhost:8080/api';

  constructor(
    private http: HttpClient
  ) { }

  getAllMedicamentosFrecuentes(): Observable<MedicamentosFrecuentes[]>{
    return this.http.get<MedicamentosFrecuentes[]>(this.urlBase + '/medicamentosFrecuentes');
  }
}
