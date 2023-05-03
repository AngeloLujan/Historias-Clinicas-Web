import { Component } from '@angular/core';
import {LoginService} from "./service/login.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AppHistoriasClinicas';

  constructor(
    private loginService: LoginService,
  ) {
  }

  hasToken() {
    console.log(this.loginService.getToken());
    return this.loginService.getToken() != null;
  }

  logout() {
    return this.loginService.logout();
  }
}
