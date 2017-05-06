INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBT',
   'Doctor of Philosophy Bio-Industrial Technology',
   'Doctor of Philosophy Bio-Industrial Technology',
   'Doctor of Philosophy Bio-Industrial Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBS',
   'Doctor of Philosophy Agro Technopreneurship',
   'Doctor of Philosophy Agro Technopreneurship',
   'Doctor of Philosophy Agro Technopreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBB',
   'Doctor of Philosophy Agriculture Biotechnology',
   'Doctor of Philosophy Agriculture Biotechnology',
   'Doctor of Philosophy Agriculture Biotechnology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBP',
   'Doctor of Philosophy Product Development Technology',
   'Doctor of Philosophy Product Development Technology',
   'Doctor of Philosophy Product Development Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBH',
   'Doctor of Philosophy Animal Husbandary',
   'Doctor of Philosophy Animal Husbandary',
   'Doctor of Philosophy Animal Husbandary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-PHD-PBA',
   'Doctor of Philosophy Akuakultur',
   'Doctor of Philosophy Akuakultur',
   'Doctor of Philosophy Akuakultur',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBT',
   'Master of Science Bio-Industrial Technology',
   'Master of Science Bio-Industrial Technology',
   'Master of Science Bio-Industrial Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBS',
   'Master of Science Agro Technopreneurship',
   'Master of Science Agro Technopreneurship',
   'Master of Science Agro Technopreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBB',
   'Master of Science Agriculture Biotechnology',
   'Master of Science Agriculture Biotechnology',
   'Master of Science Agriculture Biotechnology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBP',
   'Master of Science Product Development Technology',
   'Master of Science Product Development Technology',
   'Master of Science Product Development Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-PBH',
   'Master of Science Animal Husbandary',
   'Master of Science Animal Husbandary',
   'Master of Science Animal Husbandary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FIAT-MASTER-MBA',
   'Master of Science Akuakultur',
   'Master of Science Akuakultur',
   'Master of Science Akuakultur',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FIAT'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PBG',
   'Doctor of Philosophy Geoscience',
   'Doctor of Philosophy Geoscience',
   'Doctor of Philosophy Geoscience',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PBN',
   'Doctor of Philosophy Natural Resources Management',
   'Doctor of Philosophy Natural Resources Management',
   'Doctor of Philosophy Natural Resources Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PBK',
   'Doctor of Philosophy Sustainable Science',
   'Doctor of Philosophy Sustainable Science',
   'Doctor of Philosophy Sustainable Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PFB',
   'Doctor of Philosophy Material Technology',
   'Doctor of Philosophy Material Technology',
   'Doctor of Philosophy Material Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PFS',
   'Doctor of Philosophy Forest Resources Technology',
   'Doctor of Philosophy Forest Resources Technology',
   'Doctor of Philosophy Forest Resources Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-PHD-PFT',
   'Doctor of Philosophy Energy Technology',
   'Doctor of Philosophy Energy Technology',
   'Doctor of Philosophy Energy Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MBG',
   'Master of Science Geoscience',
   'Master of Science Geoscience',
   'Master of Science Geoscience',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MBN',
   'Master of Science Natural Resources Management',
   'Master of Science Natural Resources Management',
   'Master of Science Natural Resources Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MBK',
   'Master of Science Sustainable Science',
   'Master of Science Sustainable Science',
   'Master of Science Sustainable Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MFB',
   'Master of Science Material Technology',
   'Master of Science Material Technology',
   'Master of Science Material Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MFS',
   'Master of Science Forest Resources Technology',
   'Master of Science Forest Resources Technology',
   'Master of Science Forest Resources Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FSB-MASTER-MFT',
   'Master of Science Energy Technology',
   'Master of Science Energy Technology',
   'Master of Science Energy Technology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FSB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PCp',
   'Doctor of Philosophy Phatology',
   'Doctor of Philosophy Phatology',
   'Doctor of Philosophy Phatology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDN',
   'Doctor of Philosophy Nutrition',
   'Doctor of Philosophy Nutrition',
   'Doctor of Philosophy Nutrition',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDA',
   'Doctor of Philosophy Anatomy',
   'Doctor of Philosophy Anatomy',
   'Doctor of Philosophy Anatomy',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDM',
   'Doctor of Philosophy Microbiology',
   'Doctor of Philosophy Microbiology',
   'Doctor of Philosophy Microbiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDR',
   'Doctor of Philosophy Parasitology',
   'Doctor of Philosophy Parasitology',
   'Doctor of Philosophy Parasitology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-PHD-PDF',
   'Doctor of Philosophy Physiology',
   'Doctor of Philosophy Physiology',
   'Doctor of Philosophy Physiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDP',
   'Master of Science Phatology',
   'Master of Science Phatology',
   'Master of Science Phatology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDN',
   'Master of Science Nutrition',
   'Master of Science Nutrition',
   'Master of Science Nutrition',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDA',
   'Master of Science Anatomy',
   'Master of Science Anatomy',
   'Master of Science Anatomy',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDM',
   'Master of Science Microbiology',
   'Master of Science Microbiology',
   'Master of Science Microbiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDR',
   'Master of Science Parasitology',
   'Master of Science Parasitology',
   'Master of Science Parasitology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FPV-MASTER-MDF',
   'Master of Science Physiology',
   'Master of Science Physiology',
   'Master of Science Physiology',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FPV'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCS',
   'Doctor of Philosophy Studies of History and Civilisation',
   'Doctor of Philosophy Studies of History and Civilisation',
   'Doctor of Philosophy Studies of History and Civilisation',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCN',
   'Doctor of Philosophy Development and Educational Values',
   'Doctor of Philosophy Development and Educational Values',
   'Doctor of Philosophy Development and Educational Values',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCO',
   'Doctor of Philosophy Industrial Psychological Organization',
   'Doctor of Philosophy Industrial Psychological Organization',
   'Doctor of Philosophy Industrial Psychological Organization',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCA',
   'Doctor of Philosophy Religion And Contemporary',
   'Doctor of Philosophy Religion And Contemporary',
   'Doctor of Philosophy Religion And Contemporary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCK',
   'Doctor of Philosophy Social Work',
   'Doctor of Philosophy Social Work',
   'Doctor of Philosophy Social Work',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-MCB',
   'Doctor of Philosophy Language Studies',
   'Doctor of Philosophy Language Studies',
   'Doctor of Philosophy Language Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-PHD-PCC',
   'Doctor of Philosophy Communication',
   'Doctor of Philosophy Communication',
   'Doctor of Philosophy Communication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCS',
   'Master of Arts Studies of History and Civilisation',
   'Master of Arts Studies of History and Civilisation',
   'Master of Arts Studies of History and Civilisation',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCN',
   'Master of Arts Development and Educational Values',
   'Master of Arts Development and Educational Values',
   'Master of Arts Development and Educational Values',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCO',
   'Master of Arts Industrial Psychological Organization',
   'Master of Arts Industrial Psychological Organization',
   'Master of Arts Industrial Psychological Organization',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCA',
   'Master of Arts Religion And Contemporary',
   'Master of Arts Religion And Contemporary',
   'Master of Arts Religion And Contemporary',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCK',
   'Master of Arts Social Work',
   'Master of Arts Social Work',
   'Master of Arts Social Work',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-PCB',
   'Master of Arts Language Studies',
   'Master of Arts Language Studies',
   'Master of Arts Language Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'PBI-MASTER-MCC',
   'Master of Arts Communication',
   'Master of Arts Communication',
   'Master of Arts Communication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'PBI'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCW',
   'Doctor of Philosophy Heritage Studies',
   'Doctor of Philosophy Heritage Studies',
   'Doctor of Philosophy Heritage Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCT',
   'Doctor of Philosophy Textile and Fashion',
   'Doctor of Philosophy Textile and Fashion',
   'Doctor of Philosophy Textile and Fashion',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCP',
   'Doctor of Philosophy Product Design',
   'Doctor of Philosophy Product Design',
   'Doctor of Philosophy Product Design',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCM',
   'Doctor of Philosophy Multimedia',
   'Doctor of Philosophy Multimedia',
   'Doctor of Philosophy Multimedia',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-PHD-PCV',
   'Doctor of Philosophy VisualCommunication',
   'Doctor of Philosophy VisualCommunication',
   'Doctor of Philosophy VisualCommunication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCW',
   'Master of Arts Heritage Studies',
   'Master of Arts Heritage Studies',
   'Master of Arts Heritage Studies',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCT',
   'Master of Arts Textile and Fashion',
   'Master of Arts Textile and Fashion',
   'Master of Arts Textile and Fashion',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCP',
   'Master of Arts Product Design',
   'Master of Arts Product Design',
   'Master of Arts Product Design',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCM',
   'Master of Arts Multimedia',
   'Master of Arts Multimedia',
   'Master of Arts Multimedia',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FTKW-MASTER-MCV',
   'Master of Arts VisualCommunication',
   'Master of Arts VisualCommunication',
   'Master of Arts VisualCommunication',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FTKW'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAM',
   'Doctor of Philosophy Management',
   'Doctor of Philosophy Management',
   'Doctor of Philosophy Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAF',
   'Doctor of Philosophy Finance',
   'Doctor of Philosophy Finance',
   'Doctor of Philosophy Finance',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAA',
   'Doctor of Philosophy Accounting',
   'Doctor of Philosophy Accounting',
   'Doctor of Philosophy Accounting',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAR',
   'Doctor of Philosophy Retailing',
   'Doctor of Philosophy Retailing',
   'Doctor of Philosophy Retailing',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAK',
   'Doctor of Philosophy Commerce',
   'Doctor of Philosophy Commerce',
   'Doctor of Philosophy Commerce',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAW',
   'Doctor of Philosophy HealthEntrepreneurship',
   'Doctor of Philosophy HealthEntrepreneurship',
   'Doctor of Philosophy HealthEntrepreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAH',
   'Doctor of Philosophy Hospitality',
   'Doctor of Philosophy Hospitality',
   'Doctor of Philosophy Hospitality',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PAP',
   'Doctor of Philosophy Tourism',
   'Doctor of Philosophy Tourism',
   'Doctor of Philosophy Tourism',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-PHD-PMS',
   'Doctor of Philosophy Mathematical Science',
   'Doctor of Philosophy Mathematical Science',
   'Doctor of Philosophy Mathematical Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAM',
   'Master of Entrepreneurship Management',
   'Master of Entrepreneurship Management',
   'Master of Entrepreneurship Management',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAF',
   'Master of Entrepreneurship Finance',
   'Master of Entrepreneurship Finance',
   'Master of Entrepreneurship Finance',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAA',
   'Master of Entrepreneurship Accounting',
   'Master of Entrepreneurship Accounting',
   'Master of Entrepreneurship Accounting',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAR',
   'Master of Entrepreneurship Retailing',
   'Master of Entrepreneurship Retailing',
   'Master of Entrepreneurship Retailing',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAK',
   'Master of Entrepreneurship Commerce',
   'Master of Entrepreneurship Commerce',
   'Master of Entrepreneurship Commerce',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAW',
   'Master of Entrepreneurship HealthEntrepreneurship',
   'Master of Entrepreneurship HealthEntrepreneurship',
   'Master of Entrepreneurship HealthEntrepreneurship',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAH',
   'Master of Entrepreneurship Hospitality',
   'Master of Entrepreneurship Hospitality',
   'Master of Entrepreneurship Hospitality',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MAP',
   'Master of Entrepreneurship Tourism',
   'Master of Entrepreneurship Tourism',
   'Master of Entrepreneurship Tourism',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'FKP-MASTER-MMS',
   'Master of Entrepreneurship Mathematical Science',
   'Master of Entrepreneurship Mathematical Science',
   'Master of Entrepreneurship Mathematical Science',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'FKP'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'MGSEB-MBA',
   'Master of Business Administration',
   'Master of Business Administration',
   'Master of Business Administration',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'MASTER'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'MGSEB'), CURRENT_TIMESTAMP, 0, 1);
INSERT INTO AD_PRGM (ID, CODE, TITLE, TITLE_EN, TITLE_MS, LEVEL_ID, FACULTY_ID, C_TS, C_ID, M_ST)    VALUES (nextval('SQ_AD_PRGM'),    'MGSEB-DBA',
   'Doctorate of Business Administration',
   'Doctorate of Business Administration',
   'Doctorate of Business Administration',
   (SELECT ID
    FROM AD_PRGM_LEVL PL
    WHERE PL.CODE = 'PHD'),
   (SELECT ID
    FROM AD_FCTY F
    WHERE F.NAME = 'MGSEB'), CURRENT_TIMESTAMP, 0, 1);

 
