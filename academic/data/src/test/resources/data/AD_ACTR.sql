-- student 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P001', 'STUDENT ONE', 'student1@umk.edu.my', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS) VALUES (currval('SQ_AD_ACTR'), 1);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student1@umk.edu.my';

-- student 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P002', 'STUDENT TWO', 'student2@umk.edu.my', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS) VALUES (currval('SQ_AD_ACTR'), 1);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student2@umk.edu.my';

-- lecturer 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01001A', 'lecturer ONE', 'lecturer1@umk.edu.my', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS) VALUES (currval('SQ_AD_ACTR'), 1);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'lecturer1@umk.edu.my';

-- lecturer 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01002A', 'lecturer TWO', 'lecturer2@umk.edu.my', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID) VALUES (currval('SQ_AD_ACTR'));

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'lecturer2@umk.edu.my';
