import { SetupActions } from "../../setup.action";
import { SetupModuleState } from "../../index";
import { Store } from "@ngrx/store";
import { BankCode } from "../../../../shared/model/common/bank-code.interface";
import { Observable } from "rxjs/Observable";
import { OnInit,Input, Component } from "@angular/core";
import {FormControl} from '@angular/forms';


@Component({
  selector: 'pams-bank-code-select',
  templateUrl: './bank-code-select.component.html',
})

export class BankCodeSelectComponent implements OnInit {

  private bankCodes$: Observable<BankCode[]>;
  private BANK_CODES: string[] = 'setupModuleState.bankCodes'.split('.');
  @Input() placeholder: string;
  @Input() innerFormControl: FormControl;

  constructor(private store: Store<SetupModuleState>,
              private actions: SetupActions) {
    this.bankCodes$ = this.store.select(...this.BANK_CODES);

  }

  ngOnInit() {
    this.store.dispatch(this.actions.findBankCodes());
  }

  selectChangeEvent(event: BankCode) {
    this.innerFormControl.setValue(event, {emitEvent: false});
  }
}
