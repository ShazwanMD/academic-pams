-- student 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P001', 'STUDENT ONE', 'student1@umk.edu.my', 097111771, 0123450000, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 1, 1);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student1@umk.edu.my';

-- student 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P002', 'STUDENT TWO', 'student2@umk.edu.my', 097111772, 0123450001, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 2, 57);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student2@umk.edu.my';

-- student 3
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P003', 'STUDENT THREE', 'student3@umk.edu.my', 097111773, 0123450002, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);
                          
INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 0, 1);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student3@umk.edu.my';

-- student 4
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P004', 'STUDENT FOUR', 'student4@umk.edu.my', 097111774, 0123450003, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 3, 1);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student4@umk.edu.my';

-- student 5
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P005', 'STUDENT FIVE', 'student5@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 4, 1);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student5@umk.edu.my';


-- student 6
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P006', 'STUDENT SIX', 'student6@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 1, 47);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student6@umk.edu.my';


-- student 7
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P007', 'STUDENT SEVEN', 'student7@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 2, 9);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student7@umk.edu.my';

-- student 8
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P008', 'STUDENT EIGHT', 'student8@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 1, 33);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student8@umk.edu.my';

-- student 9
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P009', 'STUDENT NINE', 'student9@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student9@umk.edu.my';


-- lecturer 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01001A', 'lecturer ONE', 'lecturer1@umk.edu.my', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID, STAFF_TYPE) VALUES (currval('SQ_AD_ACTR'), 0);

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'lecturer1@umk.edu.my';

-- lecturer 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01002A', 'lecturer TWO', 'lecturer2@umk.edu.my', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE) VALUES (currval('SQ_AD_ACTR'), 0);


UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'lecturer2@umk.edu.my';
