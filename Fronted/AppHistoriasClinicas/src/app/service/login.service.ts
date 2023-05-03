import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { Credenciales } from '../model/credenciales';
import { Usuario } from '../model/usuario';
import jwt_decode from 'jwt-decode';
import {Router} from "@angular/router";


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private urlBase = 'http://localhost:8080';
  private httpHeaders = new HttpHeaders({'Content-type': 'application/json'});

  private usuario : Usuario;

  constructor(
    private http: HttpClient,
    private router : Router
  ) { }

  login(credentials: Credenciales) {
    return this.http.post(this.urlBase + '/login', credentials, {
      observe: 'response'
    }).pipe(map((response: HttpResponse<any>) => {
      const body = response.body;
      const headers = response.headers;

      const bearerToken = headers.get('Authorization')!;
      const token = bearerToken.replace('Bearer ', '');

      localStorage.setItem('token', token);

      const decodedToken : any = jwt_decode(token);
      const subject = decodedToken.sub;
      this.getUsuario(subject);
      return body;
    }))
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['login']);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  getUsuario(email: string){
    return this.http.get<Usuario>(this.urlBase + '/api/usuarioByEmail?email=' +email)
      .subscribe( usuario => {
        this.usuario = usuario;
        localStorage.setItem('usuarioId', this.usuario.id.toString());
      })
  }
}
