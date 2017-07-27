import {StudyMode} from '../common/study-mode.interface';
import {AcademicSession} from '../planner/academic-session.interface';
export  interface  SwitchStudyMode {
  from: StudyMode;
  to: StudyMode;
  academicSession: AcademicSession;
}
