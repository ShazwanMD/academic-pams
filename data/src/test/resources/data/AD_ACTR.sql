-- student 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P001', 'MUHAMMAD AMMAR FAIZ BIN AZMAN', 'ammar@umk.edu.my', '097111771', '0123450000', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 1,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'ammar@umk.edu.my';

-- student 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P002', 'MUHAMMAD NAZIR BIN HAZZAN', 'nazir.h@umk.edu.my', '097111772', '0123450001', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 2, 1,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'nazir.h@umk.edu.my';

-- student 3
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P003', 'NUR NASIBAH BINTI KAMIL', 'nasibahk@umk.edu.my', '097111773', '0123450002', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);
                          
INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 0, 79,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'nasibahk@umk.edu.my';

-- student 4
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P004', 'FATIMAH AZZAHERA BINTI SABRIY', 'fatimahzahera@umk.edu.my', '097111774', '0123450003', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 3, 1,2);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'fatimahzahera@umk.edu.my';

-- student 5
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P005', 'AZZAH BINTI YOUSOF', 'azzahyousof@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 4, 1,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'azzahyousof@umk.edu.my';


-- student 6
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P006', 'AMINAH BINTI WAHAB', 'aminahwahab@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 47,2);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'aminahwahab@umk.edu.my';


-- student 7
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P007', 'DAMIYA MAISARAH BINTI ZAINI', 'damiazaini@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 2, 9,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'damiazaini@umk.edu.my';

-- student 8
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17P008', 'NUR ASYIKIN BINTI JAMMAL', 'asyikinjamal@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 33,2);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'asyikinjamal@umk.edu.my';

-- student 9
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0009F', 'ADHAM BIN AKMAL', 'adhamakmal@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'adhamakmal@umk.edu.my';

-- lecturer 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01001A', 'Prof. Madya Dr. Noraani Binti Mustapha', 'noraani@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID, STAFF_TYPE,FACULTY_ID,PROGRAM_ID) VALUES (currval('SQ_AD_ACTR'), 0,10,79);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'noraani@umk.edu.my';

-- lecturer 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01002A', 'Prof. Madya Dr. Wee Yu Ghee', 'yughee@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID,PROGRAM_ID) VALUES (currval('SQ_AD_ACTR'), 0, 1, 71);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'yughee@umk.edu.my';

-- lecturer 3
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01003A', 'Encik Ahmed Hamdy Elbadawy Ahmed Mahmoud', 'ahmed.h@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID,PROGRAM_ID) VALUES (currval('SQ_AD_ACTR'), 0, 1,80);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'ahmed.h@umk.edu.my';

-- admin staff 1
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01607B', 'Dr. Muhamad Saufi Bin Che Rusuli', 'msaufi@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 10);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'msaufi@umk.edu.my';


-- admin staff 2
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01608B', 'Prof. Dr. Balakrishnan A/L Parasuraman', 'balakrishnan@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 1);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'balakrishnan@umk.edu.my';

-- admin staff 3
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01609B', 'Prof. Dr. Hishamuddin Bin Md Som', 'hishamuddin.ms@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 2);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'hishamuddin.ms@umk.edu.my';

-- admin staff 4
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01610B', 'Prof. Dr. Nik Maheran Binti Nik Muhammad', 'nikmaheran@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1,3);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'nikmaheran@umk.edu.my';

-- admin staff 5
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01611B', 'Prof. Dr. Raja Suzana Binti Raja Kasim', 'rajasuzana@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 4);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'rajasuzana@umk.edu.my';

-- admin staff 6
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01612B', 'Prof. Dr. Razli Bin Che Razak', 'razlicr@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 5);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'razlicr@umk.edu.my';

-- admin staff 7
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01613B', 'Prof. Dr. Sazali Bin Abd. Wahab', 'sazali@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 6);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'sazali@umk.edu.my';

-- admin staff 8
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01614B', 'Prof. Madya Dr. Mohd Rafi Bin Yaacob', 'rafi@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 7);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'rafi@umk.edu.my';

-- admin staff 9
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01615B', 'Prof. Madya Dr. Abu Sofian Bin Yaacob', 'abusofian@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1,8);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'abusofian@umk.edu.my';

-- admin staff 10
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '01616B', 'Prof. Madya Dr. Mohammad Bin Ismail', 'mohammad.i@umk.edu.my', NULL, NULL, NULL, 0,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STAF (ID,STAFF_TYPE,FACULTY_ID) VALUES (currval('SQ_AD_ACTR'), 1, 9);


UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'mohammad.i@umk.edu.my';

-- student 10
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0010F', 'SITI SAMIYA BINTI RUSLI', 'siti.samiya@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 1,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'siti.samiya@umk.edu.my';

-- student 11
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0011F', 'AISHAHWARYA BINTI MUSA', 'aishahwarya@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 1,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'aishahwarya@umk.edu.my';

-- student 12
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0012F', 'ZAEMAN BIN WASSIM', 'zaemanwassim@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 1,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'zaemanwassim@umk.edu.my';

-- student 13
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0013F', 'NIK MUHAMMAD ASYRAF BIN AZALAM', 'asrafazalam@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'asrafazalam@umk.edu.my';

-- student 14
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0014F', 'NIK MUHAMMAD ADHAM BIN MUHAMMAD RESLI', 'adhamresli@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'adhamresli@umk.edu.my';

-- student 15
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0015F', 'ADAN BIN ABU', 'adamabu@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'adamabu@umk.edu.my';

-- student 16
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0016F', 'MOHAMED DANISH BIN ABDULLAH', 'danish.a@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'danish.a@umk.edu.my';

-- student 17
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0017F', 'MUHAMMAD HANIF BIN AHMAD', 'hanifahmad@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'hanifahmad@umk.edu.my';

-- student 18
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0018F', 'KAMARUDDIN BIN JAMIL', 'kamajamil@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'kamajamil@umk.edu.my';

-- student 19
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0019F', 'NORAINI BINTI ISMAIL', 'norainiismail@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'norainiismail@umk.edu.my';

-- student 20
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0020F', 'SAIFULLAH BIN MUHAZZIN', 'saifullah.m@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'saifullah.m@umk.edu.my';

-- student 21
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0021F', 'FATIMAWATI BINTI NORAINI', 'fatima.n@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'fatima.n@umk.edu.my';

-- student 22
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0022F', 'FAIZAN BIN THAHIR', 'faizanthahir@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'faizanthahir@umk.edu.my';

-- student 23
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0023F', 'HASSAN BIN HUSSIN', 'hassan.h@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'hassan.h@umk.edu.my';

-- student 24
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0024F', 'RAJESWARAN A/L MUTHU', 'rajeswaran.m@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'rajeswaran.m@umk.edu.my';

-- student 25
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0025F', 'MUHAMAH YUSOF BIN ZAKARIA', 'yusofzakaria@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'yusofzakaria@umk.edu.my';

-- student 26
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0026F', 'ADAM HAIQAL BIN AZLAN', 'adamhaiqal@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'adamhaiqal@umk.edu.my';

-- student 27
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0027F', 'MUHAZLAN BIN  MAHADHIR', 'muhazlanmahadhir@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'muhazlanmahadhir@umk.edu.my';

-- student 28
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0028F', 'AKMAL FAYYAD BIN MUSTAPHA', 'akmalfayyad@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'akmalfayyad@umk.edu.my';

-- student 29
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0029F', 'NORLAILA BINTI MUHAMMAD AZWAN', 'lailaazwan@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'lailaazwan@umk.edu.my';

-- student 30
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0030F', 'SARAH ATIQAH BINTI MAZLAN', 'sarahatiqah@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 1, 70,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'sarahatiqah@umk.edu.my';

-- student 31
INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), 'A17M0031F', 'SAM', 'sam@umk.edu.my', '097111775', '0123450004', NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_STDN (ID, STUDENT_STATUS, COHORT_ID,STUDY_MODE_ID) VALUES (currval('SQ_AD_ACTR'), 0, 79,1);

UPDATE AD_USER
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'sam@umk.edu.my';



