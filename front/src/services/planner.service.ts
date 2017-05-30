import {Injectable} from '@angular/core';
import {Response, Http, RequestOptions, Headers} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {Program} from "../app/planner/programs/program.interface";
import {Faculty} from "../app/planner/faculties/faculty.interface";
import {Course} from "../app/planner/courses/course.interface";
import {Cohort} from "../app/planner/cohorts/cohort.interface";
import {AcademicSession} from '../app/planner/academic-sessions/academic-session.interface';
import {AcademicYear} from "../app/planner/academic-years/academic-year.interface";
import {ProgramLevel} from "../app/planner/program-levels/program-level.interface";

@Injectable()
export class PlannerService {

  constructor(private http: Http,
              private _http: HttpInterceptorService) {
  }
  // ====================================================================================================
  // ACADEMIC YEAR
  // ====================================================================================================

  findAcademicYears(): Observable<AcademicYear[]> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/academicYears')
      .map((res: Response) => <AcademicYear[]>res.json());
  }

  // ====================================================================================================
  // ACADEMIC SESSION
  // ====================================================================================================

  findAcademicSessions(): Observable<AcademicSession[]> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/academicSessions')
      .map((res: Response) => <AcademicSession[]>res.json());
  }

  findAcademicSessionByCode(code: string): Observable<AcademicSession> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/academicSessions/' + code, options)
      .map((res: Response) => <AcademicSession>res.json());
  }

  activateAcademicSession(academicSession: AcademicSession): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("activate academic session");
    return this.http.get(environment.endpoint + '/api/planner/academicSessions/' + academicSession.code + '/activate', options)
      .map((res: Response) => <String>res.json());
  }

  deactivateAcademicSession(academicSession: AcademicSession): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("deactivate academic session");
    return this.http.get(environment.endpoint + '/api/planner/academicSessions/' + academicSession.code + '/deactivate', options)
      .map((res: Response) => <String>res.json());
  }

  saveAcademicSession(academicSession: AcademicSession): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/planner/academicSessions/', JSON.stringify(academicSession), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAcademicSession(academicSession: AcademicSession): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/planner/academicSessions/' + academicSession.code, JSON.stringify(academicSession), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // FACULTY
  // ====================================================================================================

  findFaculties(): Observable<Faculty[]> {
    console.log("findFaculties");
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/faculties', options)
      .map(res => {
        return <Faculty[]>res.json();
      })
  }

  findFacultyByCode(code: string): Observable<Faculty> {
    console.log("findFacultyByCode");
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/faculties/' + code, options)
      .map((res: Response) => <Faculty>res.json());
  }

  activateFaculty(faculty: Faculty): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("activate Faculty");
    return this.http.get(environment.endpoint + '/api/planner/faculties/' + faculty.code + '/activate', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateFaculty(faculty: Faculty): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("deactivate Faculty");
    return this.http.get(environment.endpoint + '/api/planner/faculties/' + faculty.code + '/deactivate', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  saveFaculty(faculty: Faculty): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/planner/faculties/' + faculty.code + '/save', JSON.stringify(faculty), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateFaculty(faculty: Faculty): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/planner/faculties/' + faculty.code, JSON.stringify(faculty), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // PROGRAM
  // ====================================================================================================

  findPrograms(): Observable<Program[]> {
    console.log("findPrograms");
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/programs')
      .map((res: Response) => <Program[]>res.json());
  }

  findProgramByCode(code: string): Observable<Program> {
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/programs/' + code)
      .map((res: Response) => <Program>res.json());
  }

  saveProgram(program: Program): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/planner/programs/' + program.code + '/save', JSON.stringify(program), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateProgram(program: Program): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/planner/programs/' + program.code, JSON.stringify(program), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeProgram(program: Program): Observable<Program> {
    return this.http.delete(environment.endpoint + '/api/planner/programs/' + program.code)
      .map((res: Response) => <Program>res.json());
  }

  activateProgram(program: Program): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("activate program");
    return this.http.get(environment.endpoint + '/api/planner/programs/' + program.code + '/activate', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateProgram(program: Program): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("deactivate program");
    return this.http.get(environment.endpoint + '/api/planner/programs/' + program.code + '/deactivate', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // COURSE
  // ====================================================================================================

  findCourses(): Observable<Course[]> {
    console.log("findCourses");
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/courses', options)
      .map((res: Response) => <Course[]>res.json());
  }

  findCourseByCode(code: string): Observable<Course> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/courses/' + code, options)
      .map((res: Response) => <Course>res.json());
  }

  saveCourse(course: Course): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/planner/course/' + course.code + '/save', JSON.stringify(course), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateCourse(course: Course): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/planner/course/' + course.code, JSON.stringify(course), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeCourse(course: Course): Observable<Course> {
    return this.http.delete(environment.endpoint + '/api/planner/course/' + course.code)
      .map((res: Response) => <Course>res.json());
  }

  activateCourse(course: Course): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("activate course");
    return this.http.get(environment.endpoint + '/api/planner/course/' + course.code + '/activate', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateCourse(course: Course): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("deactivate course");
    return this.http.get(environment.endpoint + '/api/planner/course/' + course.code + '/deactivate', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // COHORT
  // ====================================================================================================

  findCohorts(): Observable<Cohort[]> {
    console.log("findCohorts");
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/cohorts', options)
      .map(res => <Cohort[]>res.json())
  }

  findCohortByCode(code: string): Observable<Cohort> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/cohorts/' + code, options)
      .map((res: Response) => <Cohort>res.json());
  }

  saveCohort(cohort: Cohort): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/planner/cohorts/' + cohort.code + '/save', JSON.stringify(cohort), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateCohort(cohort: Cohort): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/planner/cohorts/' + cohort.code, JSON.stringify(cohort), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeCohort(cohort: Cohort): Observable<Cohort> {
    return this.http.delete(environment.endpoint + '/api/planner/cohorts/' + cohort.code)
      .map((res: Response) => <Cohort>res.json());
  }

  activateCohort(cohort: Cohort): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("activate cohort");
    return this.http.get(environment.endpoint + '/api/planner/cohorts/' + cohort.code + '/activate', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateCohort(cohort: Cohort): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("deactivate cohort");
    return this.http.get(environment.endpoint + '/api/planner/cohorts/' + cohort.code + '/deactivate', options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // PROGRAM LEVEL
  // ====================================================================================================

  findProgramLevels(): Observable<ProgramLevel[]> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/programLevels')
      .map((res: Response) => <ProgramLevel[]>res.json());
  }

  findProgramLevelByCode(code: string): Observable<ProgramLevel> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    return this.http.get(environment.endpoint + '/api/planner/programLevels/' + code, options)
      .map((res: Response) => <ProgramLevel>res.json());
  }

  activateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("activate program level");
    return this.http.get(environment.endpoint + '/api/planner/programLevels/' + programLevel.code + '/activate', options)
      .map((res: Response) => <String>res.json());
  }

  deactivateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    let headers = new Headers({'Authorization': 'Bearer TODO'});
    let options = new RequestOptions({headers: headers});
    console.log("deactivate program level");
    return this.http.get(environment.endpoint + '/api/planner/programLevels/' + programLevel.code + '/deactivate', options)
      .map((res: Response) => <String>res.json());
  }

  saveProgramLevel(programLevel: ProgramLevel): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.post(environment.endpoint + '/api/planner/programLevels/', JSON.stringify(programLevel), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this.http.put(environment.endpoint + '/api/planner/programLevels/' + programLevel.code, JSON.stringify(programLevel), options)
      .flatMap((res: Response) => Observable.of(res.text()));
  }


}
