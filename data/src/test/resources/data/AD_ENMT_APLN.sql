INSERT INTO AD_ENMT_APLN (ID, AUDIT_NO, CANCEL_COMMENT, DESCRIPTION,
 AV_TS, AV_ID, CL_ID, CL_TS, CK_TS, CK_ID, DT_TS,DT_ID, EV_TS,EV_ID, PR_TS, PR_ID,
 PS_TS, PS_ID, RG_TS, RG_ID, RM_TS, RM_ID, RQ_TS, RQ_ID, SL_TS, SL_ID, FD_ST, UP_TS,
 UP_ID, UV_TS, UV_ID, VF_TS, VF_ID, C_TS, C_ID, D_TS, D_ID, M_TS, M_ID, M_ST,
 REFERENCE_NO, REMOVE_COMMENT, SOURCE_NO, APPLICATION_TYPE, ADMISSION_ID, SESSION_ID)
VALUES (nextval('SQ_AD_ENMT_APLN'), 'AUDIT_NO', 'CANCEL_COMMENT', 'DESCRIPTION',
CURRENT_TIMESTAMP, NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL,
CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL,
CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL,
CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, NULL, CURRENT_TIMESTAMP,
NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL,
CURRENT_TIMESTAMP, NULL, CURRENT_TIMESTAMP, NULL, '1', 'ENMT-201720181-001', 'REMOVE_COMMENT', 'SOURCE_NO', '0', '1', '31');

