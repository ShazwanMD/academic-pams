INSERT INTO AD_SCTN (ID, SECTION_ID, STUDENT_ID, ADMISSION_ID, GRADE_CODE_ID, STANDING, STATUS, C_ID, C_TS, M_ST)
VALUES (nextval('SQ_AD_ENMT'),
        (SELECT ID
         FROM AD_SCTN
         WHERE CANONICAL_CODE = 'MGSEB-MBA-GST5023-201720181'),
        (SELECT ID
         FROM AD_ACTR
         WHERE IDENTITY_NO = 'A17P001'),
        (SELECT D.ID
         FROM AD_ADMN D inner join AD_ACTR A on A.ID = D.STUDENT_ID
         where A.IDENTITY = 'A17P001'),
         null,
        0,
        0,
        1,
        1, CURRENT_TIMESTAMP, 1
);
