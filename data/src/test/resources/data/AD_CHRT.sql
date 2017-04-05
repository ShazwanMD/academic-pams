INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A07/PHD/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A07/PHD/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A07/PHD/0001'),
  'COHORT A07/PHD/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A07/PHD/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A07/PHD/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A07/PHD/0002'),
  'COHORT A07/PHD/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A07/PHD/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A07/PHD/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A07/PHD/0003'),
  'COHORT A07/PHD/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A07/PHD/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A07/PHD/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A07/PHD/0004'),
  'COHORT A07/PHD/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A07/MASTER/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A07/MASTER/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A07/MASTER/0001'),
  'COHORT A07/MASTER/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A07/MASTER/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A07/MASTER/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A07/MASTER/0002'),
  'COHORT A07/MASTER/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A07/MASTER/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A07/MASTER/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A07/MASTER/0003'),
  'COHORT A07/MASTER/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A07/MASTER/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A07/MASTER/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A07/MASTER/0004'),
  'COHORT A07/MASTER/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/PHD/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A08/PHD/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/PHD/0001'),
  'COHORT A08/PHD/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/PHD/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A08/PHD/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/PHD/0002'),
  'COHORT A08/PHD/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/PHD/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A08/PHD/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/PHD/0003'),
  'COHORT A08/PHD/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/PHD/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A08/PHD/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/PHD/0004'),
  'COHORT A08/PHD/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/PHD/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A08/PHD/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/PHD/0005'),
  'COHORT A08/PHD/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/PHD/0006'),
  (SELECT ID FROM AD_CRLM where code = 'A08/PHD/0006' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/PHD/0006'),
  'COHORT A08/PHD/0006',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/MASTER/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A08/MASTER/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/MASTER/0001'),
  'COHORT A08/MASTER/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/MASTER/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A08/MASTER/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/MASTER/0002'),
  'COHORT A08/MASTER/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/MASTER/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A08/MASTER/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/MASTER/0003'),
  'COHORT A08/MASTER/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/MASTER/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A08/MASTER/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/MASTER/0004'),
  'COHORT A08/MASTER/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/MASTER/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A08/MASTER/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/MASTER/0005'),
  'COHORT A08/MASTER/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A08/MASTER/0006'),
  (SELECT ID FROM AD_CRLM where code = 'A08/MASTER/0006' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A08/MASTER/0006'),
  'COHORT A08/MASTER/0006',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/PHD/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A06/PHD/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/PHD/0001'),
  'COHORT A06/PHD/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/PHD/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A06/PHD/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/PHD/0002'),
  'COHORT A06/PHD/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/PHD/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A06/PHD/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/PHD/0003'),
  'COHORT A06/PHD/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/PHD/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A06/PHD/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/PHD/0004'),
  'COHORT A06/PHD/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/PHD/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A06/PHD/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/PHD/0005'),
  'COHORT A06/PHD/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/PHD/0006'),
  (SELECT ID FROM AD_CRLM where code = 'A06/PHD/0006' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/PHD/0006'),
  'COHORT A06/PHD/0006',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/MASTER/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A06/MASTER/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/MASTER/0001'),
  'COHORT A06/MASTER/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/MASTER/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A06/MASTER/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/MASTER/0002'),
  'COHORT A06/MASTER/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/MASTER/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A06/MASTER/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/MASTER/0003'),
  'COHORT A06/MASTER/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/MASTER/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A06/MASTER/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/MASTER/0004'),
  'COHORT A06/MASTER/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/MASTER/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A06/MASTER/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/MASTER/0005'),
  'COHORT A06/MASTER/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A06/MASTER/0006'),
  (SELECT ID FROM AD_CRLM where code = 'A06/MASTER/0006' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A06/MASTER/0006'),
  'COHORT A06/MASTER/0006',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/PHD/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A04/PHD/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/PHD/0001'),
  'COHORT A04/PHD/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/PHD/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A04/PHD/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/PHD/0002'),
  'COHORT A04/PHD/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/PHD/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A04/PHD/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/PHD/0003'),
  'COHORT A04/PHD/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/PHD/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A04/PHD/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/PHD/0004'),
  'COHORT A04/PHD/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/PHD/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A04/PHD/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/PHD/0005'),
  'COHORT A04/PHD/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/PHD/0006'),
  (SELECT ID FROM AD_CRLM where code = 'A04/PHD/0006' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/PHD/0006'),
  'COHORT A04/PHD/0006',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/PHD/0007'),
  (SELECT ID FROM AD_CRLM where code = 'A04/PHD/0007' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/PHD/0007'),
  'COHORT A04/PHD/0007',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/MASTER/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A04/MASTER/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/MASTER/0001'),
  'COHORT A04/MASTER/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/MASTER/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A04/MASTER/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/MASTER/0002'),
  'COHORT A04/MASTER/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/MASTER/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A04/MASTER/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/MASTER/0003'),
  'COHORT A04/MASTER/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/MASTER/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A04/MASTER/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/MASTER/0004'),
  'COHORT A04/MASTER/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/MASTER/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A04/MASTER/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/MASTER/0005'),
  'COHORT A04/MASTER/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/MASTER/0006'),
  (SELECT ID FROM AD_CRLM where code = 'A04/MASTER/0006' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/MASTER/0006'),
  'COHORT A04/MASTER/0006',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A04/MASTER/0007'),
  (SELECT ID FROM AD_CRLM where code = 'A04/MASTER/0007' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A04/MASTER/0007'),
  'COHORT A04/MASTER/0007',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/PHD/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A02/PHD/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/PHD/0001'),
  'COHORT A02/PHD/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/PHD/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A02/PHD/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/PHD/0002'),
  'COHORT A02/PHD/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/PHD/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A02/PHD/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/PHD/0003'),
  'COHORT A02/PHD/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/PHD/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A02/PHD/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/PHD/0004'),
  'COHORT A02/PHD/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/PHD/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A02/PHD/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/PHD/0005'),
  'COHORT A02/PHD/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/MASTER/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A02/MASTER/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/MASTER/0001'),
  'COHORT A02/MASTER/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/MASTER/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A02/MASTER/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/MASTER/0002'),
  'COHORT A02/MASTER/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/MASTER/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A02/MASTER/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/MASTER/0003'),
  'COHORT A02/MASTER/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/MASTER/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A02/MASTER/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/MASTER/0004'),
  'COHORT A02/MASTER/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A02/MASTER/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A02/MASTER/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A02/MASTER/0005'),
  'COHORT A02/MASTER/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/PHD/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A01/PHD/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/PHD/0001'),
  'COHORT A01/PHD/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/PHD/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A01/PHD/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/PHD/0002'),
  'COHORT A01/PHD/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/PHD/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A01/PHD/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/PHD/0003'),
  'COHORT A01/PHD/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/PHD/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A01/PHD/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/PHD/0004'),
  'COHORT A01/PHD/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/PHD/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A01/PHD/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/PHD/0005'),
  'COHORT A01/PHD/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/PHD/0006'),
  (SELECT ID FROM AD_CRLM where code = 'A01/PHD/0006' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/PHD/0006'),
  'COHORT A01/PHD/0006',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/PHD/0007'),
  (SELECT ID FROM AD_CRLM where code = 'A01/PHD/0007' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/PHD/0007'),
  'COHORT A01/PHD/0007',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/PHD/0008'),
  (SELECT ID FROM AD_CRLM where code = 'A01/PHD/0008' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/PHD/0008'),
  'COHORT A01/PHD/0008',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/MASTER/0001'),
  (SELECT ID FROM AD_CRLM where code = 'A01/MASTER/0001' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/MASTER/0001'),
  'COHORT A01/MASTER/0001',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/MASTER/0002'),
  (SELECT ID FROM AD_CRLM where code = 'A01/MASTER/0002' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/MASTER/0002'),
  'COHORT A01/MASTER/0002',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/MASTER/0003'),
  (SELECT ID FROM AD_CRLM where code = 'A01/MASTER/0003' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/MASTER/0003'),
  'COHORT A01/MASTER/0003',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/MASTER/0004'),
  (SELECT ID FROM AD_CRLM where code = 'A01/MASTER/0004' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/MASTER/0004'),
  'COHORT A01/MASTER/0004',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/MASTER/0005'),
  (SELECT ID FROM AD_CRLM where code = 'A01/MASTER/0005' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/MASTER/0005'),
  'COHORT A01/MASTER/0005',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/MASTER/0006'),
  (SELECT ID FROM AD_CRLM where code = 'A01/MASTER/0006' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/MASTER/0006'),
  'COHORT A01/MASTER/0006',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/MASTER/0007'),
  (SELECT ID FROM AD_CRLM where code = 'A01/MASTER/0007' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/MASTER/0007'),
  'COHORT A01/MASTER/0007',
  1,
  1, CURRENT_TIMESTAMP, 1
);
INSERT INTO AD_CHRT (
  ID,
  PROGRAM_ID,
  CURRICULUM_ID,
  CODE,
  DESCRIPTION,
  CLASSIFICATION,
  C_ID, C_TS, M_ST)
VALUES (
  nextval('SQ_AD_CHRT'),
  (SELECT ID FROM AD_PRGM where code = 'A01/MASTER/0008'),
  (SELECT ID FROM AD_CRLM where code = 'A01/MASTER/0008' || '/CRLM/0001'),
  (SELECT CODE || '/CHRT/0001' FROM AD_PRGM where code = 'A01/MASTER/0008'),
  'COHORT A01/MASTER/0008',
  1,
  1, CURRENT_TIMESTAMP, 1
);
