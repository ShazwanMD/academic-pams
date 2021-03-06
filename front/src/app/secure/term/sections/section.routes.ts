import {Routes} from '@angular/router';
import {SectionDetailPage} from './section-detail.page';
import {StudentSectionDetailPage} from './student-section-detail.page';
import {LecturerSectionDetailPage} from './lecturer-section-detail.page';
import { AdminLecturerSectionDetailPage } from "./admin-lecturer-section-detail.page";

export const SectionRoutes: Routes = [
  {path: 'term/sections/:canonicalCode', component: SectionDetailPage},
  {path: 'term/sections/:canonicalCode/student-section-detail', component: StudentSectionDetailPage},
  {path: 'term/sections/:canonicalCode/lecturer-section-detail', component: LecturerSectionDetailPage},
  {path: 'term/sections/:canonicalCode/admin-lecturer-section-detail', component: AdminLecturerSectionDetailPage},
  //{path: 'term/sections/:canonicalCode/admin-lecturer-section-enrollment-list', component: AdminLecturerSectionEnrollmentListPage},
  //admin-lecturer-section-enrollment-list.component.html
];
