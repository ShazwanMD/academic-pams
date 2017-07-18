import { GradeCode } from './../../common/grade-codes/grade-code.interface';
import { Section } from "../sections/section.interface";
import { Enrollment } from "../enrollments/enrollment.interface";
import { Assessment } from "../assessments/assessment.interface";
import { Admission } from "../admissions/admission.interface";
import { Student } from "../../identity/student.interface";
import { Course } from "../../planner/courses/course.interface";
import { MetaObject } from "../../core/meta-object.interface";

export interface Gradebook extends MetaObject {
  id: number;
  score: number;
  assessment: Assessment;
  section: Section;
  enrollment: Enrollment;
  
 
  // denormalize
  
  selected: boolean;
 
}
