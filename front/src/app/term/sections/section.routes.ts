import {Routes, RouterModule} from '@angular/router';
import {SectionDetailPage} from "./section-detail.page";

export const SectionRoutes: Routes = [
  {path: 'term/sections/:id', component: SectionDetailPage},
];
