INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBT'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBT') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBS'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBS') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBB'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBB') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBP'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBP') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBH'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBH') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBA'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-PHD-PBA') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBT'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBT') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBS'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBS') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBB'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBB') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBP'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBP') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-PBH'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-PBH') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBA'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FIAT-MASTER-MBA') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PBG'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PBG') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PBN'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PBN') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PBK'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PBK') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PFB'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PFB') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PFS'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PFS') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PFT'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-PHD-PFT') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MBG'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MBG') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MBN'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MBN') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MBK'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MBK') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MFB'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MFB') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MFS'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MFS') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MFT'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FSB-MASTER-MFT') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PCp'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PCp') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDN'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDN') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDA'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDA') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDM'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDM') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDR'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDR') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDF'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-PHD-PDF') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDP'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDP') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDN'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDN') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDA'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDA') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDM'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDM') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDR'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDR') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDF'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FPV-MASTER-MDF') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCS'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCS') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCN'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCN') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCO'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCO') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCA'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCA') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCK'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCK') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-MCB'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-MCB') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCC'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-PHD-PCC') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCS'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCS') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCN'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCN') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCO'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCO') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCA'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCA') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCK'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCK') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-PCB'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-PCB') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCC'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'PBI-MASTER-MCC') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCW'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCW') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCT'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCT') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCP'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCP') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCM'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCM') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCV'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-PHD-PCV') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCW'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCW') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCT'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCT') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCP'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCP') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCM'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCM') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCV'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FTKW-MASTER-MCV') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAM'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAM') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAF'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAF') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAA'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAA') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAR'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAR') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAK'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAK') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAW'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAW') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAH'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAH') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAP'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PAP') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PMS'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-PHD-PMS') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAM'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAM') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAF'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAF') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAA'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAA') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAR'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAR') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAK'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAK') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAW'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAW') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAH'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAH') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAP'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MAP') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);
INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
                     PERIOD, MAX_PERIOD, ORDINAL,
                     C_ID, C_TS, M_ST)
VALUES (NEXTVAL('SQ_AD_CRLM'),
  (SELECT ID
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MMS'),
  (SELECT CODE
   FROM AD_PRGM
   WHERE CODE = 'FKP-MASTER-MMS') || '-CRLM-0001',
  100, 10, 10, 10, 10, 10, 10, 124,
  8, 12, 1,
  1, CURRENT_TIMESTAMP, 1);


--INSERT INTO AD_CRLM (ID, PROGRAM_ID, CODE,
--                     CORE, CURRICULUM, ELECTIVE, GENERAL, LANGUAGE, REQUIRED, OTHERS, TOTAL_CREDIT,
--                     PERIOD, MAX_PERIOD, ORDINAL,
--                     C_ID, C_TS, M_ST)
--VALUES (NEXTVAL('SQ_AD_CRLM'),
--  (SELECT ID
--   FROM AD_PRGM
--   WHERE CODE = 'MGSEB-MBA'),
--  (SELECT CODE
--   FROM AD_PRGM
--   WHERE CODE = 'MGSEB-MBA') || '-CRLM-0001',
--  100, 10, 10, 10, 10, 10, 10, 124,
--  8, 12, 1,
--  1, CURRENT_TIMESTAMP, 1);  