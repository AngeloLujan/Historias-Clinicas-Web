import { Alergias } from "./alergias";
import { Antecedentes } from "./antecedentes";
import { MedicamentosFrecuentes } from "./medicamentos-frecuentes";

export class HistoriaClinica {
  creadoPor :  number;
  modificadoPor: number;
  listaAntecedentes : Antecedentes [];
  listaAlergias : Alergias [];
  listaMedicamentosFrecuentes : MedicamentosFrecuentes[];
}
