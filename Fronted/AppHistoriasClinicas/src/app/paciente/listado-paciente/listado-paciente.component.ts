import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { Paciente } from 'src/app/model/paciente';
import { PacienteService } from 'src/app/service/paciente.service';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import { Router } from '@angular/router';
@Component({
  selector: 'app-listado-paciente',
  templateUrl: './listado-paciente.component.html',
  styleUrls: ['./listado-paciente.component.css']
})
export class ListadoPacienteComponent implements OnInit,AfterViewInit{

    displayedColumns = ["nombres","apellidoPaterno","apellidoMaterno", "tipoDocumento","numeroDocumento","editar"];
    dataSource = new MatTableDataSource<Paciente>();

    tipoDocumento: string = "-1";
    numeroDocumento: string = "";
    apellidoPaterno: string = "";
    apellidoMaterno : string = "";
    nombres :string = "";

    @ViewChild(MatPaginator, {static:true} ) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;

    constructor(
      private pacienteService :PacienteService,
      private router : Router
    ){
      this.buscar();
    }

    buscar(){
      this.pacienteService.getAllPacientesByFiltro(this.tipoDocumento,this.numeroDocumento,this.apellidoPaterno,this.apellidoMaterno,this.nombres)
        .subscribe(pacientes => {
          this.dataSource.data = pacientes;
        })
    }

    editarPaciente(id: number) {
      this.router.navigate(['/editarPaciente', id]);
    }

    ngOnInit(): void {
      this.dataSource.paginator = this.paginator;
    }

    ngAfterViewInit(): void {
      this.dataSource.sort = this.sort;
    }
}
