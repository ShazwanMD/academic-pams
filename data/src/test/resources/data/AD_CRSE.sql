INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5013', 'Ekonomi & Persekitaran Perniagaan',
                               'Economics & Business Environment', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5023', 'Design Organisasi', 'Organizational Design', 3, 1,
                               1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5033', 'Laporan Kewangan & Kawalan',
                               'Financial Reporting & Control', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5043',
                               'Analisis Operasi', 'Operations Analysis', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5053',
                               'Pengurusan Sumber Manusia', 'Human Resource Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5063',
                               'Pengurusan kewangan', 'Financial Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5073',
                               'Pengurusan pemasaran', 'Marketing Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5083',
                               'Sistem Maklumat & Perdagangan elektronik', 'Information Systems & Electronic Commerce',
                               3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5093',
                               'Undang-undang perniagaan', 'Business Law', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5103',
                               'Pengurusan strategik', 'Strategic Management', 3, 1,
                               1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GSK6153',
                               'Melancarkan Ventures Perniagaan Global Baharu',
                               'Launching Global New Business Ventures', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GSK6163',
                               'Urusan Keusahawanan Pemikiran Tindakan', 'Managing Entrepreneurial Thought & Action', 3,
                               1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GSK6173',
                               'Enterprise kompetitif Strategi Positioning',
                               'Enterprise Competitive Positioning Strategy', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GSE6013',
                               'Keusahawanan sosial',
                               'Social Entrepreneurship', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5113',
                               'Kaedah Penyelidikan Perniagaan', 'Business Research Methodology', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5123',
                               'Kertas projek', 'Project Paper', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module1',
                               'Kelestarian & Ekonomi Alam Sekitar', 'Sustainability & Environmental Economics', 3, 1,
                               1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module2',
                               'Seminar Perakaunan & Kawalan',
                               'Seminar in Accounting & Control', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module3',
                                'Keputusan Kewangan Lanjutan',
                               'Advanced Financial Decision', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module4',
                                'Strategi Pemasaran Lanjutan',
                               'Advanced Marketing Strategy', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module5',
                               'Seminar Pengurusan Sumber Manusia', 'Seminar In Human Resource Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module6',
                               'Seminar Pengurusan Strategik', 'Seminar in Strategic Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module7',
                               'Perundingan dan Latihan (Bahagian 1)',
                               'Consultancy & Training ( Part 1)', 7, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module8',
                               'Perundingan dan Latihan (Bahagian 1)',
                               'Consultancy & Training ( Part 2)', 8, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module9',
                               'Seminar Kepimpinan Keusahawanan', 'Seminar in Entrepreneurial Leadership', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module10',
                                 'Statistik Perniagaan Lanjutan',
                               'Advanced Business Statistics', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'DBA-YEAR2-SEMESTER4-Module11',
                               'Seminar lanjutan Metodologi Penyelidikan/Kaedah kes',
                               'Seminar Advanced Research Methodology / Case Methodology', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'DBA-YEAR2-SEMESTER4-Module12',
                               'Disertasi (Bahagian 1)',
                               'Dissertation ( Part 1)', 10, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module13',
                               'Disertasi (Bahagian 2)', 'Dissertation ( Part 2)',
                               15, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module14',
                               'Disertasi (Bahagian 3)', 'Dissertation ( Part 3)',
                               15, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

-- MOVE TO AD_PRGM.csv/sql


INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A01'),
                               'MAM',
                               'Pengurusan', 'Management', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAM',
                                'Pengurusan', 'Management', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAF',
                                'Kewangan', 'Finance', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAF',
                               'Kewangan', 'Finance', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAA',
                               'Perakaunan', 'Accounting', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAA',
                               'Perakaunan', 'Accounting', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAR',
                               'Peruncitan', 'Retail', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAR',
                               'Peruncitan', 'Retail', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAK',
                               'Perdagangan', 'Commerce', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAK',
                               'Perdagangan', 'Commerce', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAW',
                               'Keusahawan Kesihatan', 'Health Entrepreneurship', 50,
                               1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAW',
                               'Keusahawan Kesihatan', 'Health Entrepreneurship', 50,
                               1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAH',
                               'Hospitaliti', 'Hospitality', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAH',
                               'Hospitaliti', 'Hospitality', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAP',
                               'Pelancongan', 'Tourism', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAP',
                               'Pelancongan', 'Tourism', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MBG',
                               'GEOSAINS', 'GEOSCIENCE', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PBG',
                               'GEOSAINS', 'GEOSCIENCE', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MBN',
                               'PENGURUSAN SUMBER ASLI',
                               'NATURAL RESOURCES MANAGEMENT', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PBN',
                               'PENGURUSAN SUMBER ASLI',
                               'NATURAL RESOURCES MANAGEMENT', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MBK',
                               'SAINS KELESTARIAN', 'SUSTAINABLE SCIENCE', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PBK',
                               'SAINS KELESTARIAN', 'SUSTAINABLE SCIENCE', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MFB',
                               'TEKNOLOGI BAHAN', 'MATERIAL TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PFB',
                               'TEKNOLOGI BAHAN', 'MATERIAL TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MFS',
                               'TEKNOLOGI SUMBER HUTAN',
                               'FOREST RESOURCES TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PFS',
                               'TEKNOLOGI SUMBER HUTAN',
                               'FOREST RESOURCES TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MFT',
                               'TEKNOLOGI TENAGA', 'ENERGY TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PFT',
                               'TEKNOLOGI TENAGA', 'ENERGY TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);


INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCW',
                               'PENGAJIAN WARISAN', 'HERITAGE STUDIES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCW',
                               'PENGAJIAN WARISAN', 'HERITAGE STUDIES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCT',
                               'TEKSTIL DAN FESYEN', 'TEXTILE AND FASHION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCT',
                               'TEKSTIL DAN FESYEN', 'TEXTILE AND FASHION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCP',
                               'REKABENTUK PRODUK', 'PRODUCT DESIGN', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCP',
                               'REKABENTUK PRODUK', 'PRODUCT DESIGN', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCM',
                               'MULTIMEDIA', 'MULTIMEDIA', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCM',
                               'MULTIMEDIA', 'MULTIMEDIA', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCV',
                               'KOMUNIKASI VISUAL', 'VISUAL COMMUNICATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCV',
                               'KOMUNIKASI VISUAL', 'VISUAL COMMUNICATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBT',
                               'TEKNOLOGI BIOINDUSTRI', 'BIO-INDUSTRIAL TECHNOLOGY',
                               50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBT',
                               'TEKNOLOGI BIOINDUSTRI', 'BIO-INDUSTRIAL TECHNOLOGY',
                               50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBS',
                               'KEUSAHAWANAN TEKNOLOGI PERTANIAN',
                               'AGRO TECHNOPRENEURSHIP', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBS',
                               'KEUSAHAWANAN TEKNOLOGI PERTANIAN',
                               'AGRO TECHNOPRENEURSHIP', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBB',
                               'BIOTEKNOLOGI PERTANIAN', 'AGRICULTURE TECHNOLOGY', 50,
                               1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBB',
                               'BIOTEKNOLOGI PERTANIAN', 'AGRICULTURE TECHNOLOGY', 50,
                               1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBP',
                                'TEKNOLOGI PEMBANGUNAN PRODUK',
                               'PRODUCT DEVELOPMENT TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBP',
                               'TEKNOLOGI PEMBANGUNAN PRODUK',
                               'PRODUCT DEVELOPMENT TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBH',
                               'SAINS PETERNAKAN', 'ANIMAL HUSBANDARY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBH',
                               'SAINS PETERNAKAN', 'ANIMAL HUSBANDARY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBA',
                               'AKUAKULTUR', 'AKUAKULTUR', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBA',
                               'AKUAKULTUR', 'AKUAKULTUR', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDP',
                               'PATALOGI', 'PATALOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDP',
                               'PATALOGI', 'PATALOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDN',
                               'NUTRISI', 'NUTRITION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDN',
                               'NUTRISI', 'NUTRITION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDA',
                               'ANATOMI', 'ANATOMY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDA',
                               'ANATOMI', 'ANATOMY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDM',
                               'MIKROBIOLOGI', 'MICROBIOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDM',
                               'MIKROBIOLOGI', 'MICROBIOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDR',
                               'PARASITOLOGI', 'PARASITOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDR',
                               'PARASITOLOGI', 'PARASITOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDF',
                               'FISIOLOGI', 'PHYSIOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDF',
                               'FISIOLOGI', 'PHYSIOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCS',
                               'PENGAJIAN SEJARAH DAN PERADABAN',
                               'STUDIES OF HISTORY AND CIVILISATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCS',
                               'PENGAJIAN SEJARAH DAN PERADABAN',
                               'STUDIES OF HISTORY AND CIVILISATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCN',
                               'PEMBANGUNAN DAN PENDIDIKAN NILAI',
                               'DEVELOPMENT AND EDUCATIONAL VALUES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCN',
                               'PEMBANGUNAN DAN PENDIDIKAN NILAI',
                               'DEVELOPMENT AND EDUCATIONAL VALUES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCO',
                               'PSIKOLOGI INDUSTRI ORGANISASI',
                               'INDUSTRIAL PSYCOLOGICAL ORGANIZATIONAL', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCO',
                                'PSIKOLOGI INDUSTRI ORGANISASI',
                               'INDUSTRIAL PSYCOLOGICAL ORGANIZATIONAL', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCA',
                                'AGAMA DAN KONTEMPORARI',
                               'RELIGION AND CONTEMPORARY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCA',
                               'AGAMA DAN KONTEMPORARI',
                               'RELIGION AND CONTEMPORARY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCK',
                               'KERJA SOSIAL', 'SOCIAL WORK', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCK',
                               'KERJA SOSIAL', 'SOCIAL WORK', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCB',
                               'PENGAJIAN BAHASA', 'LANGUAGE STUDIES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCB',
                                'PENGAJIAN BAHASA', 'LANGUAGE STUDIES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);


INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCC',
                               'KOMUNIKASI', 'COMMUNICATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS, STATUS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCC',
                               'KOMUNIKASI', 'COMMUNICATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP, 1);								   
                          							   
                          
						  
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
