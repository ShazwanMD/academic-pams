import { Gradebook } from './gradebook.interface';
import { Enrollment } from './enrollment.interface';
export interface GradebookMatrix {
    enrollment: Enrollment[];
    gradebooks: Gradebook[];

    //transient
    selected: boolean;

}
