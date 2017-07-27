import { GradeCode } from '../common/grade-code.interface';
import { Section } from "./section.interface";
import { Enrollment } from "./enrollment.interface";
import { Assessment } from "./assessment.interface";
import { Admission } from "./admission.interface";
import { Student } from "../identity/student.interface";
import { Course } from "../planner/course.interface";
import { MetaObject } from "../../../core/meta-object.interface";

export interface Gradebook extends MetaObject {
  id: number;
  score: number;
  assessment: Assessment;
  section: Section;
  enrollment: Enrollment;


  // denormalize

  selected: boolean;

}
