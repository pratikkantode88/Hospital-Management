import { TestBed } from '@angular/core/testing';

import { AppintmentService } from './appointment.service';

describe('AppintmentService', () => {
  let service: AppintmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppintmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
