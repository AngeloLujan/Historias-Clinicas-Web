import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";

import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListadoPacienteComponent } from './paciente/listado-paciente/listado-paciente.component';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './helpers/auth.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { UpdatePacienteComponent } from './paciente/update-paciente/update-paciente.component';
import { CreateHistoriaClinicaComponent } from './historiaClinica/create-historia-clinica/create-historia-clinica.component';
import { CreatePacienteComponent } from './paciente/create-paciente/create-paciente.component';
import { ListadoHistoriaClinicaComponent } from './historiaClinica/listado-historia-clinica/listado-historia-clinica.component';
import { UpdateHistoriaClinicaComponent } from './historiaClinica/update-historia-clinica/update-historia-clinica.component';

@NgModule({
  declarations: [
    AppComponent,
    ListadoPacienteComponent,
    LoginComponent,
    UpdatePacienteComponent,
    CreateHistoriaClinicaComponent,
    CreatePacienteComponent,
    ListadoHistoriaClinicaComponent,
    UpdateHistoriaClinicaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule, BrowserAnimationsModule, MatTableModule, MatPaginatorModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
