import { Routes } from '@angular/router';
import { AdmissionCreateTaskCreatorDialog } from './dialog/admission-create-task-creator.dialog';
import { AdmissionUpdateTaskCreatorDialog } from './dialog/admission-update-task-creator.dialog';
import { AdmissionDeleteTaskCreatorDialog } from './dialog/admission-delete-task-creator.dialog';
import { AdmissionDetailPage } from './admission-detail.page';
import { AdmissionCenterPage } from './admission-center.page';
import { StudentEnrollmentApplicationTaskDetailPage } from '../enrollment-applications/student-enrollment-application-task-detail.page';
import { StudentAdmissionCenterPage } from './student-admission-center.page';
import { StudentAdmissionDetailPage } from './student-admission-detail.page';
import { AdmissionSessionDetailPage } from "./admission-session-detail.page";

export const AdmissionRoutes: Routes = [
    { path: 'term/admissions', component: AdmissionCenterPage },
    { path: 'term/admissions/student-admission-center', component: StudentAdmissionCenterPage },
    { path: 'term/admissions/:id', component: AdmissionDetailPage },
    { path: 'term/admission-sessions/:id', component: AdmissionSessionDetailPage },
    { path: 'term/admissions/:id/student-admission-detail', component: StudentAdmissionDetailPage },
    { path: 'term/enrollment-applications/:referenceNo', component: StudentEnrollmentApplicationTaskDetailPage },
    { path: 'term/admissions-dialog', component: AdmissionCreateTaskCreatorDialog },
    { path: 'term/admissions-dialog', component: AdmissionUpdateTaskCreatorDialog },
    { path: 'term/admissions-dialog', component: AdmissionDeleteTaskCreatorDialog },
];
