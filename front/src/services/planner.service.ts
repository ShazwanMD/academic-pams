import {BundleSubjectPart} from '../app/shared/model/planner/bundle-subject-part.interface';
import {Injectable} from '@angular/core';
import {Response} from '@angular/http';
import {HttpInterceptorService} from '@covalent/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';
import {Program} from '../app/shared/model/planner/program.interface';
import {Faculty} from '../app/shared/model/planner/faculty.interface';
import {Course} from '../app/shared/model/planner/course.interface';
import {Cohort} from '../app/shared/model/planner/cohort.interface';
import {Subject} from '../app/shared/model/planner/subject.interface';
import {SingleSubject} from '../app/shared/model/planner/single-subject.interface';
import {BundleSubject} from '../app/shared/model/planner/bundle-subject.interface';
import {AcademicSession} from '../app/shared/model/planner/academic-session.interface';
import {AcademicYear} from '../app/shared/model/planner/academic-year.interface';
import {ProgramLevel} from '../app/shared/model/planner/program-level.interface';
import {Curriculum} from '../app/shared/model/planner/curriculum.interface';

@Injectable()
export class PlannerService {

  private PLANNER_API: string = environment.endpoint + '/api/planner';

  constructor(private _http: HttpInterceptorService) {
  }

  // ====================================================================================================
  // ACADEMIC YEAR
  // ====================================================================================================

  findAcademicYears(): Observable<AcademicYear[]> {
    return this._http.get(this.PLANNER_API + '/academicYears')
      .map((res: Response) => <AcademicYear[]>res.json());
  }

  // ====================================================================================================
  // ACADEMIC SESSION
  // ====================================================================================================

  findAcademicSessions(): Observable<AcademicSession[]> {
    return this._http.get(this.PLANNER_API + '/academicSessions')
      .map((res: Response) => <AcademicSession[]>res.json());
  }

  findAcademicSessionByCode(code: string): Observable<AcademicSession> {
    return this._http.get(this.PLANNER_API + '/academicSessions/' + code)
      .map((res: Response) => <AcademicSession>res.json());
  }

  activateAcademicSession(academicSession: AcademicSession): Observable<String> {
    console.log('activate academic session');
    return this._http.get(this.PLANNER_API + '/academicSessions/' + academicSession.code + '/activate')
      .map((res: Response) => <String>res.json());
  }

  deactivateAcademicSession(academicSession: AcademicSession): Observable<String> {
    console.log('deactivate academic session');
    return this._http.get(this.PLANNER_API + '/academicSessions/' + academicSession.code + '/deactivate')
      .map((res: Response) => <String>res.json());
  }

  saveAcademicSession(academicSession: AcademicSession): Observable<String> {
    return this._http.post(this.PLANNER_API + '/academicSessions/' + academicSession.code + '/save', JSON.stringify(academicSession))
      .flatMap((res: Response) => Observable.of(res.text()))
      .catch((error) => this.handleError(error));
  }

  updateAcademicSession(academicSession: AcademicSession): Observable<String> {
    return this._http.put(this.PLANNER_API + '/academicSessions/' + academicSession.code + '/update', JSON.stringify(academicSession))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // FACULTY
  // ====================================================================================================

  findFaculties(): Observable<Faculty[]> {
    console.log('findFaculties');
    return this._http.get(this.PLANNER_API + '/faculties')
      .map((res) => {
        return <Faculty[]>res.json();
      });
  }

  findFacultyByCode(code: string): Observable<Faculty> {
    console.log('findFacultyByCode');
    return this._http.get(this.PLANNER_API + '/faculties/' + code)
      .map((res: Response) => <Faculty>res.json());
  }

  activateFaculty(faculty: Faculty): Observable<String> {
    console.log('activate Faculty');
    return this._http.get(this.PLANNER_API + '/faculties/' + faculty.code + '/activate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateFaculty(faculty: Faculty): Observable<String> {
    console.log('deactivate Faculty');
    return this._http.get(this.PLANNER_API + '/faculties/' + faculty.code + '/deactivate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  saveFaculty(faculty: Faculty): Observable<String> {
    return this._http.post(this.PLANNER_API + '/faculties/' + faculty.code + '/save', JSON.stringify(faculty))
      .flatMap((res: Response) => Observable.of(res.text()))
      .catch((error) => this.handleError(error));
  }

  updateFaculty(faculty: Faculty): Observable<String> {
    return this._http.put(this.PLANNER_API + '/faculties/' + faculty.code, JSON.stringify(faculty))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // PROGRAM
  // ====================================================================================================

  findPrograms(): Observable<Program[]> {
    console.log('findPrograms');
    return this._http.get(this.PLANNER_API + '/programs')
      .map((res: Response) => <Program[]>res.json());
  }

  findProgramByCode(code: string): Observable<Program> {
    return this._http.get(this.PLANNER_API + '/programs/' + code)
      .map((res: Response) => <Program>res.json());
  }

  saveProgram(program: Program): Observable<String> {
    return this._http.post(this.PLANNER_API + '/programs/' + program.code + '/save', JSON.stringify(program))
      .flatMap((res: Response) => Observable.of(res.text()));
      //.catch((error) => this.handleError(error));
  }

  updateProgram(program: Program): Observable<String> {
    return this._http.put(this.PLANNER_API + '/programs/' + program.code, JSON.stringify(program))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeProgram(program: Program): Observable<Program> {
    return this._http.delete(this.PLANNER_API + '/programs/' + program.code)
      .map((res: Response) => <Program>res.json());
  }

  activateProgram(program: Program): Observable<String> {
    console.log('activate program');
    return this._http.get(this.PLANNER_API + '/programs/' + program.code + '/activate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateProgram(program: Program): Observable<String> {
    console.log('deactivate program');
    return this._http.get(this.PLANNER_API + '/programs/' + program.code + '/deactivate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // COURSE
  // ====================================================================================================

  findCourses(): Observable<Course[]> {
    console.log('findCourses');
    return this._http.get(this.PLANNER_API + '/courses')
      .map((res: Response) => <Course[]>res.json());
  }

  findCourseByCode(code: string): Observable<Course> {
    return this._http.get(this.PLANNER_API + '/courses/' + code)
      .map((res: Response) => <Course>res.json());
  }

  saveCourse(course: Course): Observable<String> {
    console.log(course.code);
    return this._http.post(this.PLANNER_API + '/courses/' + course.code + '/save', JSON.stringify(course))
      .flatMap((res: Response) => Observable.of(res.text()))
      .catch((error) => this.handleError(error));
  }

  addCourse(course: Course): Observable<String> {
    return this._http.post(this.PLANNER_API + '/courses/' + course.code + '/add', JSON.stringify(course))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateCourse(course: Course): Observable<String> {
    return this._http.put(this.PLANNER_API + '/courses/' + course.code, JSON.stringify(course))
      .flatMap((res: Response) => Observable.of(res.text()));

  }

  removeCourse(course: Course): Observable<Course> {
    return this._http.delete(this.PLANNER_API + '/course/' + course.code)
      .map((res: Response) => <Course>res.json());
  }

  activateCourse(course: Course): Observable<String> {
    console.log('activate course');
    return this._http.get(this.PLANNER_API + '/courses/' + course.code + '/activate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateCourse(course: Course): Observable<String> {
    console.log('deactivate course');
    return this._http.get(this.PLANNER_API + '/courses/' + course.code + '/deactivate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // COHORT
  // ====================================================================================================

  findCohorts(): Observable<Cohort[]> {
    console.log('findCohorts');
    return this._http.get(this.PLANNER_API + '/cohorts')
      .map((res) => <Cohort[]>res.json());
  }

  findCohortByCode(code: string): Observable<Cohort> {
    return this._http.get(this.PLANNER_API + '/cohorts/' + code)
      .map((res: Response) => <Cohort>res.json());
  }

  saveCohort(cohort: Cohort): Observable<String> {
    return this._http.post(this.PLANNER_API + '/cohorts/' + cohort.code + '/save', JSON.stringify(cohort))
      .flatMap((res: Response) => Observable.of(res.text()))
      .catch((error) => this.handleError(error));
  }

  updateCohort(cohort: Cohort): Observable<String> {
    return this._http.put(this.PLANNER_API + '/cohorts/' + cohort.code, JSON.stringify(cohort))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeCohort(cohort: Cohort): Observable<Cohort> {
    return this._http.delete(this.PLANNER_API + '/cohorts/' + cohort.code)
      .map((res: Response) => <Cohort>res.json());
  }

  activateCohort(cohort: Cohort): Observable<String> {
    console.log('activate cohort');
    return this._http.get(this.PLANNER_API + '/cohorts/' + cohort.code + '/activate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  deactivateCohort(cohort: Cohort): Observable<String> {
    console.log('deactivate cohort');
    return this._http.get(this.PLANNER_API + '/cohorts/' + cohort.code + '/deactivate')
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // CURRICULUM
  // ====================================================================================================

  findCurriculums(): Observable<Curriculum[]> {
    console.log('findCurriculums');
    return this._http.get(this.PLANNER_API + '/curriculums')
      .map((res) => <Curriculum[]>res.json());
  }

  findCurriculumByCode(code: string): Observable<Curriculum> {
    return this._http.get(this.PLANNER_API + '/curriculums/' + code)
      .map((res: Response) => <Curriculum>res.json());
  }

  findSubjectsByCurriculum(curriculum: Curriculum): Observable<Subject[]> {
    console.log('findSubjectsByCurriculum');
    return this._http.get(this.PLANNER_API + '/curriculums/' + curriculum.code + '/subjects')
      .map((res: Response) => <Subject[]>res.json());
  }

  findSubjectsByCurriculumAndSubjectTypeCore(curriculum: Curriculum): Observable<Subject[]> {
    console.log('findSubjectsByCurriculumAndSubjectTypeCore');
    return this._http.get(this.PLANNER_API + '/curriculums/' + curriculum.code + '/subjects/subjectType/CORE')
      .map((res: Response) => <Subject[]>res.json());
  }

  findSubjectsByCurriculumAndSubjectTypeElective(curriculum: Curriculum): Observable<Subject[]> {
    console.log('findSubjectsByCurriculumAndSubjectTypeElective');
    return this._http.get(this.PLANNER_API + '/curriculums/' + curriculum.code + '/subjects/subjectType/ELECTIVE')
      .map((res: Response) => <Subject[]>res.json());
  }

  saveCurriculum(curriculum: Curriculum): Observable<String> {
    console.log(curriculum.code);
    return this._http.post(this.PLANNER_API + '/curriculums/' + curriculum.code + '/save', JSON.stringify(curriculum))
      .flatMap((res: Response) => Observable.of(res.text()))
      .catch((error) => this.handleError(error));
  }

  updateCurriculum(curriculum: Curriculum): Observable<String> {
    return this._http.put(this.PLANNER_API + '/curriculums/' + curriculum.code, JSON.stringify(curriculum))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  removeCurriculum(curriculum: Curriculum): Observable<Curriculum> {
    return this._http.delete(this.PLANNER_API + '/curriculums/' + curriculum.code)
      .map((res: Response) => <Curriculum>res.json());
  }

  // ====================================================================================================
  // SUBJECT
  // ====================================================================================================

  findSubjects(): Observable<Subject[]> {
    console.log('findSubjects');
    return this._http.get(this.PLANNER_API + '/subjects')
      .map((res) => <Subject[]>res.json());
  }

  addSingleSubject(curriculum: Curriculum, subject: SingleSubject): Observable<String> {
    console.log('curriculum:' + curriculum.code);
    return this._http.post(this.PLANNER_API + '/curriculums/' + curriculum.code + '/singleSubjects', JSON.stringify(subject))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  addBundleSubject(curriculum: Curriculum, subject: BundleSubject): Observable<String> {
    console.log('addSubject:' + subject);
    console.log('curriculum:' + curriculum.code);
    return this._http.post(this.PLANNER_API + '/curriculums/' + curriculum.code + '/bundleSubjects', JSON.stringify(subject))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

   addSubjectPart(curriculum: Curriculum, subject: BundleSubjectPart): Observable<String> {
    console.log('addSubjectPart:' + subject);
    console.log('curriculum:' + curriculum.code);
    return this._http.post(this.PLANNER_API + '/curriculums/' + curriculum.code + '/bundleSubjects', JSON.stringify(subject))
      .flatMap((res: Response) => Observable.of(res.text()));
  }


//   updateSubject(subject: Subject): Observable<String> {
//     return this._http.put(this.PLANNER_API + '/subjects/' + subject.id, JSON.stringify(subject))
//       .flatMap((res: Response) => Observable.of(res.text()));
//   }

  // findSubjectById(): Observable<Subject> {
  //   return this._http.get(this.PLANNER_API + '/subjects/' )
  //     .map((res: Response) => <Subject>res.json());
  // }

//  activateSubject(subject: Subject): Observable<String> {
//     console.log("activate subject");
//     return this._http.get(this.PLANNER_API + '/subjects/' + subject.id + '/activate')
//       .flatMap((res: Response) => Observable.of(res.text()));
//   }

  // deactivateSubject(subject: Subject): Observable<String> {
  //   console.log("deactivate cohort");
  //   return this._http.get(this.PLANNER_API + '/subjects/' + subject.id + '/deactivate')
  //     .flatMap((res: Response) => Observable.of(res.text()));
  // }

  // ====================================================================================================
  // PROGRAM LEVEL
  // ====================================================================================================

  findProgramLevels(): Observable<ProgramLevel[]> {
    return this._http.get(this.PLANNER_API + '/programLevels')
      .map((res: Response) => <ProgramLevel[]>res.json());
  }

  findProgramLevelByCode(code: string): Observable<ProgramLevel> {
    return this._http.get(this.PLANNER_API + '/programLevels/' + code)
      .map((res: Response) => <ProgramLevel>res.json());
  }

  activateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    console.log('activate program level');
    return this._http.get(this.PLANNER_API + '/programLevels/' + programLevel.code + '/activate')
      .map((res: Response) => <String>res.json());
  }

  deactivateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    console.log('deactivate program level');
    return this._http.get(this.PLANNER_API + '/programLevels/' + programLevel.code + '/deactivate')
      .map((res: Response) => <String>res.json());
  }

  saveProgramLevel(programLevel: ProgramLevel): Observable<String> {
    return this._http.post(this.PLANNER_API + '/programLevels/', JSON.stringify(programLevel))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  updateProgramLevel(programLevel: ProgramLevel): Observable<String> {
    return this._http.put(this.PLANNER_API + '/programLevels/' + programLevel.code, JSON.stringify(programLevel))
      .flatMap((res: Response) => Observable.of(res.text()));
  }

  // ====================================================================================================
  // PRIVATE METHODS
  // ====================================================================================================

  private handleError(error: Response | any) {
    let body: any = error.json();
    return Observable.throw(body);
  }

}
