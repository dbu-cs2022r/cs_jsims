--------------------------------------------------------
--  File created - Wednesday-April-09-2025   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence COLLEGE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "JSIMS"."COLLEGE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence DEPARTMENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "JSIMS"."DEPARTMENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence FIELDOFSTUDY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "JSIMS"."FIELDOFSTUDY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table COLLEGE
--------------------------------------------------------

  CREATE TABLE "JSIMS"."COLLEGE" 
   (	"ID" NUMBER, 
	"NAME" NVARCHAR2(500)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table DEPARTMENT
--------------------------------------------------------

  CREATE TABLE "JSIMS"."DEPARTMENT" 
   (	"ID" NUMBER, 
	"NAME" NVARCHAR2(200), 
	"COLLEGEID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FIELDOFSTUDY
--------------------------------------------------------

  CREATE TABLE "JSIMS"."FIELDOFSTUDY" 
   (	"ID" NUMBER, 
	"NAME" NVARCHAR2(200), 
	"DEPARTMENTID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into JSIMS.COLLEGE
SET DEFINE OFF;
Insert into JSIMS.COLLEGE (ID,NAME) values (1,'College of Social Science');
Insert into JSIMS.COLLEGE (ID,NAME) values (2,'College of Computing');
Insert into JSIMS.COLLEGE (ID,NAME) values (3,'College of Engineering');
Insert into JSIMS.COLLEGE (ID,NAME) values (4,'College of Natural Science');
Insert into JSIMS.COLLEGE (ID,NAME) values (5,'College of Business and Economics');
Insert into JSIMS.COLLEGE (ID,NAME) values (21,'College of Agriculture');
REM INSERTING into JSIMS.DEPARTMENT
SET DEFINE OFF;
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (1,'Geography',1);
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (4,'English Language',1);
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (2,'History',1);
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (21,'Accounting and Finance',5);
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (22,'Computer Science',2);
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (23,'Information Technology',2);
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (24,'Software Engineering',2);
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (41,'Animal Science',21);
Insert into JSIMS.DEPARTMENT (ID,NAME,COLLEGEID) values (61,'Electirical Engineering',3);
REM INSERTING into JSIMS.FIELDOFSTUDY
SET DEFINE OFF;
Insert into JSIMS.FIELDOFSTUDY (ID,NAME,DEPARTMENTID) values (1,'cs',1);
Insert into JSIMS.FIELDOFSTUDY (ID,NAME,DEPARTMENTID) values (3,'it',4);
--------------------------------------------------------
--  DDL for Index COLLEGE_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "JSIMS"."COLLEGE_UK1" ON "JSIMS"."COLLEGE" ("NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index COLLEGE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JSIMS"."COLLEGE_PK" ON "JSIMS"."COLLEGE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index DEPARTMENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JSIMS"."DEPARTMENT_PK" ON "JSIMS"."DEPARTMENT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index DEPARTMENT_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "JSIMS"."DEPARTMENT_UK1" ON "JSIMS"."DEPARTMENT" ("NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index FIELDOFSTUDY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "JSIMS"."FIELDOFSTUDY_PK" ON "JSIMS"."FIELDOFSTUDY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger COLLEGE_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "JSIMS"."COLLEGE_TRG" 
BEFORE INSERT ON COLLEGE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT COLLEGE_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "JSIMS"."COLLEGE_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger DEPARTMENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "JSIMS"."DEPARTMENT_TRG" 
BEFORE INSERT ON DEPARTMENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT DEPARTMENT_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "JSIMS"."DEPARTMENT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger FIELDOFSTUDY_TRG
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "JSIMS"."FIELDOFSTUDY_TRG" 
BEFORE INSERT ON FIELDOFSTUDY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT FIELDOFSTUDY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "JSIMS"."FIELDOFSTUDY_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table FIELDOFSTUDY
--------------------------------------------------------

  ALTER TABLE "JSIMS"."FIELDOFSTUDY" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "JSIMS"."FIELDOFSTUDY" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "JSIMS"."FIELDOFSTUDY" MODIFY ("DEPARTMENTID" NOT NULL ENABLE);
  ALTER TABLE "JSIMS"."FIELDOFSTUDY" ADD CONSTRAINT "FIELDOFSTUDY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table COLLEGE
--------------------------------------------------------

  ALTER TABLE "JSIMS"."COLLEGE" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "JSIMS"."COLLEGE" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "JSIMS"."COLLEGE" ADD CONSTRAINT "COLLEGE_UK1" UNIQUE ("NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "JSIMS"."COLLEGE" ADD CONSTRAINT "COLLEGE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table DEPARTMENT
--------------------------------------------------------

  ALTER TABLE "JSIMS"."DEPARTMENT" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "JSIMS"."DEPARTMENT" MODIFY ("COLLEGEID" NOT NULL ENABLE);
  ALTER TABLE "JSIMS"."DEPARTMENT" ADD CONSTRAINT "DEPARTMENT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "JSIMS"."DEPARTMENT" ADD CONSTRAINT "DEPARTMENT_UK1" UNIQUE ("NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DEPARTMENT
--------------------------------------------------------

  ALTER TABLE "JSIMS"."DEPARTMENT" ADD CONSTRAINT "DEPARTMENT_FK1" FOREIGN KEY ("COLLEGEID")
	  REFERENCES "JSIMS"."COLLEGE" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table FIELDOFSTUDY
--------------------------------------------------------

  ALTER TABLE "JSIMS"."FIELDOFSTUDY" ADD CONSTRAINT "FIELDOFSTUDY_FK1" FOREIGN KEY ("DEPARTMENTID")
	  REFERENCES "JSIMS"."DEPARTMENT" ("ID") ENABLE;
