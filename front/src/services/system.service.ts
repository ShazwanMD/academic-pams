import {Injectable} from '@angular/core';
import {HttpInterceptorService} from '@covalent/http';

@Injectable()
export class SystemService {

  constructor(private _http: HttpInterceptorService) {
  }
}
