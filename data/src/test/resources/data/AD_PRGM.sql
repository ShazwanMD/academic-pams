INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBT',
true, 0,
   'Doctor of Philosophy Bio-Industrial Technology',
   'Doctor of Philosophy Bio-Industrial Technology',
   'Doctor of Philosophy Bio-Industrial Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBS',
true, 0,
   'Doctor of Philosophy Agro Technopreneurship',
   'Doctor of Philosophy Agro Technopreneurship',
   'Doctor of Philosophy Agro Technopreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBB',
true, 0,
   'Doctor of Philosophy Agriculture Biotechnology',
   'Doctor of Philosophy Agriculture Biotechnology',
   'Doctor of Philosophy Agriculture Biotechnology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBP',
true, 0,
   'Doctor of Philosophy Product Development Technology',
   'Doctor of Philosophy Product Development Technology',
   'Doctor of Philosophy Product Development Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBH',
true, 0,
   'Doctor of Philosophy Animal Husbandary',
   'Doctor of Philosophy Animal Husbandary',
   'Doctor of Philosophy Animal Husbandary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBA',
true, 0,
   'Doctor of Philosophy Akuakultur',
   'Doctor of Philosophy Akuakultur',
   'Doctor of Philosophy Akuakultur',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBT',
true, 0,
   'Master of Science Bio-Industrial Technology',
   'Master of Science Bio-Industrial Technology',
   'Master of Science Bio-Industrial Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBS',
true, 0,
   'Master of Science Agro Technopreneurship',
   'Master of Science Agro Technopreneurship',
   'Master of Science Agro Technopreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_, STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBB',
true, 0,
   'Master of Science Agriculture Biotechnology',
   'Master of Science Agriculture Biotechnology',
   'Master of Science Agriculture Biotechnology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBP',
true, 0,
   'Master of Science Product Development Technology',
   'Master of Science Product Development Technology',
   'Master of Science Product Development Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-PBH',
true, 0,
   'Master of Science Animal Husbandary',
   'Master of Science Animal Husbandary',
   'Master of Science Animal Husbandary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBA',
true, 0,
   'Master of Science Akuakultur',
   'Master of Science Akuakultur',
   'Master of Science Akuakultur',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PBG',
true, 0,
   'Doctor of Philosophy Geoscience',
   'Doctor of Philosophy Geoscience',
   'Doctor of Philosophy Geoscience',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PBN',
true, 0,
   'Doctor of Philosophy Natural Resources Management',
   'Doctor of Philosophy Natural Resources Management',
   'Doctor of Philosophy Natural Resources Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PBK',
true, 0,
   'Doctor of Philosophy Sustainable Science',
   'Doctor of Philosophy Sustainable Science',
   'Doctor of Philosophy Sustainable Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PFB',
true, 0,
   'Doctor of Philosophy Material Technology',
   'Doctor of Philosophy Material Technology',
   'Doctor of Philosophy Material Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PFS',
true, 0,
   'Doctor of Philosophy Forest Resources Technology',
   'Doctor of Philosophy Forest Resources Technology',
   'Doctor of Philosophy Forest Resources Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PFT',
true, 0,
   'Doctor of Philosophy Energy Technology',
   'Doctor of Philosophy Energy Technology',
   'Doctor of Philosophy Energy Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_, STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MBG',
true, 0,
   'Master of Science Geoscience',
   'Master of Science Geoscience',
   'Master of Science Geoscience',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MBN',
true, 0,
   'Master of Science Natural Resources Management',
   'Master of Science Natural Resources Management',
   'Master of Science Natural Resources Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MBK',
true, 0,
   'Master of Science Sustainable Science',
   'Master of Science Sustainable Science',
   'Master of Science Sustainable Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MFB',
true, 0,
   'Master of Science Material Technology',
   'Master of Science Material Technology',
   'Master of Science Material Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MFS',
true, 0,
   'Master of Science Forest Resources Technology',
   'Master of Science Forest Resources Technology',
   'Master of Science Forest Resources Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MFT',
true, 0,
   'Master of Science Energy Technology',
   'Master of Science Energy Technology',
   'Master of Science Energy Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PCp',
true, 0,
   'Doctor of Philosophy Phatology',
   'Doctor of Philosophy Phatology',
   'Doctor of Philosophy Phatology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDN',
true, 0,
   'Doctor of Philosophy Nutrition',
   'Doctor of Philosophy Nutrition',
   'Doctor of Philosophy Nutrition',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS,  TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDA',
true, 0,
   'Doctor of Philosophy Anatomy',
   'Doctor of Philosophy Anatomy',
   'Doctor of Philosophy Anatomy',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDM',
true, 0,
   'Doctor of Philosophy Microbiology',
   'Doctor of Philosophy Microbiology',
   'Doctor of Philosophy Microbiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDR',
true, 0,
   'Doctor of Philosophy Parasitology',
   'Doctor of Philosophy Parasitology',
   'Doctor of Philosophy Parasitology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDF',
true, 0,
   'Doctor of Philosophy Physiology',
   'Doctor of Philosophy Physiology',
   'Doctor of Philosophy Physiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDP',
true, 0,
   'Master of Science Phatology',
   'Master of Science Phatology',
   'Master of Science Phatology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDN',
true, 0,
   'Master of Science Nutrition',
   'Master of Science Nutrition',
   'Master of Science Nutrition',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDA',
true, 0,
   'Master of Science Anatomy',
   'Master of Science Anatomy',
   'Master of Science Anatomy',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDM',
true, 0,
   'Master of Science Microbiology',
   'Master of Science Microbiology',
   'Master of Science Microbiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDR',
true, 0,
   'Master of Science Parasitology',
   'Master of Science Parasitology',
   'Master of Science Parasitology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDF',
true, 0,
   'Master of Science Physiology',
   'Master of Science Physiology',
   'Master of Science Physiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCS',
true, 0,
   'Doctor of Philosophy Studies of History and Civilisation',
   'Doctor of Philosophy Studies of History and Civilisation',
   'Doctor of Philosophy Studies of History and Civilisation',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCN',
true, 0,
   'Doctor of Philosophy Development and Educational Values',
   'Doctor of Philosophy Development and Educational Values',
   'Doctor of Philosophy Development and Educational Values',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCO',
true, 0,
   'Doctor of Philosophy Industrial Psychological Organization',
   'Doctor of Philosophy Industrial Psychological Organization',
   'Doctor of Philosophy Industrial Psychological Organization',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCA',
true, 0,
   'Doctor of Philosophy Religion And Contemporary',
   'Doctor of Philosophy Religion And Contemporary',
   'Doctor of Philosophy Religion And Contemporary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCK',
   true, 0,
   'Doctor of Philosophy Social Work',
   'Doctor of Philosophy Social Work',
   'Doctor of Philosophy Social Work',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-MCB',
   true, 0,
   'Doctor of Philosophy Language Studies',
   'Doctor of Philosophy Language Studies',
   'Doctor of Philosophy Language Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCC',
   true, 0,
   'Doctor of Philosophy Communication',
   'Doctor of Philosophy Communication',
   'Doctor of Philosophy Communication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCS',
true, 0,
   'Master of Arts Studies of History and Civilisation',
   'Master of Arts Studies of History and Civilisation',
   'Master of Arts Studies of History and Civilisation',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCN',
true, 0,
   'Master of Arts Development and Educational Values',
   'Master of Arts Development and Educational Values',
   'Master of Arts Development and Educational Values',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCO',
true, 0,
   'Master of Arts Industrial Psychological Organization',
   'Master of Arts Industrial Psychological Organization',
   'Master of Arts Industrial Psychological Organization',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCA',
true, 0,
   'Master of Arts Religion And Contemporary',
   'Master of Arts Religion And Contemporary',
   'Master of Arts Religion And Contemporary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCK',
true, 0,
   'Master of Arts Social Work',
   'Master of Arts Social Work',
   'Master of Arts Social Work',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-PCB',
true, 0,
   'Master of Arts Language Studies',
   'Master of Arts Language Studies',
   'Master of Arts Language Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCC',
true, 0,
   'Master of Arts Communication',
   'Master of Arts Communication',
   'Master of Arts Communication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCW',
true, 0,
   'Doctor of Philosophy Heritage Studies',
   'Doctor of Philosophy Heritage Studies',
   'Doctor of Philosophy Heritage Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCT',
true, 0,
   'Doctor of Philosophy Textile and Fashion',
   'Doctor of Philosophy Textile and Fashion',
   'Doctor of Philosophy Textile and Fashion',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCP',
true, 0,
   'Doctor of Philosophy Product Design',
   'Doctor of Philosophy Product Design',
   'Doctor of Philosophy Product Design',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCM',
true, 0,
   'Doctor of Philosophy Multimedia',
   'Doctor of Philosophy Multimedia',
   'Doctor of Philosophy Multimedia',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCV',
true, 0,
   'Doctor of Philosophy VisualCommunication',
   'Doctor of Philosophy VisualCommunication',
   'Doctor of Philosophy VisualCommunication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCW',
true, 0,
   'Master of Arts Heritage Studies',
   'Master of Arts Heritage Studies',
   'Master of Arts Heritage Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCT',
true, 0,
   'Master of Arts Textile and Fashion',
   'Master of Arts Textile and Fashion',
   'Master of Arts Textile and Fashion',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCP',
true, 0,
   'Master of Arts Product Design',
   'Master of Arts Product Design',
   'Master of Arts Product Design',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCM',
true, 0,
   'Master of Arts Multimedia',
   'Master of Arts Multimedia',
   'Master of Arts Multimedia',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCV',
true, 0,
   'Master of Arts VisualCommunication',
   'Master of Arts VisualCommunication',
   'Master of Arts VisualCommunication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAM',
true, 0,
   'Doctor of Philosophy Management',
   'Doctor of Philosophy Management',
   'Doctor of Philosophy Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAF',
true, 0,
   'Doctor of Philosophy Finance',
   'Doctor of Philosophy Finance',
   'Doctor of Philosophy Finance',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAA',
true, 0,
   'Doctor of Philosophy Accounting',
   'Doctor of Philosophy Accounting',
   'Doctor of Philosophy Accounting',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAR',
true, 0,
   'Doctor of Philosophy Retailing',
   'Doctor of Philosophy Retailing',
   'Doctor of Philosophy Retailing',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAK',
true, 0,
   'Doctor of Philosophy Commerce',
   'Doctor of Philosophy Commerce',
   'Doctor of Philosophy Commerce',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAW',
true, 0,
   'Doctor of Philosophy HealthEntrepreneurship',
   'Doctor of Philosophy HealthEntrepreneurship',
   'Doctor of Philosophy HealthEntrepreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAH',
true, 0,
   'Doctor of Philosophy Hospitality',
   'Doctor of Philosophy Hospitality',
   'Doctor of Philosophy Hospitality',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAP',
true, 0,
   'Doctor of Philosophy Tourism',
   'Doctor of Philosophy Tourism',
   'Doctor of Philosophy Tourism',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PMS',
true, 0,
   'Doctor of Philosophy Mathematical Science',
   'Doctor of Philosophy Mathematical Science',
   'Doctor of Philosophy Mathematical Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAM',
true, 0,
   'Master of Entrepreneurship Management',
   'Master of Entrepreneurship Management',
   'Master of Entrepreneurship Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAF',
true, 0,
   'Master of Entrepreneurship Finance',
   'Master of Entrepreneurship Finance',
   'Master of Entrepreneurship Finance',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAA',
true, 0,
   'Master of Entrepreneurship Accounting',
   'Master of Entrepreneurship Accounting',
   'Master of Entrepreneurship Accounting',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAR',
true, 0,
   'Master of Entrepreneurship Retailing',
   'Master of Entrepreneurship Retailing',
   'Master of Entrepreneurship Retailing',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAK',
true, 0,
   'Master of Entrepreneurship Commerce',
   'Master of Entrepreneurship Commerce',
   'Master of Entrepreneurship Commerce',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAW',
true, 0,
   'Master of Entrepreneurship HealthEntrepreneurship',
   'Master of Entrepreneurship HealthEntrepreneurship',
   'Master of Entrepreneurship HealthEntrepreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAH',
true, 0,
   'Master of Entrepreneurship Hospitality',
   'Master of Entrepreneurship Hospitality',
   'Master of Entrepreneurship Hospitality',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAP',
true, 0,
   'Master of Entrepreneurship Tourism',
   'Master of Entrepreneurship Tourism',
   'Master of Entrepreneurship Tourism',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MMS',
true, 0,
   'Master of Entrepreneurship Mathematical Science',
   'Master of Entrepreneurship Mathematical Science',
   'Master of Entrepreneurship Mathematical Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'MGSEB-MBA',
true, 0,
   'Master of Business Administration',
   'Master of Business Administration',
   'Master of Business Administration',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'MGSEB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE,CURRENT_,STATUS, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'MGSEB-DBA',
true, 0,
   'Doctorate of Business Administration',
   'Doctorate of Business Administration',
   'Doctorate of Business Administration',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'MGSEB'), CURRENT_TIMESTAMP, 0, 1);

 
