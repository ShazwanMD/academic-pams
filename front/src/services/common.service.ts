import { EthnicityCode } from './../app/common/ethnicity-codes/ethnicity-code.interface';
import { NationalityCode } from './../app/common/nationality-codes/nationality-code.interface';
import { ReligionCode } from './../app/common/religion-codes/religion-code.interface';
import { GradeCode } from './../app/common/grade-codes/grade-code.interface';
import { DunCode } from './../app/common/dun-codes/dun-code.interface';
import { ParliamentCode } from './../app/common/parliament-codes/parliament-code.interface';
import { RaceCode } from './../app/common/race-codes/race-code.interface';
import { StateCode } from './../app/common/state-codes/state-code.interface';
import { MaritalCode } from './../app/setup/marital-codes/marital-code.interface';
import { CountryCode } from './../app/common/country-codes/country-code.interface';
import { environment } from './../environments/environment';
import { GenderCode } from './../app/common/gender-codes/gender-code.interface';
import { Injectable } from '@angular/core';
import { Response, Http, Headers, RequestOptions } from '@angular/http';
import { HttpInterceptorService } from '@covalent/http';
import { Observable } from "rxjs";
import { BankCode } from "../app/common/bank-codes/bank-code.interface";

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

  saveGenderCode(code: GenderCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/common/genderCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGenderCode(code: GenderCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/common/genderCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeGenderCode(code: GenderCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.delete(environment.endpoint + '/api/common/genderCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
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
  saveMaritalCode(code: MaritalCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/common/maritalCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateMaritalCode(code: MaritalCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/common/maritalCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeMaritalCode(code: MaritalCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.delete(environment.endpoint + '/api/common/maritalCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
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

  saveStateCode(code: StateCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/common/stateCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStateCode(code: StateCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/common/stateCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeStateCode(code: StateCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.delete(environment.endpoint + '/api/common/stateCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // PARLIAMENTCODE
  // ====================================================================================================

  findParliamentCodes(): Observable<ParliamentCode[]> {
    console.log("findParliamentCodes()");
    return this.http.get(environment.endpoint + '/api/common/parliamentCodes')
      .map((res: Response) => <ParliamentCode[]>res.json());
  }

  findParliamentCodeByCode(code: string): Observable<ParliamentCode> {
    console.log("findParliamentCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/parliamentCodes/' + code)
      .map((res: Response) => <ParliamentCode>res.json());
  }



  // ====================================================================================================
  // DUNCODE
  // ====================================================================================================

  findDunCodes(): Observable<DunCode[]> {
    console.log("findDunCodes()");
    return this.http.get(environment.endpoint + '/api/common/dunCodes')
      .map((res: Response) => <DunCode[]>res.json());
  }

  findDunCodeByCode(code: string): Observable<DunCode> {
    console.log("findDunCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/dunCodes/' + code)
      .map((res: Response) => <DunCode>res.json());
  }




  // ====================================================================================================
  // GRADECODE
  // ====================================================================================================

  findGradeCodes(): Observable<GradeCode[]> {
    console.log("findGradeCodes()");
    return this.http.get(environment.endpoint + '/api/common/gradeCodes')
      .map((res: Response) => <GradeCode[]>res.json());
  }

  findGradeCodeByCode(code: string): Observable<GradeCode> {
    console.log("findGradeCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/gradeCodes/' + code)
      .map((res: Response) => <GradeCode>res.json());
  }

  saveGradeCode(code: GradeCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/common/gradeCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGradeCode(code: GradeCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/common/gradeCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeGradeCode(code: GradeCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.delete(environment.endpoint + '/api/common/gradeCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }



  // ====================================================================================================
  // RELIGIONCODE
  // ====================================================================================================

  findReligionCodes(): Observable<ReligionCode[]> {
    console.log("findReligionCodes()");
    return this.http.get(environment.endpoint + '/api/common/religionCodes')
      .map((res: Response) => <ReligionCode[]>res.json());
  }

  findReligionCodeByCode(code: string): Observable<ReligionCode> {
    console.log("findReligionCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/religionCodes/' + code)
      .map((res: Response) => <ReligionCode>res.json());
  }

  saveReligionCode(code: ReligionCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/common/religionCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateReligionCode(code: ReligionCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/common/religionCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeReligionCode(code: ReligionCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.delete(environment.endpoint + '/api/common/religionCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // NATIONALITYCODE
  // ====================================================================================================

  findNationalityCodes(): Observable<NationalityCode[]> {
    console.log("findNationalityCodes()");
    return this.http.get(environment.endpoint + '/api/common/nationalityCodes')
      .map((res: Response) => <NationalityCode[]>res.json());
  }

  findNationalityCodeByCode(code: string): Observable<NationalityCode> {
    console.log("findNationalityCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/nationalityCodes/' + code)
      .map((res: Response) => <NationalityCode>res.json());
  }

  saveNationalityCode(code: NationalityCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.post(environment.endpoint + '/api/common/nationalityCodes', JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateNationalityCode(code: NationalityCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.put(environment.endpoint + '/api/common/nationalityCodes/' + code.code, JSON.stringify(code), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeNationalityCode(code: NationalityCode) {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({ headers: headers });
    return this.http.delete(environment.endpoint + '/api/common/nationalityCodes/' + code.code, options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }



  // ====================================================================================================
  // ETHNICITYCODE
  // ====================================================================================================

  findEthnicityCodes(): Observable<EthnicityCode[]> {
    console.log("findEthnicityCodes()");
    return this.http.get(environment.endpoint + '/api/common/ethnicityCodes')
      .map((res: Response) => <EthnicityCode[]>res.json());
  }

  findEthnicityCodeByCode(code: string): Observable<EthnicityCode> {
    console.log("findEthnicityCodeByCode");
    return this.http.get(environment.endpoint + '/api/common/ethnicityCodes/' + code)
      .map((res: Response) => <EthnicityCode>res.json());
  }









}
