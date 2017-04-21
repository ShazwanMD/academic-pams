-- student 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P001', 'STUDENT ONE', 'student1@umk.edu.my', 097111771, 0123450000, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 1,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student1@umk.edu.my';

-- student 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P002', 'STUDENT TWO', 'student2@umk.edu.my', 097111772, 0123450001, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 2, 57,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student2@umk.edu.my';

-- student 3
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P003', 'STUDENT THREE', 'student3@umk.edu.my', 097111773, 0123450002, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);
                          
INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 0, 79,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student3@umk.edu.my';

-- student 4
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P004', 'STUDENT FOUR', 'student4@umk.edu.my', 097111774, 0123450003, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 3, 1,2);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student4@umk.edu.my';

-- student 5
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P005', 'STUDENT FIVE', 'student5@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 4, 1,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student5@umk.edu.my';


-- student 6
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P006', 'STUDENT SIX', 'student6@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 47,2);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student6@umk.edu.my';


-- student 7
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P007', 'STUDENT SEVEN', 'student7@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 2, 9,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student7@umk.edu.my';

-- student 8
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P008', 'STUDENT EIGHT', 'student8@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 33,2);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student8@umk.edu.my';

-- student 9
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0009F', 'STUDENT NINE', 'student9@umk.edu.my', 097111775, 0123450004, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student9@umk.edu.my';



-- lecturer 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01001A', 'lecturer MGSEB', 'lecturer1@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID, STAFF_TYPE,FACULTY_ID,PROGRAM_ID) VALUES (currval('SQ_AD_ACTR'), 0,10,79);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'lecturer1@umk.edu.my';

-- lecturer 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01002A', 'lecturer FKP', 'lecturer2@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID,PROGRAM_ID) VALUES (currval('SQ_AD_ACTR'), 0, 1, 71);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'lecturer2@umk.edu.my';

-- lecturer 3
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01003A', 'lecturer MGSEB', 'lecturer3@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID,PROGRAM_ID) VALUES (currval('SQ_AD_ACTR'), 0, 1,80);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'lecturer3@umk.edu.my';

-- admin staff 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01607B', 'MGSEB One', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 10);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'MGSEB One@umk.edu.my';


-- admin staff 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01608B', 'CPS One', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 1);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS One@umk.edu.my';

-- admin staff 3
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01609B', 'CPS 2', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 2);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS 2@umk.edu.my';

-- admin staff 4
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01610B', 'CPS 3', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1,3);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS 3@umk.edu.my';

-- admin staff 5
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01611B', 'CPS 4', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 4);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS 4@umk.edu.my';

-- admin staff 6
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01612B', 'CPS 5', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 5);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS 5@umk.edu.my';

-- admin staff 7
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01613B', 'CPS 6', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 6);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS 6@umk.edu.my';

-- admin staff 8
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01614B', 'CPS 7', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 7);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS 7@umk.edu.my';

-- admin staff 9
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01615B', 'CPS 8', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1,8);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS 8@umk.edu.my';

-- admin staff 10
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01616B', 'CPS 9', 'staffOne@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 9);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'CPS 9@umk.edu.my';