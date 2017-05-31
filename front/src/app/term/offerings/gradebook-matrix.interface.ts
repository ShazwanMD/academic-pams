import {Gradebook} from "./gradebook.interface";
import {Enrollment} from "../enrollments/enrollment.interface";
export interface GradebookMatrix {
  enrollment: Enrollment;
  gradebooks: Gradebook[];
}
