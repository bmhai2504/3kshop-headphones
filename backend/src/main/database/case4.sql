CREATE DATABASE CASE4;

USE CASE4;

CREATE TABLE CATEGORY
(
    ID   BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL
);

CREATE TABLE BRAND
(
    ID    BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME  VARCHAR(100) NOT NULL,
    IMAGE VARCHAR(300) NOT NULL
);

CREATE TABLE TYPE
(
    ID          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME        VARCHAR(100) NOT NULL,
    CATEGORY_ID BIGINT       NOT NULL,
    FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID)
);

CREATE TABLE PRODUCTS
(
    ID          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME        VARCHAR(100) NOT NULL,
    PRICE       INT          NOT NULL,
    IMAGE       VARCHAR(300) NOT NULL,
    STATUS      BOOLEAN      NOT NULL DEFAULT TRUE,
    CATEGORY_ID BIGINT       NOT NULL,
    BRAND_ID    BIGINT       NOT NULL,
    TYPE_ID     BIGINT       NOT NULL,
    FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID),
    FOREIGN KEY (BRAND_ID) REFERENCES BRAND (ID),
    FOREIGN KEY (TYPE_ID) REFERENCES TYPE (ID)
);


CREATE TABLE ROLES(
    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    NAME VARCHAR(50) NOT NULL
);

CREATE TABLE USERS(
    ID BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    EMAIL VARCHAR(100) NOT NULL ,
    NAME VARCHAR(100) NOT NULL ,
    PASSWORD VARCHAR(500) NOT NULL ,
    TOKEN VARCHAR(500) NOT NULL ,
    ROLE_ID BIGINT NOT NULL ,
    FOREIGN KEY (ROLE_ID) REFERENCES ROLES (ID)
);

CREATE TABLE CART(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE CART_ITEM(
    ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    QUANTITY INT ,
    SUB_PRICE INT ,
    CART_ID BIGINT,
    PRODUCT_ID BIGINT,
    FOREIGN KEY (CART_ID) REFERENCES CART (ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS (ID)
);


INSERT INTO CATEGORY (NAME)
    VALUE ('HEADPHONE'),
    ('DAC/AMP'),
    ('SPEAKER'),
    ('PHỤ KIỆN');

INSERT INTO TYPE (NAME, CATEGORY_ID)
VALUES ('FULL SIZED', 1),
       ('ON EAR', 1),
       ('EARBUD', 1),
       ('IN EAR', 1),
       ('WIRELESS', 1),
       ('TRUE WIRELESS', 1),
       ('CUSTOM IN EAR', 1),
       ('DESKTOP DAC', 2),
       ('PORTABLE DAC/AMP', 2),
       ('PORTABLE AMPLIFIER', 2),
       ('HEADPHONE AMPLIFIER', 2),
       ('SPEAKERS AMPLIFIER', 2),
       ('TRANSPORT', 2),
       ('PREAMP', 2),
       ('BLUETOOTH RECEIVER', 2),
       ('BLUETOOTH TRANSMITTER', 2),
       ('CONFERENCE SPEAKER', 3),
       ('PORTABLE SPEAKER', 3),
       ('SMART HOME SPEAKER', 3),
       ('COMPUTER SPEAKER', 3),
       ('BOOKSHELF SPEAKER', 3),
       ('HOME THEATER SPEAKER', 3),
       ('SOUNDBARS', 3),
       ('SUBWOOFER', 3),
       ('FLOOR STANDING SPEAKER', 3),
       ('ACTIVE SPEAKER', 3),
       ('WIRELESS SPEAKER', 3),
       ('4.4MM', 4),
       ('WIRELESS', 4),
       ('2-PIN CONNECTOR', 4),
       ('2.5MM CONNECTOR', 4),
       ('3.5MM CONNECTOR', 4),
       ('MMCX CONNECTOR', 4),
       ('BLUETOOTH CABLE', 4),
       ('APPLE LIGHTNING CABLE', 4)
;

INSERT INTO BRAND (NAME, IMAGE)
VALUES ('Apple', 'https://3kshop.vn/wp-content/uploads/2020/06/Apple_logo.jpg'),
       ('Audeze', 'https://3kshop.vn/wp-content/uploads/2018/11/3kshop-audeze-logo.svg'),
       ('Audio Technica', 'https://3kshop.vn/wp-content/uploads/2019/10/audio-technica-logo-3kshop.svg'),
       ('Astell & Kern', 'https://3kshop.vn/wp-content/uploads/2018/11/3kshop-astell-and-kern-logo.svg'),
       ('Beats', 'https://3kshop.vn/wp-content/uploads/2018/11/3kshop-beats-logo.svg'),
       ('Beyerdynamic', 'https://3kshop.vn/wp-content/uploads/2019/10/beyerdynamic-logo-3kshop.svg'),
       ('Campfire Audio', 'https://3kshop.vn/wp-content/uploads/2019/10/campfire-audio-logo-3kshop.svg'),
       ('Fiio', 'https://3kshop.vn/wp-content/uploads/2018/11/3kshop-fiio-logo.svg'),
       ('Focal', 'https://3kshop.vn/wp-content/uploads/2018/11/3kshop-focal-logo.svg'),
       ('JBL', 'https://3kshop.vn/wp-content/uploads/2019/10/jbl-logo-3kshop.svg'),
       ('Hifiman', 'https://3kshop.vn/wp-content/uploads/2018/11/3kshop-hifiman-logo.svg'),
       ('Sennheiser', 'https://3kshop.vn/wp-content/uploads/2019/10/sennheiser-logo-3kshop.svg'),
       ('Shure', 'https://3kshop.vn/wp-content/uploads/2018/11/3kshop-shure-logo.svg'),
       ('Sony', 'https://3kshop.vn/wp-content/uploads/2018/11/3kshop-sony-logo.svg');

INSERT INTO PRODUCTS (NAME, PRICE, IMAGE, CATEGORY_ID, BRAND_ID, TYPE_ID)
VALUES ( 'Tai nghe không dây Apple Airpods Pro 2', 5990000, 'https://tainghe.com.vn/media/product/3529_tai_nghe_apple_airpod_pro_2_xuan_vu_4.jpg', 1, 1, 1),
       ( 'Tai nghe Audeze iSine LX', 7420000, 'https://fitgearshop.vn/files/product/tai-nghe-audeze-isine-lx-5cmqoaiy.jpg', 1, 2, 4),
       ( 'Tai nghe Audio-Technica ATH-CKD3C', 745000, 'https://tainghe.com.vn/media/product/4083_tai_nghe_audio_technica_ath_ckd3c_xuan_vu_audio.jpg', 1, 3, 4),
       ( 'Tai nghe Astell and Kern Layla', 6300000, 'https://tainghe.com.vn/media/product/516_astell_and_kern_layla.gif', 1, 4, 4),
       ( 'Tai nghe Beats Pro', 1340000, 'https://tainghe.com.vn/media/product/4336_tai_nghe_true_wireless_beats_fit_pro_xuan_vu_audio_1.jpg', 1, 5, 4),
       ( 'Tai nghe Beyerdynamic Free BYRD', 3700000, 'https://tainghe.com.vn/media/product/4971_tai_nghe_true_wireless_beyerdynamic_free_byrd_xuan_vu_1.jpg', 1, 6, 4),
       ( 'Tai nghe Campfire Saber', 5200000, 'https://tainghe.com.vn/media/product/4188_tai_nghe_campfire_saber_chinh_hang_3.png', 1, 7, 4),
       ( 'Tai nghe FiiO FH11', 1500000, 'https://tainghe.com.vn/media/product/5659_tai_nghe_fiio_fh11_xuan_vu_audio_3.jpg', 1, 8, 4),
       ( 'Tai nghe Focal Spark', 1700000, 'https://tainghe.com.vn/media/product/1850-xuan-vu-audio-tai-nghe-focal-spark-2.jpg', 1, 9, 4),
       ( 'Tai nghe JBL C200 SIU', 245000, 'https://tainghe.com.vn/media/product/5431_tai_nghe_nhet_tai_jbl_c200_siu_xuan_vu_chinh_hang_4_min.jpg', 1, 10, 4),
       ( 'Tai nghe HiFiMan RE800', 1930000, 'https://tainghe.com.vn/media/product/3324_re800.jpg', 1, 11, 4),
       ( 'Tai nghe Sennheiser IE 200', 4200000, 'https://tainghe.com.vn/media/product/5221_tai_nghe_sennheiser_ie200_xuan_vu_5_min.jpg', 1, 12, 4),
       ( 'Tai nghe Shure SE215', 2500000, 'https://tainghe.com.vn/media/product/641_tai_nghe_shure_se215_special_edition_xuanvuaudio.jpg', 1, 13, 4),
       ( 'Tai nghe Sony IER-M9', 4200000, 'https://tainghe.com.vn/media/product/2005-tai-nghe-sony-ier-m9--2-.jpg', 1, 14, 4)
#        ( '', , '', , , ),
;

INSERT INTO PRODUCTS (NAME, PRICE, IMAGE, CATEGORY_ID, BRAND_ID, TYPE_ID)
VALUES ( 'DAC/AMP Astell & Kern AK XB10', 1000000, 'https://tainghe.com.vn/media/product/2368_ak_xb10_01_2048x2048.jpg', 2, 4, 8),
       ( 'DAC/AMP FiiO K7', 3500000, 'https://3kshop.vn/wp-content/uploads/fly-images/45740/fiio_k7_k55_2-450x450-c.jpg', 2, 8, 8),
       ( 'JBL Charge 5', 3200000, 'https://3kshop.vn/wp-content/uploads/fly-images/46857/ezgif-4-1aea2e1a54-450x450-c.jpg', 3, 10, 18),
       ( 'JBL Clip 4', 1400000, 'https://3kshop.vn/wp-content/uploads/fly-images/37343/22012021160506_32-450x450-c.jpeg', 3, 10, 18),
        ( 'FiiO LC-RE Pro', 2750000, 'https://3kshop.vn/wp-content/uploads/fly-images/38070/3kshop-FiiO-LC-RE-Pro-0-450x450-c.jpg', 4, 8, 28),
        ( 'FiiO LC-RD', 2000000, 'https://3kshop.vn/wp-content/uploads/fly-images/43140/2995_day_dap_fiio_lc_rd_songlongmedia__11_-450x450-c.jpg', 4, 8, 28);

INSERT INTO ROLES (NAME)
VALUES ('ADMIN'),
       ('USER');

INSERT INTO USERS (EMAIL, NAME, PASSWORD, TOKEN, ROLE_ID)
VALUES ('ADMIN@GMAIL.COM', 'ADMIN', '$2a$12$KRicy0qfRP.YbYM2Mapz9Oyp5u2nBQXGL4yj5J401jRLF4uTt4awa', 'ADMIN', 1);

ALTER TABLE USERS MODIFY TOKEN VARCHAR(500) DEFAULT 'TOKEN';

ALTER TABLE USERS ADD COLUMN CART_ID BIGINT;

ALTER TABLE USERS
ADD FOREIGN KEY (CART_ID) REFERENCES CART(ID);

ALTER TABLE CART_ITEM ADD COLUMN STATUS BOOLEAN DEFAULT TRUE;

INSERT INTO PRODUCTS (NAME, PRICE, IMAGE, CATEGORY_ID, BRAND_ID, TYPE_ID)
VALUES ( 'DAC/AMP Astell & Kern AK XB10', 1000000, 'https://tainghe.com.vn/media/product/2368_ak_xb10_01_2048x2048.jpg', 2, 4, 8),
       ( 'DAC/AMP FiiO K7', 3500000, 'https://3kshop.vn/wp-content/uploads/fly-images/45740/fiio_k7_k55_2-450x450-c.jpg', 2, 8, 8);

;