import {Injectable} from '@angular/core';
import {Headers, RequestOptions, Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';
import {Program} from '../app/planner/programs/program.interface';
import {Faculty} from '../app/planner/faculties/faculty.interface';
import {Course} from '../app/planner/courses/course.interface';
import {Cohort} from '../app/planner/cohorts/cohort.interface';
import {Subject} from '../app/planner/subjects/subject.interface';
import {AcademicSession} from '../app/planner/academic-sessions/academic-session.interface';
import {AcademicYear} from '../app/planner/academic-years/academic-year.interface';
import {ProgramLevel} from '../app/planner/program-levels/program-level.interface';
import {Curriculum} from '../app/planner/curriculums/curriculum.interface';

@Injectable()
export class PlannerService {

  private planner_api: string = environment.endpoint + '/api/planner';

  constructor(private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // ACADEMIC YEAR
  // ====================================================================================================

  findAcademicYears(): Observable<AcademicYear[]> {
    return this._http.get(this.planner_api + '/academicYears')
      .map((res: Response) => <AcademicYear[]>res.json());
  }

  // ====================================================================================================
  // ACADEMIC SESSION
  // ====================================================================================================

  findAcademicSessions(): Observable<AcademicSession[]> {
    return this._http.get(this.planner_api + '/academicSessions')
      .map((res: Response) => <AcademicSession[]>res.json());
  }

  findAcademicSessionByCode(code: string): Observable<AcademicSession> {
    return this._http.get(this.planner_api + '/academicSessions/' + code)
      .map((res: Response) => <AcademicSession>res.json());
  }

  activateAcademicSession(academicSession: AcademicSession): Observable<String> {
    console.log('activate academic session');
    return this._http.get(this.planner_api + '/academicSessions/' + academicSession.code + '/activate')
      .map((res: Response) => <String>res.json());
  }

  deactivateAcademicSession(academicSession: AcademicSession): Observable<String> {
    console.log('deactivate academic session');
    return this._http.get(this.planner_api + '/academicSessions/' + academicSession.code + '/deactivate')
      .map((res: Response) => <String>res.json());
  }

  saveAcademicSession(academicSession: AcademicSession): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this._http.post(this.planner_api + '/academicSessions/' + academicSession.code + '/save', JSON.stringify(academicSession))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateAcademicSession(academicSession: AcademicSession): Observable<String> {
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token
    });
    let options = new RequestOptions({headers: headers});
    return this._http.put(this.planner_api + '/academicSessions/' + academicSession.code + '/update', JSON.stringify(academicSession))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // FACULTY
  // ====================================================================================================

  findFaculties(): Observable<Faculty[]> {
    console.log('findFaculties');
    return this._http.get(this.planner_api + '/faculties')
      .map(res => {
        return <Faculty[]>res.json();
      })
  }

  findFacultyByCode(code: string): Observable<Faculty> {
    console.log('findFacultyByCode');
    return this._http.get(this.planner_api + '/faculties/' + code)
      .map((res: Response) => <Faculty>res.json());
  }

  activateFaculty(faculty: Faculty): Observable<String> {
    console.log('activate Faculty');
    return this._http.get(this.planner_api + '/faculties/' + faculty.code + '/activate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateFaculty(faculty: Faculty): Observable<String> {
    console.log('deactivate Faculty');
    return this._http.get(this.planner_api + '/faculties/' + faculty.code + '/deactivate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  saveFaculty(faculty: Faculty): Observable<String> {
    return this._http.post(this.planner_api + '/faculties/' + faculty.code + '/save', JSON.stringify(faculty))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateFaculty(faculty: Faculty): Observable<String> {
    return this._http.put(this.planner_api + '/faculties/' + faculty.code, JSON.stringify(faculty))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // PROGRAM
  // ====================================================================================================

  findPrograms(): Observable<Program[]> {
    console.log('findPrograms');
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this._http.get(this.planner_api + '/programs')
      .map((res: Response) => <Program[]>res.json());
  }

  findProgramByCode(code: string): Observable<Program> {
    // let headers = new Headers({'Authorization': 'Bearer TODO'});
    // let options = new RequestOptions({headers: headers});
    return this._http.get(this.planner_api + '/programs/' + code)
      .map((res: Response) => <Program>res.json());
  }

  saveProgram(program: Program): Observable<String> {
    return this._http.post(this.planner_api + '/programs/' + program.code + '/save', JSON.stringify(program))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateProgram(program: Program): Observable<String> {
    return this._http.put(this.planner_api + '/programs/' + program.code, JSON.stringify(program))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeProgram(program: Program): Observable<Program> {
    return this._http.delete(this.planner_api + '/programs/' + program.code)
      .map((res: Response) => <Program>res.json());
  }

  activateProgram(program: Program): Observable<String> {
    console.log('activate program');
    return this._http.get(this.planner_api + '/programs/' + program.code + '/activate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateProgram(program: Program): Observable<String> {
    console.log('deactivate program');
    return this._http.get(this.planner_api + '/programs/' + program.code + '/deactivate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }


  // ====================================================================================================
  // COURSE
  // ====================================================================================================

  findCourses(): Observable<Course[]> {
    console.log('findCourses');
    return this._http.get(this.planner_api + '/courses')
      .map((res: Response) => <Course[]>res.json());
  }

  findCourseByCode(code: string): Observable<Course> {
    return this._http.get(this.planner_api + '/courses/' + code)
      .map((res: Response) => <Course>res.json());
  }

  saveCourse(course: Course): Observable<String> {
    console.log(course.code);
    let headers = new Headers({
      'Content-Type': 'application/json',
      //'Authorization': 'Bearer ' + this.authService.token

    });
    let options = new RequestOptions({headers: headers});
    return this._http.post(this.planner_api + '/course/' + course.code + '/save', JSON.stringify(course))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addCourse(course: Course): Observable<String> {
    return this._http.post(this.planner_api + '/courses/' + course.code + '/add', JSON.stringify(course))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateCourse(course: Course): Observable<String> {
    return this._http.put(this.planner_api + '/courses/' + course.code, JSON.stringify(course))
      .flatMap((res: Response) => Observable.of(res.text()));

  }

  removeCourse(course: Course): Observable<Course> {
    return this._http.delete(this.planner_api + '/course/' + course.code)
      .map((res: Response) => <Course>res.json());
  }

  activateCourse(course: Course): Observable<String> {
    console.log('activate course');
    return this._http.get(this.planner_api + '/courses/' + course.code + '/activate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateCourse(course: Course): Observable<String> {
    console.log('deactivate course');
    return this._http.get(this.planner_api + '/courses/' + course.code + '/deactivate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // COHORT
  // ====================================================================================================

  findCohorts(): Observable<Cohort[]> {
    console.log('findCohorts');
    return this._http.get(this.planner_api + '/cohorts')
      .map(res => <Cohort[]>res.json())
  }

  findCohortByCode(code: string): Observable<Cohort> {
    return this._http.get(this.planner_api + '/cohorts/' + code)
      .map((res: Response) => <Cohort>res.json());
  }

  saveCohort(cohort: Cohort): Observable<String> {
    return this._http.post(this.planner_api + '/cohorts/' + cohort.code + '/save', JSON.stringify(cohort))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateCohort(cohort: Cohort): Observable<String> {
    return this._http.put(this.planner_api + '/cohorts/' + cohort.code, JSON.stringify(cohort))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeCohort(cohort: Cohort): Observable<Cohort> {
    return this._http.delete(this.planner_api + '/cohorts/' + cohort.code)
      .map((res: Response) => <Cohort>res.json());
  }

  activateCohort(cohort: Cohort): Observable<String> {
    console.log('activate cohort');
    return this._http.get(this.planner_api + '/cohorts/' + cohort.code + '/activate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateCohort(cohort: Cohort): Observable<String> {
    console.log('deactivate cohort');
    return this._http.get(this.planner_api + '/cohorts/' + cohort.code + '/deactivate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // CURRICULUM
  // ====================================================================================================

  findCurriculums(): Observable<Curriculum[]> {
    console.log('findCurriculums');
    return this._http.get(this.planner_api + '/curriculums')
      .map(res => <Curriculum[]>res.json())
  }

  findCurriculumById(): Observable<Curriculum> {
    return this._http.get(this.planner_api + '/curriculums/')
      .map((res: Response) => <Curriculum>res.json());
  }

  findSubjectsByCurriculum(curriculum: Curriculum): Observable<Subject[]> {
    console.log('findEnrollmentsByOffering');
    return this._http.get(environment.endpoint + '/api/term/curriculums/' + curriculum.code + '/subjects')
      .map((res: Response) => <Subject[]>res.json());
  }

  saveCurriculum(curriculum: Curriculum): Observable<String> {
    console.log(curriculum.code);
    return this._http.post(this.planner_api + '/curriculums/' + curriculum.code + '/save', JSON.stringify(curriculum))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateCurriculum(curriculum: Curriculum): Observable<String> {
    return this._http.put(this.planner_api + '/curriculums/' + curriculum.code, JSON.stringify(curriculum))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeCurriculum(curriculum: Curriculum): Observable<Curriculum> {
    return this._http.delete(this.planner_api + '/curriculums/' + curriculum.code)
      .map((res: Response) => <Curriculum>res.json());
  }

  // todo: add single
  // todo: add bundle

  // ====================================================================================================
  // SUBJECT
  // ====================================================================================================

// findSubjects(): Observable<Subject[]> {
//     console.log("findSubjects");
//     return this._http.get(this.planner_api + '/subjects')
//       .map(res => <Subject[]>res.json())
//   }

//   findSubjectById(): Observable<Subject> {
//     return this._http.get(this.planner_api + '/subjects/' )
//       .map((res: Response) => <Subject>res.json());
//   }

//    addSubject(subject: Subject ): Observable<String> {
//     console. log (subject.id);
//     return this._http.post(this.planner_api + '/subjects/' + subject.id + '/add', JSON.stringify(subject))
//       .flatMap((res: Response) => Observable.of(res.text()));
//   }

//   updateSubject(subject: Subject): Observable<String> {
//     return this._http.put(this.planner_api + '/subjects/' + subject.id, JSON.stringify(subject))
//       .flatMap((res: Response) => Observable.of(res.text()));
//   }


//  activateSubject(subject: Subject): Observable<String> {
//     console.log("activate subject");
//     return this._http.get(this.planner_api + '/subjects/' + subject.id + '/activate')
//       .flatMap((res: Response) => Observable.of(res.text()));
//   }

//   deactivateSubject(subject: Subject): Observable<String> {
//     console.log("deactivate cohort");
//     return this._http.get(this.planner_api + '/subjects/' + subject.id + '/deactivate')
//       .flatMap((res: Response) => Observable.of(res.text()));
//   }


  // ====================================================================================================
  // PROGRAM LEVEL
  // ====================================================================================================

  findProgramLevels(): Observable<ProgramLevel[]> {
    return this._http.get(this.planner_api + '/programLevels')
      .map((res: Response) => <ProgramLevel[]>res.json());
  }

  findProgramLevelByCode(code: string): Observable<ProgramLevel> {
    return this._http.get(this.planner_api + '/programLevels/' + code)
      .map((res: Response) => <ProgramLevel>res.json());
  }

  activateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    console.log('activate program level');
    return this._http.get(this.planner_api + '/programLevels/' + programLevel.code + '/activate')
      .map((res: Response) => <String>res.json());
  }

  deactivateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    console.log('deactivate program level');
    return this._http.get(this.planner_api + '/programLevels/' + programLevel.code + '/deactivate')
      .map((res: Response) => <String>res.json());
  }

  saveProgramLevel(programLevel: ProgramLevel): Observable<String> {
    return this._http.post(this.planner_api + '/programLevels/', JSON.stringify(programLevel))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    return this._http.put(this.planner_api + '/programLevels/' + programLevel.code, JSON.stringify(programLevel))
      .flatMap((res: Response) => Observable.of(res.text()));
  }


}
