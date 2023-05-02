import { Alergias } from "./alergias";
import { Antecedentes } from "./antecedentes";
import { MedicamentosFrecuentes } from "./medicamentos-frecuentes";

export class HistoriaClinica {
  id : number;
  fechaRegistro : Date;
  fechaModificacion : Date;
  usuarioCreador : string;
  creadoPor :  number;
  usuarioModificador : string;
  modificadoPor: number;
  paciente : string;
  pacienteId : number;
  tipoDocumento : string;
  numeroDocumento :string;
  listaAntecedentes : Antecedentes [];
  listaAlergias : Alergias [];
  listaMedicamentosFrecuentes : MedicamentosFrecuentes[];
}

export class HistoriaClinicaAlergias {
  id : number;
  historiaClinicaId :  number;
  alergiaId: number;
}

export class HistoriaClinicaAntecedentes {
  id : number;
  historiaClinicaId :  number;
  antecedenteId: number;
}

export class HistoriaClinicaMedicamentosFrecuentes {
  id : number;
  historiaClinicaId :  number;
  medicamentoFrecuenteId: number;
}
