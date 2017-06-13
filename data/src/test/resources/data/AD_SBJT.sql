-- single subject
-- FIAT-PHD-PBT-CRLM-0001

-- =====================================================================================================
-- SEMESTER 1
-- core semester 1 (GST5013) SINGLE
-- elective semester 1 (GST5033, GST5043) BUNDLE
-- =====================================================================================================
-- single
INSERT INTO AD_SBJT (ID, ORDINAL, SUBJECT_TYPE, CURRICULUM_ID, C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_SBJT'), 1, 0, (SELECT ID
                                      FROM AD_CRLM
                                      WHERE CODE = 'FIAT-PHD-PBT-CRLM-0001'), 1, current_timestamp, 1);
INSERT INTO AD_SNGL_SBJT (ID, COURSE_ID)
VALUES (CURRVAL('SQ_AD_SBJT'), (SELECT ID
                                FROM AD_CRSE
                                WHERE CODE = 'GST5013'));

-- bundle
INSERT INTO AD_SBJT (ID, ORDINAL, SUBJECT_TYPE, CURRICULUM_ID, C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_SBJT'), 1, 2, (SELECT ID
                                      FROM AD_CRLM
                                      WHERE CODE = 'FIAT-PHD-PBT-CRLM-0001'), 1, current_timestamp, 1);
INSERT INTO AD_BNDL_SBJT (ID)
VALUES (CURRVAL('SQ_AD_SBJT'));

INSERT INTO AD_BNDL_SBJT_PART (ID, BUNDLE_ID, COURSE_ID)
VALUES (NEXTVAL('SQ_AD_BNDL_SBJT_PART'),
        CURRVAL('SQ_AD_SBJT'),
        (SELECT ID
         FROM AD_CRSE
         WHERE CODE = 'GST5033'));

INSERT INTO AD_BNDL_SBJT_PART (ID, BUNDLE_ID, COURSE_ID)
VALUES (NEXTVAL('SQ_AD_BNDL_SBJT_PART'),
        CURRVAL('SQ_AD_SBJT'),
        (SELECT ID
         FROM AD_CRSE
         WHERE CODE = 'GST5043'));

-- =====================================================================================================
-- SEMESTER 2
-- core semester 2 (GST5023) SINGLE
-- elective semester 2 (GST5073, GST5083) BUNDLE
-- =====================================================================================================
-- core GST5023
INSERT INTO AD_SBJT (ID, ORDINAL, SUBJECT_TYPE, CURRICULUM_ID, C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_SBJT'), 2, 0, (SELECT ID
                                      FROM AD_CRLM
                                      WHERE CODE = 'FIAT-PHD-PBT-CRLM-0001'), 1, current_timestamp, 1);
INSERT INTO AD_SNGL_SBJT (ID, COURSE_ID)
VALUES (CURRVAL('SQ_AD_SBJT'), (SELECT ID
                                FROM AD_CRSE
                                WHERE CODE = 'GST5023'));

INSERT INTO AD_SBJT (ID, ORDINAL, SUBJECT_TYPE, CURRICULUM_ID, C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_SBJT'), 1, 2, (SELECT ID
                                      FROM AD_CRLM
                                      WHERE CODE = 'FIAT-PHD-PBT-CRLM-0001'), 1, current_timestamp, 1);
INSERT INTO AD_BNDL_SBJT (ID)
VALUES (CURRVAL('SQ_AD_SBJT'));

INSERT INTO AD_BNDL_SBJT_PART (ID, BUNDLE_ID, COURSE_ID)
VALUES (NEXTVAL('SQ_AD_BNDL_SBJT_PART'),
        CURRVAL('SQ_AD_SBJT'),
        (SELECT ID
         FROM AD_CRSE
         WHERE CODE = 'GST5073'));

INSERT INTO AD_BNDL_SBJT_PART (ID, BUNDLE_ID, COURSE_ID)
VALUES (NEXTVAL('SQ_AD_BNDL_SBJT_PART'),
        CURRVAL('SQ_AD_SBJT'),
        (SELECT ID
         FROM AD_CRSE
         WHERE CODE = 'GST5083'));




