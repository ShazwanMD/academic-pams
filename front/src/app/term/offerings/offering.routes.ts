import {Routes, RouterModule} from '@angular/router';
import {OfferingCenterPage} from "./offering-center.page";
import {OfferingDetailPage} from "./offering-detail.page";
import {StudentOfferingDetailPage} from "./student-offering-detail.page";
import {GradebookDetailPage} from "./gradebook-detail.page";
import { StudentOfferingCenterPage } from "./student-offering-center.page";

export const OfferingRoutes: Routes = [
  {path: 'term/offerings', component: OfferingCenterPage},
  {path: 'term/offerings/student-offering-center', component: StudentOfferingCenterPage},
  {path: 'term/offerings/:canonicalCode', component: OfferingDetailPage},
  {path: 'term/offerings/:canonicalCode/student-offering-detail', component: StudentOfferingDetailPage},
  {path: 'term/offerings/:canonicalCode/gradebook-detail', component: GradebookDetailPage},
];
