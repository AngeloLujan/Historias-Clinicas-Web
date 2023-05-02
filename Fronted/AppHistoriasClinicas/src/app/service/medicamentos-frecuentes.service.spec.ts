import { TestBed } from '@angular/core/testing';

import { MedicamentosFrecuentesService } from './medicamentos-frecuentes.service';

describe('MedicamentosFrecuentesService', () => {
  let service: MedicamentosFrecuentesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicamentosFrecuentesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
