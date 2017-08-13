import {Routes} from '@angular/router';

import {AcademicYearCenterPage} from './academic-year-center.page';
import {AcademicYearDetailPage} from './academic-year-detail.page';

export const AcademicYearRoutes: Routes = [
    { path: 'planner/academic-years', component: AcademicYearCenterPage },
    { path: 'planner/academic-years/:code', component: AcademicYearDetailPage },

];
