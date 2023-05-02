import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import { HistoriaClinica } from 'src/app/model/historia-clinica';
import { HistoriaClinicaService } from 'src/app/service/historia-clinica.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listado-historia-clinica',
  templateUrl: './listado-historia-clinica.component.html',
  styleUrls: ['./listado-historia-clinica.component.css']
})
export class ListadoHistoriaClinicaComponent implements OnInit,AfterViewInit{

    displayedColumns = ["id","fechaRegistro","paciente", "tipoDocumento","numeroDocumento","editar"];
    dataSource = new MatTableDataSource<HistoriaClinica>();

    @ViewChild(MatPaginator, {static:true} ) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;

    constructor(
      private historiaClinicaService :HistoriaClinicaService,
      private router : Router
    ){
      this.historiaClinicaService.getAllHistoriaClinica()
        .subscribe(historiaClinica => {
          this.dataSource.data = historiaClinica;
        })
    }

    buscar(){

    }

    editarHistoriaClinica(id: number) {
      this.router.navigate(['/editarHistoriaClinica', id]);
    }

    ngOnInit(): void {
      this.dataSource.paginator = this.paginator;
    }

    ngAfterViewInit(): void {
      this.dataSource.sort = this.sort;
    }

}
