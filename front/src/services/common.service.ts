import { ParliamentCode } from './../app/common/parliament-codes/parliament-code.interface';
import {RaceCode} from './../app/common/race-codes/race-code.interface';
import {StateCode} from './../app/common/state-codes/state-code.interface';
import {MaritalCode} from './../app/setup/marital-codes/marital-code.interface';
import {CountryCode} from './../app/common/country-codes/country-code.interface';
import {environment} from './../environments/environment';
import {GenderCode} from './../app/common/gender-codes/gender-code.interface';
import {Injectable} from '@angular/core';
import {Response, Http, Headers, RequestOptions} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {BankCode} from "../app/common/bank-codes/bank-code.interface";



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
    console.log("findCountryCodes()");
    return this.http.get(environment.endpoint + '/api/common/countryCodes')
      .map((res: Response) => <CountryCode[]>res.json());
  }

  findCountryCodeByCode(code: string): Observable<CountryCode> {
    console.log("findCountryCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/countryCodes/' + code)
      .map((res: Response) => <CountryCode>res.json());
  }


// ====================================================================================================
// MARITALCODE
// ====================================================================================================

  findMaritalCodes(): Observable<MaritalCode[]> {
    console.log("findMaritalCodes()");
    return this.http.get(environment.endpoint + '/api/common/maritalCodes')
      .map((res: Response) => <MaritalCode[]>res.json());
  }

  findMaritalCodeByCode(code: string): Observable<MaritalCode> {
    console.log("findMaritalCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/maritalCodes/' + code)
      .map((res: Response) => <MaritalCode>res.json());
  }


// ====================================================================================================
// BANKCODE
// ====================================================================================================

  findBankCodes(): Observable<BankCode[]> {
    console.log("findBankCodes()");
    return this.http.get(environment.endpoint + '/api/common/bankCodes')
      .map((res: Response) => <BankCode[]>res.json());
  }

  findBankCodeByCode(code: string): Observable<BankCode> {
    console.log("findBankCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/bankCodes/' + code)
      .map((res: Response) => <BankCode>res.json());
  }


// ====================================================================================================
// RACECODE
// ====================================================================================================

  findRaceCodes(): Observable<RaceCode[]> {
    console.log("findRaceCodes()");
    return this.http.get(environment.endpoint + '/api/common/raceCodes')
      .map((res: Response) => <RaceCode[]>res.json());
  }

  findRaceCodeByCode(code: string): Observable<RaceCode> {
    console.log("findRaceCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/raceCodes/' + code)
      .map((res: Response) => <RaceCode>res.json());
  }


// ====================================================================================================
// STATECODE
// ====================================================================================================

  findStateCodes(): Observable<StateCode[]> {
    console.log("findStateCodes()");
    return this.http.get(environment.endpoint + '/api/common/stateCodes')
      .map((res: Response) => <StateCode[]>res.json());
  }

  findStateCodeByCode(code: string): Observable<StateCode> {
    console.log("findStateCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/stateCodes/' + code)
      .map((res: Response) => <StateCode>res.json());
  }

  
// ====================================================================================================
// PARLIAMENTCODE
// ====================================================================================================

findParliamentCodes(): Observable<ParliamentCode[]> {
    console.log("findParliamentCodes()");
return this.http.get(environment.endpoint + '/api/common/parliamentCodes')
    .map((res: Response) => <ParliamentCode[]>res.json());
}

findParliamentCodeByCode(code:string): Observable<ParliamentCode> {
    console.log("findParliamentCodeByCode");
return this.http.get(environment.endpoint + '/api/common/parliamentCodes/' + code)
    .map((res: Response) => <ParliamentCode>res.json());
}




}
