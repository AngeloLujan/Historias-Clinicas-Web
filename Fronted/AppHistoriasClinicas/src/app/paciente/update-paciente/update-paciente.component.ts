import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Paciente } from 'src/app/model/paciente';
import { PacienteService } from 'src/app/service/paciente.service';

@Component({
  selector: 'app-update-paciente',
  templateUrl: './update-paciente.component.html',
  styleUrls: ['./update-paciente.component.css']
})
export class UpdatePacienteComponent {

  paciente : Paciente

  constructor(
    private pacienteService : PacienteService,
    private activateRouter : ActivatedRoute,
    private router: Router
  ){}

  ngOnInit(): void {
    const id = this.activateRouter.snapshot.params['id'];
    this.pacienteService.getPacienteById(id).subscribe(data => this.paciente =data);
  }

  actualizar(){
    this.pacienteService.createPaciente(this.paciente).subscribe(
      data => this.router.navigate(['/listaPaciente'])
    )
  }

}
