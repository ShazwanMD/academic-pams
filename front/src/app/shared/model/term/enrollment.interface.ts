import { GradeCode } from '../common/grade-code.interface';
import { Section } from "./section.interface";
import { Admission } from "./admission.interface";
import { Student } from "../identity/student.interface";
import { EnrollmentStatus } from "./enrollment-status.enum";
import { EnrollmentStanding } from "./enrollment-standing.enum";
import { Course } from "../planner/course.interface";
import { MetaObject } from "../../../core/meta-object.interface";

export interface Enrollment extends MetaObject {
  status: number;
  student: Student;
  section: Section;
  admission: Admission;
  enrollmentStatus: EnrollmentStatus;
  enrollmentStanding: EnrollmentStanding;
  // denormalize
  course?: Course;
  selected: boolean;
  totalScore: number;
  gradeCode: GradeCode;
}
