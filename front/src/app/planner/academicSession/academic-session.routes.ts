import {Routes, RouterModule} from '@angular/router';

import {AcademicSessionCenterPage}  from "./academic-session-center.page";
import {AcademicSessionDetailPage} from "./academic-session-detail.page";

export const AcademicSessionRoutes: Routes = [
    {path: 'planner/academicSession', component: AcademicSessionCenterPage},
    {path: 'planner/academicSession/:code', component: AcademicSessionDetailPage},
    
];