import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Paciente } from 'src/app/model/paciente';
import { PacienteService } from 'src/app/service/paciente.service';

@Component({
  selector: 'app-create-paciente',
  templateUrl: './create-paciente.component.html',
  styleUrls: ['./create-paciente.component.css']
})
export class CreatePacienteComponent implements OnInit{

  paciente: Paciente = new Paciente();

  constructor(
    private pacienteService : PacienteService, private router : Router
    ){}

  ngOnInit(): void {

  }

  save(){
    this.pacienteService.createPaciente(this.paciente).subscribe(
      data => this.router.navigate(['/listaPaciente'])
    )
  };


}
