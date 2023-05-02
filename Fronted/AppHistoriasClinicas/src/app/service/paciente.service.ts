import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs'
import { Paciente } from '../model/paciente';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  private urlBase = 'http://localhost:8080/api';
  private httpHeaders = new HttpHeaders({'Content-type': 'application/json' });

  constructor(
    private http: HttpClient
  ) { }

  getAllPacientes(){
    return this.http.get<Paciente[]>(this.urlBase + '/pacientes');
  }

  getPacienteById(id : number){
    return this.http.get<Paciente>(this.urlBase + '/paciente/' + id);
  }

  getAllPacientesByTipoDocumentoAndNumeroDocumento(tipoDocumento: string, numeroDocumento: string): Observable<Paciente[]>{
    const urlConstruida = `${this.urlBase}/pacientesByTipoDocumentoAndNumeroDocumento?tipoDocumento=${tipoDocumento}&numeroDocumento=${numeroDocumento}`;
    return this.http.get<Paciente[]>(urlConstruida);
  }

  getAllPacientesByFiltro(tipoDocumento: string, numeroDocumento: string, apellidoPaterno : string, apellidoMaterno : string, nombres :string): Observable<Paciente[]>{
    const urlConstruida = `${this.urlBase}/pacientesFiltro?nombres=${nombres}&apellidoPaterno=${apellidoPaterno}&apellidoMaterno=${apellidoMaterno}&tipoDocumento=${tipoDocumento}&numeroDocumento=${numeroDocumento}`;
    return this.http.get<Paciente[]>(urlConstruida);
  }

  createPaciente(paciente:Object) : Observable<Object>{
    return this.http.post(this.urlBase + '/paciente',paciente ,
    {headers : this.httpHeaders})
  }

  updatePaciente(id: number, paciente: Paciente) : Observable<Object>{
    return this.http.put(this.urlBase + '/paciente/'+ id,paciente,
    {headers : this.httpHeaders})
  }

}
