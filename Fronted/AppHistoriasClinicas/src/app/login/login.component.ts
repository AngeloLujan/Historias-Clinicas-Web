import { Component } from '@angular/core';
import { NgForm} from '@angular/forms';
import { LoginService } from '../service/login.service';
import { Credenciales } from '../model/credenciales';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  creds: Credenciales = {
    email : '',
    password : ''
  }

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  login(form: NgForm){
    this.loginService.login(this.creds)
      .subscribe(Response => {
        this.router.navigate(['listaPaciente'])
      })
  }
}
