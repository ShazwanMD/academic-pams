import {Routes, RouterModule} from '@angular/router';
import {SectionCenterPage} from "./section-center.page";
import {SectionDetailPage} from "./section-detail.page";
//import {SectionEditorDialog} from "./dialog/section-editor.dialog";

// Route Configuration
export const SectionRoutes: Routes = [
  {path: 'term/sections', component: SectionCenterPage},
  {path: 'term/sections/:canonicalCode', component: SectionDetailPage},
 
  // {path: 'term/sections-dialog', component: SectionEditorDialog},
  // {path: 'term/offerings', dialog: OfferingEditorDialog},
  // {path: 'offerings-create', component: OfferingCreatePage},
  // {path: 'offerings-activate/:code', component: OfferingActivatePage},
  // {path: 'offerings-deactivate/:code', component: OfferingDeactivatePage},
  // {path: 'offerings-edit/:code', component: OfferingEditPage},
];
