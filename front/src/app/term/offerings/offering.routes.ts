import { OfferingApplicationTaskCreatorDialog } from './dialog/offering-application-task-creator.dialog';
import {Routes, RouterModule} from '@angular/router';
import {OfferingCenterPage} from "./offering-center.page";
import {OfferingDetailPage} from "./offering-detail.page";
import {OfferingEditorDialog} from "./dialog/offering-editor.dialog";

// Route Configuration
export const OfferingRoutes: Routes = [
  {path: 'term/offerings', component: OfferingCenterPage},
  {path: 'term/offerings-dialog', component: OfferingEditorDialog},
   {path: 'term/offerings-dialog', component: OfferingApplicationTaskCreatorDialog},
  
 
  {path: 'term/offerings/:canonicalCode', component: OfferingDetailPage},
   {path: 'term/offerings/:canonicalCode/sections', component: OfferingDetailPage},
 // {path: 'term/offerings', dialog: OfferingEditorDialog},
  // {path: 'offerings-create', component: OfferingCreatePage},
  // {path: 'offerings-activate/:code', component: OfferingActivatePage},
  // {path: 'offerings-deactivate/:code', component: OfferingDeactivatePage},
  // {path: 'offerings-edit/:code', component: OfferingEditPage},
];
