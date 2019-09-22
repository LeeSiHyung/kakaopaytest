CREATE TABLE DEVICE (
       DEVICE_ID                VARCHAR(50) PRIMARY KEY,
       DEVICE_NAME              VARCHAR(255) NOT NULL
);

CREATE TABLE BANKING (
       ID                       INT AUTO_INCREMENT PRIMARY KEY,
       YEAR                     VARCHAR(4) NOT NULL,
       DEVICE_ID                VARCHAR(50) NOT NULL,
       RATE                     DECIMAL(3, 1),
       foreign key (DEVICE_ID) references DEVICE(DEVICE_ID)
);

