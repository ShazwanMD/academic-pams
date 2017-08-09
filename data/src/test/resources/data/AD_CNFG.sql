INSERT INTO AD_CNFG (ID, CONFIG_KEY, CONFIG_VALUE, DESCRIPTION, C_ID, C_TS, M_ST)
    VALUES (nextval('SQ_AD_CNFG'), 'enrollment.startdate.open', '01/04/2017', 'Open Date Of Enrollment', 1, CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CNFG (ID, CONFIG_KEY, CONFIG_VALUE, DESCRIPTION, C_ID, C_TS, M_ST)
    VALUES (nextval('SQ_AD_CNFG'), 'enrollment.enddate.close', '10/04/2017', 'Close Date Of Enrollment', 1, CURRENT_TIMESTAMP, 1);
    
INSERT INTO AD_CNFG (ID, CONFIG_KEY, CONFIG_VALUE, DESCRIPTION, C_ID, C_TS, M_ST)
    VALUES (nextval('SQ_AD_CNFG'), 'application.url', 'http://pams.umk.edu.my', 'Application Url', 1, CURRENT_TIMESTAMP, 1);
