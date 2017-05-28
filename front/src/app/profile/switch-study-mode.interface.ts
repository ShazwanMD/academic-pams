import {StudyMode} from "../common/study-modes/study-mode.interface";
import {AcademicSession} from "../planner/academic-sessions/academic-session.interface";
export  interface  SwitchStudyMode {
  from: StudyMode;
  to: StudyMode;
  academicSession: AcademicSession;
}
