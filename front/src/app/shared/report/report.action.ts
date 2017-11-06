import {Injectable} from '@angular/core';
import {Action} from '@ngrx/store';

@Injectable()
export class ReportActions {
    
    static DOWNLOAD_REPORT = '[Report] Download Report';

    downloadReport(repParam) {
      console.log('repParam1 :'+repParam);
      return {
        type: ReportActions.DOWNLOAD_REPORT,
        payload: {repParam},
      };
    }

    static DOWNLOAD_REPORT_SUCCESS = '[Report] Download Report Success';

    downloadReportSucces(message) {
      console.log('downloadReportSucces');
      return {
        type: ReportActions.DOWNLOAD_REPORT_SUCCESS,
        payload: message,
      };
    }

    //-------------------------------------------------------------------
    // Download Financial Report
    //-------------------------------------------------------------------

    static DOWNLOAD_FINANCE_REPORT = '[Report] Download Finance Report';
    
        downloadReportFinance(repParam) {
          console.log('repParam1 :'+repParam);
          return {
            type: ReportActions.DOWNLOAD_FINANCE_REPORT,
            payload: {repParam},
          };
        }
    
        static DOWNLOAD_FINANCE_REPORT_SUCCESS = '[Report] Download Finance Report Success';
    
        downloadReportFinanceSucces(message) {
          console.log('downloadReportSucces');
          return {
            type: ReportActions.DOWNLOAD_FINANCE_REPORT_SUCCESS,
            payload: message,
          };
        }
}