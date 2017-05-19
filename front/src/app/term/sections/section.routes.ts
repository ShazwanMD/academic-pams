import {Routes, RouterModule} from '@angular/router';
import {SectionDetailPage} from "./section-detail.page";
import {SectionUpdateTaskCreatorDialog} from "./dialog/section-update-task-creator.dialog";

export const SectionRoutes: Routes = [
  {path: 'term/sections/:canonicalCode', component: SectionDetailPage},
  {path: 'term/sections-dialog', component: SectionUpdateTaskCreatorDialog},
];
