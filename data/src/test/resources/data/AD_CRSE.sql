INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5013', 'Economics & Business Environment', 'Ekonomi & Persekitaran Perniagaan',
                               'Economics & Business Environment', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5023', 'Organizational Design', 'Design Organisasi', 'Organizational Design', 3, 1,
                               1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5033', 'Financial Reporting & Control', 'Laporan Kewangan & Kawalan',
                               'Financial Reporting & Control', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5043', 'Operations Analysis',
                               'Analisis Operasi', 'Operations Analysis', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5053', 'Human Resource Management',
                               'Pengurusan Sumber Manusia', 'Human Resource Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5063', 'Financial Management',
                               'Pengurusan kewangan', 'Financial Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5073', 'Marketing Management',
                               'Pengurusan pemasaran', 'Marketing Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5083', 'Information Systems & Electronic Commerce',
                               'Sistem Maklumat & Perdagangan elektronik', 'Information Systems & Electronic Commerce',
                               3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5093', 'Business Law', 'Undang-undang perniagaan', 'Business Law', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5103', 'Strategic Management', 'Pengurusan strategik', 'Strategic Management', 3, 1,
                               1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GSK6153', 'Launching Global New Business Ventures',
                               'Melancarkan Ventures Perniagaan Global Baharu',
                               'Launching Global New Business Ventures', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GSK6163', 'Managing Entrepreneurial Thought & Action',
                               'Urusan Keusahawanan Pemikiran Tindakan', 'Managing Entrepreneurial Thought & Action', 3,
                               1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GSK6173', 'Enterprise Competitive Positioning Strategy',
                               'Enterprise kompetitif Strategi Positioning',
                               'Enterprise Competitive Positioning Strategy', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GSE6013', 'Social Entrepreneurship', 'Keusahawanan sosial',
                               'Social Entrepreneurship', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5113', 'Business Research Methodology', '
								Kaedah Penyelidikan Perniagaan', 'Business Research Methodology', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'GST5123', 'Project Paper', 'Kertas projek', 'Project Paper', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module1 ', 'Sustainability & Environmental Economics',
                               'Kelestarian & Ekonomi Alam Sekitar', 'Sustainability & Environmental Economics', 3, 1,
                               1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module2 ', 'Seminar in Accounting & Control ', 'Seminar Perakaunan & Kawalan',
                               'Seminar in Accounting & Control ', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module3 ', 'Advanced Financial Decision', 'Keputusan Kewangan Lanjutan',
                               'Advanced Financial Decision', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module4 ', 'Advanced Marketing Strategy', 'Strategi Pemasaran Lanjutan',
                               'Advanced Marketing Strategy', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module5 ', 'Seminar In Human Resource Management',
                               'Seminar Pengurusan Sumber Manusia', 'Seminar In Human Resource Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module6 ', 'Seminar in Strategic Management',
                               'Seminar Pengurusan Strategik', 'Seminar in Strategic Management', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module7', 'Consultancy & Training ( Part 1)', 'Perundingan dan Latihan (Bahagian 1)',
                               'Consultancy & Training ( Part 1)', 7, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module8', 'Consultancy & Training ( Part 2)', 'Perundingan dan Latihan (Bahagian 1)',
                               'Consultancy & Training ( Part 2)', 8, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module9', 'Seminar in Entrepreneurial Leadership',
                               'Seminar Kepimpinan Keusahawanan', 'Seminar in Entrepreneurial Leadership', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module10', 'Advanced Business Statistics', 'Statistik Perniagaan Lanjutan',
                               'Advanced Business Statistics', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'DBA/YEAR2/SEMESTER4/Module11',
                               'Seminar Advanced Research Methodology / Case Methodology',
                               'Seminar lanjutan Metodologi Penyelidikan/Kaedah kes',
                               'Seminar Advanced Research Methodology / Case Methodology', 3, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'DBA/YEAR2/SEMESTER4/Module12', 'Dissertation ( Part 1)', 'Disertasi (Bahagian 1)',
                               'Dissertation ( Part 1)', 10, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module13', 'Dissertation ( Part 2)', 'Disertasi (Bahagian 2)', 'Dissertation ( Part 2)',
                               15, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A10'),
                               'Module14', 'Dissertation ( Part 3)', 'Disertasi (Bahagian 3)', 'Dissertation ( Part 3)',
                               15, 1, 1, 0,
                               CURRENT_TIMESTAMP);

-- MOVE TO AD_PRGM.csv/sql


INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A01'),
                               'MAM', 'Management', 'Pengurusan', 'Management', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAM', 'Management', 'Pengurusan', 'Management', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAF', 'Finance', 'Kewangan', 'Finance', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAF', 'Finance', 'Kewangan', 'Finance', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAA', 'Accounting', 'Perakaunan', 'Accounting', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAA', 'Accounting', 'Perakaunan', 'Accounting', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAR', 'Retail', 'Peruncitan', 'Retail', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAR', 'Retail', 'Peruncitan', 'Retail', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAK', 'Commerce', 'Perdagangan', 'Commerce', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAK', 'Commerce', 'Perdagangan', 'Commerce', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAW', 'Health Entrepreneurship', 'Keusahawan Kesihatan', 'Health Entrepreneurship', 50,
                               1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAW', 'Health Entrepreneurship', 'Keusahawan Kesihatan', 'Health Entrepreneurship', 50,
                               1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAH', 'Hospitality', 'Hospitaliti', 'Hospitality', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAH', 'Hospitality', 'Hospitaliti', 'Hospitality', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'MAP', 'Tourism', 'Pelancongan', 'Tourism', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'CPS'),
                               'PAP', 'Tourism', 'Pelancongan', 'Tourism', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MBG', 'GEOSCIENCE', 'GEOSAINS', 'GEOSCIENCE', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PBG', 'GEOSCIENCE', 'GEOSAINS', 'GEOSCIENCE', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MBN', 'NATURAL RESOURCES MANAGEMENT', 'PENGURUSAN SUMBER ASLI',
                               'NATURAL RESOURCES MANAGEMENT', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PBN', 'NATURAL RESOURCES MANAGEMENT', 'PENGURUSAN SUMBER ASLI',
                               'NATURAL RESOURCES MANAGEMENT', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MBK', 'SUSTAINABLE SCIENCE', 'SAINS KELESTARIAN', 'SUSTAINABLE SCIENCE', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PBK', 'SUSTAINABLE SCIENCE', 'SAINS KELESTARIAN', 'SUSTAINABLE SCIENCE', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MFB', 'MATERIAL TECHNOLOGY', 'TEKNOLOGI BAHAN', 'MATERIAL TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PFB', 'MATERIAL TECHNOLOGY', 'TEKNOLOGI BAHAN', 'MATERIAL TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MFS', 'FOREST RESOURCES TECHNOLOGY', 'TEKNOLOGI SUMBER HUTAN',
                               'FOREST RESOURCES TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PFS', 'FOREST RESOURCES TECHNOLOGY', 'TEKNOLOGI SUMBER HUTAN',
                               'FOREST RESOURCES TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'MFT', 'ENERGY TECHNOLOGY', 'TEKNOLOGI TENAGA', 'ENERGY TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A08'),
                               'PFT', 'ENERGY TECHNOLOGY', 'TEKNOLOGI TENAGA', 'ENERGY TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);


INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCW', 'HERITAGE STUDIES', 'PENGAJIAN WARISAN', 'HERITAGE STUDIES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCW', 'HERITAGE STUDIES', 'PENGAJIAN WARISAN', 'HERITAGE STUDIES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCT', 'TEXTILE AND FASHION', 'TEKSTIL DAN FESYEN', 'TEXTILE AND FASHION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCT', 'TEXTILE AND FASHION', 'TEKSTIL DAN FESYEN', 'TEXTILE AND FASHION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCP', 'PRODUCT DESIGN', 'REKABENTUK PRODUK', 'PRODUCT DESIGN', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCP', 'PRODUCT DESIGN', 'REKABENTUK PRODUK', 'PRODUCT DESIGN', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCM', 'MULTIMEDIA', 'MULTIMEDIA', 'MULTIMEDIA', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCM', 'MULTIMEDIA', 'MULTIMEDIA', 'MULTIMEDIA', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'MCV', 'VISUAL COMMUNICATION', 'KOMUNIKASI VISUAL', 'VISUAL COMMUNICATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A02'),
                               'PCV', 'VISUAL COMMUNICATION', 'KOMUNIKASI VISUAL', 'VISUAL COMMUNICATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBT', 'BIO-INDUSTRIAL TECHNOLOGY', 'TEKNOLOGI BIOINDUSTRI', 'BIO-INDUSTRIAL TECHNOLOGY',
                               50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBT', 'BIO-INDUSTRIAL TECHNOLOGY', 'TEKNOLOGI BIOINDUSTRI', 'BIO-INDUSTRIAL TECHNOLOGY',
                               50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBS', 'AGRO TECHNOPRENEURSHIP', 'KEUSAHAWANAN TEKNOLOGI PERTANIAN',
                               'AGRO TECHNOPRENEURSHIP', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBS', 'AGRO TECHNOPRENEURSHIP', 'KEUSAHAWANAN TEKNOLOGI PERTANIAN',
                               'AGRO TECHNOPRENEURSHIP', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBB', 'AGRICULTURE TECHNOLOGY', 'BIOTEKNOLOGI PERTANIAN', 'AGRICULTURE TECHNOLOGY', 50,
                               1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBB', 'AGRICULTURE TECHNOLOGY', 'BIOTEKNOLOGI PERTANIAN', 'AGRICULTURE TECHNOLOGY', 50,
                               1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBP', 'PRODUCT DEVELOPMENT TECHNOLOGY', 'TEKNOLOGI PEMBANGUNAN PRODUK',
                               'PRODUCT DEVELOPMENT TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBP', 'PRODUCT DEVELOPMENT TECHNOLOGY', 'TEKNOLOGI PEMBANGUNAN PRODUK',
                               'PRODUCT DEVELOPMENT TECHNOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBH', 'ANIMAL HUSBANDARY', 'SAINS PETERNAKAN', 'ANIMAL HUSBANDARY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBH', 'ANIMAL HUSBANDARY', 'SAINS PETERNAKAN', 'ANIMAL HUSBANDARY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'MBA', 'AKUAKULTUR', 'AKUAKULTUR', 'AKUAKULTUR', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A07'),
                               'PBA', 'AKUAKULTUR', 'AKUAKULTUR', 'AKUAKULTUR', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDP', 'PATALOGY', 'PATALOGI', 'PATALOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDP', 'PATALOGY', 'PATALOGI', 'PATALOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDN', 'NUTRITION', 'NUTRISI', 'NUTRITION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDN', 'NUTRITION', 'NUTRISI', 'NUTRITION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDA', 'ANATOMY', 'ANATOMI', 'ANATOMY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDA', 'ANATOMY', 'ANATOMI', 'ANATOMY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDM', 'MICROBIOLOGY', 'MIKROBIOLOGI', 'MICROBIOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDM', 'MICROBIOLOGY', 'MIKROBIOLOGI', 'MICROBIOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDR', 'PARASITOLOGY', 'PARASITOLOGI', 'PARASITOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDR', 'PARASITOLOGY', 'PARASITOLOGI', 'PARASITOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'MDF', 'PHYSIOLOGY', 'FISIOLOGI', 'PHYSIOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A06'),
                               'PDF', 'PHYSIOLOGY', 'FISIOLOGI', 'PHYSIOLOGY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCS', 'STUDIES OF HISTORY AND CIVILISATION', 'PENGAJIAN SEJARAH DAN PERADABAN',
                               'STUDIES OF HISTORY AND CIVILISATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCS', 'STUDIES OF HISTORY AND CIVILISATION', 'PENGAJIAN SEJARAH DAN PERADABAN',
                               'STUDIES OF HISTORY AND CIVILISATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCN', 'DEVELOPMENT AND EDUCATIONAL VALUES', 'PEMBANGUNAN DAN PENDIDIKAN NILAI',
                               'DEVELOPMENT AND EDUCATIONAL VALUES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCN', 'DEVELOPMENT AND EDUCATIONAL VALUES', 'PEMBANGUNAN DAN PENDIDIKAN NILAI',
                               'DEVELOPMENT AND EDUCATIONAL VALUES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCO', 'INDUSTRIAL PSYCOLOGICAL ORGANIZATIONAL', 'PSIKOLOGI INDUSTRI ORGANISASI',
                               'INDUSTRIAL PSYCOLOGICAL ORGANIZATIONAL', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCO', 'INDUSTRIAL PSYCOLOGICAL ORGANIZATIONAL', 'PSIKOLOGI INDUSTRI ORGANISASI',
                               'INDUSTRIAL PSYCOLOGICAL ORGANIZATIONAL', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCA', 'RELIGION AND CONTEMPORARY', 'AGAMA DAN KONTEMPORARI',
                               'RELIGION AND CONTEMPORARY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCA', 'RELIGION AND CONTEMPORARY', 'AGAMA DAN KONTEMPORARI',
                               'RELIGION AND CONTEMPORARY', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCK', 'SOCIAL WORK', 'KERJA SOSIAL', 'SOCIAL WORK', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCK', 'SOCIAL WORK', 'KERJA SOSIAL', 'SOCIAL WORK', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCB', 'LANGUAGE STUDIES', 'PENGAJIAN BAHASA', 'LANGUAGE STUDIES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCB', 'LANGUAGE STUDIES', 'PENGAJIAN BAHASA', 'LANGUAGE STUDIES', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);


INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'MCC', 'COMMUNICATION', 'KOMUNIKASI', 'COMMUNICATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);

INSERT INTO AD_CRSE (ID, FACULTY_ID, CODE, TITLE, TITLE_MS, TITLE_EN, CREDIT, CLASSIFICATION, M_ST, C_ID, C_TS)
VALUES (nextval('SQ_AD_CRSE'), (SELECT ID
                                FROM AD_FCTY F
                                WHERE F.CODE = 'A04'),
                               'PCC', 'COMMUNICATION', 'KOMUNIKASI', 'COMMUNICATION', 50, 1, 1, 0,
                               CURRENT_TIMESTAMP);								   
                          							   
                          
						  
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
                          
