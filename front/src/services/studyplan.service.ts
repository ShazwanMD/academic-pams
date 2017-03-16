import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { HttpInterceptorService } from '@covalent/http';

@Injectable()
export class StudyplanService {

  constructor(private _http: HttpInterceptorService) {
  }
}
