INSERT INTO AD_ENMT (ID, C_TS, C_ID, M_ST, STANDING, STATUS, ADMISSION_ID, GRADE_CODE_ID, SECTION_ID) VALUES (nextval('SQ_AD_ENMT'), CURRENT_TIMESTAMP, 1,1, 0, 1,  (SELECT D.ID   FROM AD_ADMN D inner join AD_ACTR A on A.ID = D.STUDENT_ID
   where A.IDENTITY_NO = 'A17P001'), null,   (SELECT ID FROM AD_SCTN WHERE CANONICAL_CODE = 'MGSEB-MBA-GST5023-201720181-01'));
