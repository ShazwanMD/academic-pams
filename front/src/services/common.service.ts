import {StudyCenter} from '../app/setup/study-centers/study-center.interface';
import {StudyMode} from '../app/common/study-modes/study-mode.interface';
import {EthnicityCode} from '../app/common/ethnicity-codes/ethnicity-code.interface';
import {NationalityCode} from '../app/common/nationality-codes/nationality-code.interface';
import {ReligionCode} from '../app/common/religion-codes/religion-code.interface';
import {GradeCode} from '../app/common/grade-codes/grade-code.interface';
import {DunCode} from '../app/common/dun-codes/dun-code.interface';
import {ParliamentCode} from '../app/common/parliament-codes/parliament-code.interface';
import {RaceCode} from '../app/common/race-codes/race-code.interface';
import {StateCode} from '../app/common/state-codes/state-code.interface';
import {MaritalCode} from '../app/setup/marital-codes/marital-code.interface';
import {CountryCode} from '../app/common/country-codes/country-code.interface';
import {environment} from '../environments/environment';
import {GenderCode} from '../app/common/gender-codes/gender-code.interface';
import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs';
import {BankCode} from '../app/common/bank-codes/bank-code.interface';

@Injectable()
export class CommonService {

  private COMMON_API: string = environment.endpoint + '/api/common';

  constructor(private _http: HttpInterceptorService) {
  }

// ====================================================================================================
// STUDY_CENTER
// ====================================================================================================

  findStudyCenters(): Observable<StudyCenter[]> {
    console.log('findStudyCenters()');
    return this._http.get(this.COMMON_API + '/studyCenters')
      .map((res: Response) => <StudyMode[]>res.json());
  }

  saveStudyCenter(code: StudyCenter) {
    return this._http.post(this.COMMON_API + '/studyCenters', JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudyCenter(code: StudyCenter) {
    return this._http.put(this.COMMON_API + '/studyCenters/' + code.code, JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeStudyCenter(code: StudyCenter) {
    return this._http.delete(this.COMMON_API + '/studyCenters/' + code.code)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


// ====================================================================================================
// STUDYMODE
// ====================================================================================================

  findStudyModes(): Observable<StudyMode[]> {
    console.log('findStudyModes()');
    return this._http.get(this.COMMON_API + '/studyModes')
      .map((res: Response) => <StudyMode[]>res.json());
  }

  findStudyModeByCode(code: string): Observable<StudyMode> {
    console.log('findStudyModeByCode');
    return this._http.get(this.COMMON_API + '/studyModes/' + code)
      .map((res: Response) => <StudyMode>res.json());
  }

  saveStudyMode(code: StudyMode) {
    return this._http.post(this.COMMON_API + '/studyModes', JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStudyMode(code: StudyMode) {
    return this._http.put(this.COMMON_API + '/studyModes/' + code.code, JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeStudyMode(code: StudyMode) {
    return this._http.delete(this.COMMON_API + '/studyModes/' + code.code)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // GENDER CODES
  // ====================================================================================================

  findGenderCodes(): Observable<GenderCode[]> {
    console.log('findGenderCodes');
    return this._http.get(this.COMMON_API + '/genderCodes')
      .map((res: Response) => <GenderCode[]>res.json());
  }

  findGenderCodeByCode(code: string): Observable<GenderCode> {
    console.log('findGenderCodeByCode');
    return this._http.get(this.COMMON_API + '/genderCodes/' + code)
      .map((res: Response) => <GenderCode>res.json());
  }

  saveGenderCode(code: GenderCode) {
    return this._http.post(this.COMMON_API + '/genderCodes', JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGenderCode(code: GenderCode) {
    return this._http.put(this.COMMON_API + '/genderCodes/' + code.code, JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeGenderCode(code: GenderCode) {
    return this._http.delete(this.COMMON_API + '/genderCodes/' + code.code)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // COUNTRYCODE
  // ====================================================================================================

  findCountryCodes(): Observable<CountryCode[]> {
    console.log('findCountryCodes()');
    return this._http.get(this.COMMON_API + '/countryCodes')
      .map((res: Response) => <CountryCode[]>res.json());
  }

  findCountryCodeByCode(code: string): Observable<CountryCode> {
    console.log('findCountryCodeByCode');
    return this._http.get(this.COMMON_API + '/countryCodes/' + code)
      .map((res: Response) => <CountryCode>res.json());
  }


  // ====================================================================================================
  // MARITALCODE
  // ====================================================================================================

  findMaritalCodes(): Observable<MaritalCode[]> {
    console.log('findMaritalCodes()');
    return this._http.get(this.COMMON_API + '/maritalCodes')
      .map((res: Response) => <MaritalCode[]>res.json());
  }

  findMaritalCodeByCode(code: string): Observable<MaritalCode> {
    console.log('findMaritalCodeByCode');
    return this._http.get(this.COMMON_API + '/maritalCodes/' + code)
      .map((res: Response) => <MaritalCode>res.json());
  }

  saveMaritalCode(code: MaritalCode) {
    return this._http.post(this.COMMON_API + '/maritalCodes', JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateMaritalCode(code: MaritalCode) {
    return this._http.put(this.COMMON_API + '/maritalCodes/' + code.code, JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeMaritalCode(code: MaritalCode) {
    return this._http.delete(this.COMMON_API + '/maritalCodes/' + code.code)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // BANKCODE
  // ====================================================================================================

  findBankCodes(): Observable<BankCode[]> {
    console.log('findBankCodes()');
    return this._http.get(this.COMMON_API + '/bankCodes')
      .map((res: Response) => <BankCode[]>res.json());
  }

  findBankCodeByCode(code: string): Observable<BankCode> {
    console.log('findBankCodeByCode');
    return this._http.get(this.COMMON_API + '/bankCodes/' + code)
      .map((res: Response) => <BankCode>res.json());
  }


  // ====================================================================================================
  // RACECODE
  // ====================================================================================================

  findRaceCodes(): Observable<RaceCode[]> {
    console.log('findRaceCodes()');
    return this._http.get(this.COMMON_API + '/raceCodes')
      .map((res: Response) => <RaceCode[]>res.json());
  }

  findRaceCodeByCode(code: string): Observable<RaceCode> {
    console.log('findRaceCodeByCode');
    return this._http.get(this.COMMON_API + '/raceCodes/' + code)
      .map((res: Response) => <RaceCode>res.json());
  }


  // ====================================================================================================
  // STATECODE
  // ====================================================================================================

  findStateCodes(): Observable<StateCode[]> {
    console.log('findStateCodes()');
    return this._http.get(this.COMMON_API + '/stateCodes')
      .map((res: Response) => <StateCode[]>res.json());
  }

  findStateCodeByCode(code: string): Observable<StateCode> {
    console.log('findStateCodeByCode');
    return this._http.get(this.COMMON_API + '/stateCodes/' + code)
      .map((res: Response) => <StateCode>res.json());
  }

  saveStateCode(code: StateCode) {
    return this._http.post(this.COMMON_API + '/stateCodes', JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateStateCode(code: StateCode) {
    return this._http.put(this.COMMON_API + '/stateCodes/' + code.code, JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeStateCode(code: StateCode) {
    return this._http.delete(this.COMMON_API + '/stateCodes/' + code.code)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // PARLIAMENTCODE
  // ====================================================================================================

  findParliamentCodes(): Observable<ParliamentCode[]> {
    console.log('findParliamentCodes()');
    return this._http.get(this.COMMON_API + '/parliamentCodes')
      .map((res: Response) => <ParliamentCode[]>res.json());
  }

  findParliamentCodeByCode(code: string): Observable<ParliamentCode> {
    console.log('findParliamentCodeByCode');
    return this._http.get(this.COMMON_API + '/parliamentCodes/' + code)
      .map((res: Response) => <ParliamentCode>res.json());
  }


  // ====================================================================================================
  // DUNCODE
  // ====================================================================================================

  findDunCodes(): Observable<DunCode[]> {
    console.log('findDunCodes()');
    return this._http.get(this.COMMON_API + '/dunCodes')
      .map((res: Response) => <DunCode[]>res.json());
  }

  findDunCodeByCode(code: string): Observable<DunCode> {
    console.log('findDunCodeByCode');
    return this._http.get(this.COMMON_API + '/dunCodes/' + code)
      .map((res: Response) => <DunCode>res.json());
  }


  // ====================================================================================================
  // GRADECODE
  // ====================================================================================================

  findGradeCodes(): Observable<GradeCode[]> {
    console.log('findGradeCodes()');
    return this._http.get(this.COMMON_API + '/gradeCodes')
      .map((res: Response) => <GradeCode[]>res.json());
  }

  findGradeCodeByCode(code: string): Observable<GradeCode> {
    console.log('findGradeCodeByCode');
    return this._http.get(this.COMMON_API + '/gradeCodes/' + code)
      .map((res: Response) => <GradeCode>res.json());
  }

  saveGradeCode(code: GradeCode) {
    return this._http.post(this.COMMON_API + '/gradeCodes', JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateGradeCode(code: GradeCode) {
    return this._http.put(this.COMMON_API + '/gradeCodes/' + code.code, JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeGradeCode(code: GradeCode) {
    return this._http.delete(this.COMMON_API + '/gradeCodes/' + code.code)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // RELIGIONCODE
  // ====================================================================================================

  findReligionCodes(): Observable<ReligionCode[]> {
    console.log('findReligionCodes()');
    return this._http.get(this.COMMON_API + '/religionCodes')
      .map((res: Response) => <ReligionCode[]>res.json());
  }

  findReligionCodeByCode(code: string): Observable<ReligionCode> {
    console.log('findReligionCodeByCode');
    return this._http.get(this.COMMON_API + '/religionCodes/' + code)
      .map((res: Response) => <ReligionCode>res.json());
  }

  saveReligionCode(code: ReligionCode) {
    return this._http.post(this.COMMON_API + '/religionCodes', JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateReligionCode(code: ReligionCode) {
    return this._http.put(this.COMMON_API + '/religionCodes/' + code.code, JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeReligionCode(code: ReligionCode) {
    return this._http.delete(this.COMMON_API + '/religionCodes/' + code.code)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // NATIONALITYCODE
  // ====================================================================================================

  findNationalityCodes(): Observable<NationalityCode[]> {
    console.log('findNationalityCodes()');
    return this._http.get(this.COMMON_API + '/nationalityCodes')
      .map((res: Response) => <NationalityCode[]>res.json());
  }

  findNationalityCodeByCode(code: string): Observable<NationalityCode> {
    console.log('findNationalityCodeByCode');
    return this._http.get(this.COMMON_API + '/nationalityCodes/' + code)
      .map((res: Response) => <NationalityCode>res.json());
  }

  saveNationalityCode(code: NationalityCode) {
    return this._http.post(this.COMMON_API + '/nationalityCodes', JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateNationalityCode(code: NationalityCode) {
    return this._http.put(this.COMMON_API + '/nationalityCodes/' + code.code, JSON.stringify(code))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeNationalityCode(code: NationalityCode) {
    return this._http.delete(this.COMMON_API + '/nationalityCodes/' + code.code)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // ETHNICITYCODE
  // ====================================================================================================

  findEthnicityCodes(): Observable<EthnicityCode[]> {
    console.log('findEthnicityCodes()');
    return this._http.get(this.COMMON_API + '/ethnicityCodes')
      .map((res: Response) => <EthnicityCode[]>res.json());
  }

  findEthnicityCodeByCode(code: string): Observable<EthnicityCode> {
    console.log('findEthnicityCodeByCode');
    return this._http.get(this.COMMON_API + '/ethnicityCodes/' + code)
      .map((res: Response) => <EthnicityCode>res.json());
  }


  // ====================================================================================================
  // PRIVATE METHODS
  // ====================================================================================================

  private handleError(error: Response | any) {
    let body: any = error.json();
    return Observable.throw(body);
  }

}
