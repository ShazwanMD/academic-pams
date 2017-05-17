import { OfferingCreateTaskCreatorDialog } from './dialog/offering-create-task-creator.dialog';
import { OfferingUpdateTaskCreatorDialog } from './dialog/offering-update-task-creator.dialog';
import { OfferingDeleteTaskCreatorDialog } from './dialog/offering-delete-task-creator.dialog';
import {Routes, RouterModule} from '@angular/router';
import {OfferingCenterPage} from "./offering-center.page";
import {OfferingDetailPage} from "./offering-detail.page";
import {OfferingEditorDialog} from "./dialog/offering-editor.dialog";

// Route Configuration
export const OfferingRoutes: Routes = [
  {path: 'term/offerings', component: OfferingCenterPage},
  {path: 'term/offerings-dialog', component: OfferingEditorDialog},
   {path: 'term/offerings-dialog', component: OfferingCreateTaskCreatorDialog},
   {path: 'term/offerings-dialog', component: OfferingUpdateTaskCreatorDialog},
   {path: 'term/offerings-dialog', component: OfferingDeleteTaskCreatorDialog},
  
 
  {path: 'term/offerings/:canonicalCode', component: OfferingDetailPage},
   {path: 'term/offerings/:canonicalCode/sections', component: OfferingDetailPage},
 // {path: 'term/offerings', dialog: OfferingEditorDialog},
  // {path: 'offerings-create', component: OfferingCreatePage},
  // {path: 'offerings-activate/:code', component: OfferingActivatePage},
  // {path: 'offerings-deactivate/:code', component: OfferingDeactivatePage},
  // {path: 'offerings-edit/:code', component: OfferingEditPage},
];
