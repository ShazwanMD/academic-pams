import {Curriculum} from '../curriculums/curriculum.interface';
import {Faculty} from "../faculties/faculty.interface";
import {MetaObject} from "../../core/meta-object.interface";
export interface Subject extends MetaObject{
  id: null;
//   subjectType: SubjectType;
  curriculum?:Curriculum;
}
