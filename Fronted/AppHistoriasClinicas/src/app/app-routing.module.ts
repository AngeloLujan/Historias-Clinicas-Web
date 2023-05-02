import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoPacienteComponent } from './paciente/listado-paciente/listado-paciente.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './helpers/auth.guard';
import { UpdatePacienteComponent } from './paciente/update-paciente/update-paciente.component';
import { CreateHistoriaClinicaComponent } from './historiaClinica/create-historia-clinica/create-historia-clinica.component';

const routes: Routes = [
  {path: "listaPaciente", component: ListadoPacienteComponent, canActivate : [AuthGuard]},
  {path: "editarPaciente/:id", component: UpdatePacienteComponent},
  {path: "createHistoriaClinica", component: CreateHistoriaClinicaComponent},
  {path: "login", component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
