import { Routes, RouterModule } from '@angular/router';
import { AdmissionCreateTaskCreatorDialog } from './dialog/admission-create-task-creator.dialog';
import { AdmissionUpdateTaskCreatorDialog } from './dialog/admission-update-task-creator.dialog';
import { AdmissionDetailPage } from "./admission-detail.page";
import { AdmissionCenterPage } from "./admission-center.page";

export const AdmissionRoutes: Routes = [
  { path: 'term/admissions', component: AdmissionCenterPage },
  // {path: 'term/admissions/:academicSessionCode', component: AdmissionDetailPage},
  { path: 'term/admissions/:id', component: AdmissionDetailPage },
  {path: 'term/admissions-dialog', component: AdmissionCreateTaskCreatorDialog},
  {path: 'term/admissions-dialog', component: AdmissionUpdateTaskCreatorDialog},
];
