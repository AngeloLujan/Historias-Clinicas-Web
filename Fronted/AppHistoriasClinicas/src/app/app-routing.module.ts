import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoPacienteComponent } from './paciente/listado-paciente/listado-paciente.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './helpers/auth.guard';
import { UpdatePacienteComponent } from './paciente/update-paciente/update-paciente.component';
import { CreateHistoriaClinicaComponent } from './historiaClinica/create-historia-clinica/create-historia-clinica.component';
import { CreatePacienteComponent } from './paciente/create-paciente/create-paciente.component';
import { ListadoHistoriaClinicaComponent } from './historiaClinica/listado-historia-clinica/listado-historia-clinica.component';
import { UpdateHistoriaClinicaComponent } from './historiaClinica/update-historia-clinica/update-historia-clinica.component';

const routes: Routes = [
  {path: "", redirectTo: 'listaPaciente', pathMatch: 'full'},
  {path: "listaPaciente", component: ListadoPacienteComponent, canActivate: [AuthGuard]},
  {path: "createPaciente", component: CreatePacienteComponent, canActivate: [AuthGuard]},
  {path: "editarPaciente/:id", component: UpdatePacienteComponent, canActivate: [AuthGuard]},
  {path: "listaHistoriaClinica", component: ListadoHistoriaClinicaComponent, canActivate: [AuthGuard]},
  {path: "createHistoriaClinica", component: CreateHistoriaClinicaComponent, canActivate: [AuthGuard]},
  {path: "editarHistoriaClinica/:id", component: UpdateHistoriaClinicaComponent, canActivate: [AuthGuard]},
  {path: "login", component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
