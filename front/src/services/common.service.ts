import { CountryCode } from './../app/common/country-codes/country-code.interface';
import { environment } from './../environments/environment';
import { GenderCode } from './../app/common/gender-codes/gender-code.interface';
import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";






@Injectable()
export class CommonService {


  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // GENDER CODES
  // ====================================================================================================

  findGenderCodes(): Observable<GenderCode[]> {
    console.log("findGenderCodes");
    return this.http.get(environment.endpoint + '/api/common/genderCodes')
      .map((res: Response) => <GenderCode[]>res.json());
  }

  findGenderCodeByCode(code: string): Observable<GenderCode> {
    console.log("findGenderCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/genderCodes/' + code)
      .map((res: Response) => <GenderCode>res.json());
  }
  
  

// ====================================================================================================
// COUNTRYCODE
// ====================================================================================================

findCountryCodes(): Observable<CountryCode[]> {
    console.log("findCountryCodes");
return this.http.get(environment.endpoint + '/api/common/countryCodes')
    .map((res: Response) => <CountryCode[]>res.json());
}

findCountryCodeByCode(code:string): Observable<CountryCode> {
    console.log("findCountryCodeByCode");
return this.http.get(environment.endpoint + '/api/common/countryCodes/' + code)
    .map((res: Response) => <CountryCode>res.json());
}


}