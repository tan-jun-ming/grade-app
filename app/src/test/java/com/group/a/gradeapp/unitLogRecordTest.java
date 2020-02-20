package com.group.a.gradeapp;

import com.group.a.gradeapp.DB.LogRecord;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class unitLogRecordTest {

    @Test
    public void createLogRecord(){
        LogRecord logRecord = new LogRecord();
        assertNotNull(logRecord);
    }

    @Test
    public void setLogRecord(){
        LogRecord logRecord = new LogRecord();
        logRecord.setUserID(8611);
        logRecord.setTime(02);
        logRecord.setTransaction_type("transaction");
        logRecord.setUsername("GroupA");
        logRecord.setDetailed_message("adding record");

        assertTrue(logRecord.getUserID() == 8611 &&
                logRecord.getTime() == 02 &&
                logRecord.getTransaction_type() == "transaction" &&
                logRecord.getUsername() == "GroupA" &&
                logRecord.getDetailed_message() == "adding record");
    }
}
