import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class OfferingApplicationActions {
    
static ADD_OFFERING = '[OfferingApplication] Add OfferingApplication';

  addOffering(offering): Action {
    return {
      type: OfferingApplicationActions.ADD_OFFERING,
      payload: {offering:offering}
    };
  }

  static ADD_OFFERING_SUCCESS = '[OfferingApplication] Add OfferingApplication Success';

  addOfferingSuccess(message): Action {
    return {
      type: OfferingApplicationActions.ADD_OFFERING_SUCCESS,
      payload: message
    };
  }


}