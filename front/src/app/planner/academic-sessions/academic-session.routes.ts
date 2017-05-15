import {Routes, RouterModule} from '@angular/router';

import {AcademicSessionCenterPage}  from "./academic-session-center.page";
import {AcademicSessionDetailPage} from "./academic-session-detail.page";
import { AcademicSessionEditorDialog } from './dialog/academic-session-editor.dialog';


export const AcademicSessionRoutes: Routes = [
    {path: 'planner/academic-sessions', component: AcademicSessionCenterPage},
    {path: 'planner/academic-sessions/:code', component: AcademicSessionDetailPage},
    {path: 'planner/academic-sessions/dialog/academic-session-editor-dialog', component: AcademicSessionEditorDialog}
];