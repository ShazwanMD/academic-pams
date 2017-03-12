INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '760607145591', 'STUDENT ONE', 'student1@umk.edu.my', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_APCN (ID) VALUES (currval('SQ_AD_ACTR'));

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student1@umk.edu.my';

INSERT INTO AD_ACTR (ID, IDENTITY_NO, NAME, EMAIL, PHONE, MOBILE, FAX, ACTOR_TYPE, C_TS, C_ID, M_ST)
VALUES
  (nextval('SQ_AD_ACTR'), '860607145592', 'STUDENT TWO', 'student2@umk.edu.my', NULL, NULL, NULL, 1,
                          CURRENT_TIMESTAMP, 1, 1);

INSERT INTO AD_APCN (ID) VALUES (currval('SQ_AD_ACTR'));

UPDATE AD_user
SET actor_id = currval('SQ_AD_ACTR')
WHERE email = 'student2@umk.edu.my';
