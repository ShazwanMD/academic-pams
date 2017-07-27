-- USR, PGW, KRN BDR
-- USER, PEGAWAI, KERANI, BENDAHARI
-- abc123 = 6367c48dd193d56ea7b0baad25b19455e529f5ee

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'root', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'Root', 'root@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'admin', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS Admin', 'admin@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'system', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS System', 'system@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'bursary', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS Bursary', 'bursary@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'cps', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS CPS', 'cps@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'cps-kerani', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS CPS Kerani', 'cps-kerani@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'cps-pegawai', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS CPS Pegawai', 'cps-pegawai@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'mgseb', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS MGSEB', 'mgseb@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'mgseb-kerani', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS MGSEB Kerani', 'mgseb-kerani@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'mgseb-pegawai', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS MGSEB Pegawai', 'mgseb-pegawai@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'student1', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS Student1', 'student1@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'student2', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS Student2', 'student2@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'lecturer1', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS Lecturer1', 'Lecturer1@umk.edu.my', 'abc123');

INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'lecturer2', TRUE, TRUE, 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_USER (ID, REAL_NAME, EMAIL, PASSWORD)
VALUES (currval('SQ_AD_PCPL'), 'PAMS Lecturer2', 'Lecturer2@umk.edu.my', 'abc123');

---------------------------------------------------------
-- GROUP START
---------------------------------------------------------

-- user@ROOT
INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'GRP_USR', TRUE, TRUE, 1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_GROP (ID) VALUES (currval('SQ_AD_PCPL'));
INSERT INTO AD_PCPL_ROLE (ID, PRINCIPAL_ID, ROLE_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL_ROLE'), (SELECT ID FROM AD_PCPL WHERE NAME = 'GRP_USR'), 1, 1, 1, CURRENT_TIMESTAMP);

-- ADMIN
INSERT INTO AD_PCPL (ID, NAME, ENABLED, LOCKED, PRINCIPAL_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL'), 'GRP_ADM', TRUE, TRUE, 1, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_GROP (ID) VALUES (currval('SQ_AD_PCPL'));
INSERT INTO AD_PCPL_ROLE (ID, PRINCIPAL_ID, ROLE_TYPE, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_PCPL_ROLE'), (SELECT ID FROM AD_PCPL WHERE NAME = 'GRP_ADM'), 0, 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_GROP_MMBR'),
                                                                                (SELECT ID FROM AD_PCPL WHERE NAME = 'GRP_ADM'),
                                                                                (SELECT ID FROM AD_PCPL WHERE NAME = 'root'), 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_GROP_MMBR'),
                                                                                (SELECT ID FROM AD_PCPL WHERE NAME = 'GRP_ADM'),
                                                                                (SELECT ID FROM AD_PCPL WHERE NAME = 'bursary'), 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_GROP_MMBR'),
                                                                                (SELECT ID FROM AD_PCPL WHERE NAME = 'GRP_ADM'),
                                                                                (SELECT ID FROM AD_PCPL WHERE NAME = 'cps'), 1, 1, CURRENT_TIMESTAMP);
INSERT INTO AD_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_GROP_MMBR'),
                                                                                (SELECT ID FROM AD_PCPL WHERE NAME = 'GRP_ADM'),
                                                                                (SELECT ID FROM AD_PCPL WHERE NAME = 'mgseb'), 1, 1, CURRENT_TIMESTAMP);


INSERT INTO AD_GROP_MMBR (ID, GROUP_ID, PRINCIPAL_ID, M_ST, C_ID, C_TS) VALUES (nextval('SQ_AD_GROP_MMBR'),
                                                                                 (SELECT ID FROM AD_PCPL WHERE NAME = 'GRP_USR'),
                                                                                 (SELECT ID FROM AD_PCPL WHERE NAME = 'GRP_ADM'), 1, 1, CURRENT_TIMESTAMP);



---------------------------------------------------------
-- GROUP END
---------------------------------------------------------

