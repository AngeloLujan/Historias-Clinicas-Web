import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Alergias } from 'src/app/model/alergias';
import { Antecedentes } from 'src/app/model/antecedentes';
import { HistoriaClinica } from 'src/app/model/historia-clinica';
import { MedicamentosFrecuentes } from 'src/app/model/medicamentos-frecuentes';
import { Paciente } from 'src/app/model/paciente';
import { AlergiasService } from 'src/app/service/alergias.service';
import { AntecedentesService } from 'src/app/service/antecedentes.service';
import { HistoriaClinicaService } from 'src/app/service/historia-clinica.service';
import { MedicamentosFrecuentesService } from 'src/app/service/medicamentos-frecuentes.service';
import { PacienteService } from 'src/app/service/paciente.service';

@Component({
  selector: 'app-create-historia-clinica',
  templateUrl: './create-historia-clinica.component.html',
  styleUrls: ['./create-historia-clinica.component.css']
})
export class CreateHistoriaClinicaComponent implements OnInit{

  antecedentes : Antecedentes[];
  alergias : Alergias[];
  medicamentosFrecuentes : MedicamentosFrecuentes[];

  antecedentesSeleccionados: Antecedentes[] = [];
  alergiasSeleccionadas: Alergias[] = [];
  medicamentosFrecuentesSeleccionados: MedicamentosFrecuentes[] = [];
  pacientes : Paciente [];

  paciente: Paciente= new Paciente();

  edad: number;

  historiaClinica : HistoriaClinica = new HistoriaClinica;


  constructor(
    private pacienteService : PacienteService,
    private antecedentesService :AntecedentesService,
    private alergiasService : AlergiasService,
    private medicamentosFrecuentesService : MedicamentosFrecuentesService,
    private historiaClinicaService : HistoriaClinicaService,
    private router : Router
  ){


    this.antecedentesService.getAllAntecedentes()
      .subscribe(antecedentes => {
        this.antecedentes = antecedentes;
      })

    this.alergiasService.getAllAlergias()
      .subscribe(alergias => {
        this.alergias = alergias;
      })

     this.medicamentosFrecuentesService.getAllMedicamentosFrecuentes()
      .subscribe(medicamentosFrecuentes => {
        this.medicamentosFrecuentes = medicamentosFrecuentes;
      })
  }

  ngOnInit(): void {
    this.pacienteService.getAllPacientes()
    .subscribe(pacientes => {
      this.pacientes = pacientes;
    })
  }

  actualizarAntecedentesSeleccionados(event: any, valor: Antecedentes) {
    if (event.target.checked) {
      this.antecedentesSeleccionados.push(valor);
    } else {
      const index = this.antecedentesSeleccionados.indexOf(valor);
      if (index > -1) {
        this.antecedentesSeleccionados.splice(index, 1);
      }
    }
  }

  actualizarAlergiasSeleccionados(event: any, valor: Alergias) {
    if (event.target.checked) {
      this.alergiasSeleccionadas.push(valor);
    } else {
      const index = this.alergiasSeleccionadas.indexOf(valor);
      if (index > -1) {
        this.alergiasSeleccionadas.splice(index, 1);
      }
    }
  }

  actualizarMedicamentosFrecuentesSeleccionados(event: any, valor: MedicamentosFrecuentes) {
    if (event.target.checked) {
      this.medicamentosFrecuentesSeleccionados.push(valor);
    } else {
      const index = this.medicamentosFrecuentesSeleccionados.indexOf(valor);
      if (index > -1) {
        this.medicamentosFrecuentesSeleccionados.splice(index, 1);
      }
    }
  }

  getPacienteById() {
    this.pacienteService.getPacienteById(this.paciente.id)
      .subscribe(paciente => {
        this.paciente = paciente;
        this.edad = this.calcularEdad(paciente.fechaNacimiento);
      })
  }

  calcularEdad(fechaNacimiento: Date): number {
    const hoy = new Date();
    const cumpleanos = new Date(fechaNacimiento);
    let edad = hoy.getFullYear() - cumpleanos.getFullYear();
    const mes = hoy.getMonth() - cumpleanos.getMonth();

    if (mes < 0 || (mes === 0 && hoy.getDate() < cumpleanos.getDate())) {
      edad--;
    }

    return edad;
  }

  registrarHistoriaClinica(){
    const creadoPor = localStorage.getItem('usuarioId');
    console.log(creadoPor);
    this.historiaClinica.creadoPor = creadoPor ? parseInt(creadoPor) : 1;
    this.historiaClinica.listaAlergias = this.alergiasSeleccionadas;
    this.historiaClinica.listaAntecedentes = this.alergiasSeleccionadas;
    this.historiaClinica.listaMedicamentosFrecuentes = this.medicamentosFrecuentesSeleccionados;

    this.historiaClinicaService.createHistoriaClinica(this.historiaClinica).subscribe(
      data => this.router.navigate(['/listaPaciente'])
    )


  }


}
