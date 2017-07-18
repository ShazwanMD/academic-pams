import {Curriculum} from '../curriculums/curriculum.interface';
import {SubjectType} from '../subjects/subject-type.enum';
import {Faculty} from "../faculties/faculty.interface";
import {MetaObject} from "../../core/meta-object.interface";
export interface Subject extends MetaObject{
  id: null;
  subjectType: SubjectType;
  curriculum?:Curriculum;


  // transient

  selected: boolean;
}
