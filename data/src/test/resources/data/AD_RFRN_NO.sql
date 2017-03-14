INSERT INTO AD_RFRN_NO (ID, CODE, CURRENT_VALUE, DESCRIPTION, INCREMENT_VALUE, PREFIX, REFERENCE_FORMAT, SEQUENCE_FORMAT, M_ST, C_ID, C_TS )
VALUES (nextval('SQ_AD_RFRN_NO'), 'AdAdmissionApplication.referenceNo', 1, 'Admission Application Reference No Format', 1, 'ADMS', '{#academicSession.getCode()}/{#j}', '000', 1, 0, CURRENT_TIMESTAMP );

INSERT INTO AD_RFRN_NO (ID, CODE, CURRENT_VALUE, DESCRIPTION, INCREMENT_VALUE, PREFIX, REFERENCE_FORMAT, SEQUENCE_FORMAT, M_ST, C_ID, C_TS )
VALUES (nextval('SQ_AD_RFRN_NO'), 'AdEnrollmentApplication.referenceNo', 1, 'Enrollment Application Reference No Format', 1, 'ENRL', '{#academicSession.getCode()}/{#j}', '000', 1, 0, CURRENT_TIMESTAMP );
