import {Action} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';

import * as _ from 'lodash';
import {Gradebook} from "../gradebooks/gradebook.interface";
import {GradebookActions} from "../gradebooks/gradebook.action";
import {SectionActions} from "./section.action";

export type GradebookListState = Gradebook[];

const initialState: GradebookListState = <Gradebook[]>[];

export function gradebookListReducer(state = initialState, action: Action): GradebookListState {
  switch (action.type) {
    case SectionActions.FIND_GRADEBOOKS_BY_SECTION_SUCCESS: {
      return action.payload;
    }
    default: {
      return state;
    }
  }
}