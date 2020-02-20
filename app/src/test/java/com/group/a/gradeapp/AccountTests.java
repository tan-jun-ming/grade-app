//package com.group.a.gradeapp;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//
//import androidx.room.Room;
//import com.group.a.gradeapp.DB.AppDatabase;
//import com.group.a.gradeapp.DB.UserDAO;
//
//import java.io.IOException;
//import android.content.Context;
//
//import static org.junit.Assert.*;
//
///**
// * Example local unit test, which will execute on the development machine (host).
// *
// * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
// */
//public class AccountTests {
//
//    @RunWith(JUnit4.class)
//    public class SimpleEntityReadWriteTest {
//        private UserDAO userDao;
//        private AppDatabase db;
//
//        //want to check database by entering a user and checking
//
//        @Before
//        public void createDb() {
//            Context context = ApplicationProvider.getApplicationContext();
//            db = Room.inMemoryDatabaseBuilder(context, TestDatabase.class).build();
//            userDao = db.getUserDao();
//        }
//
//        @After
//        public void closeDb() throws IOException {
//            db.close();
////        }
//
//        @Test
//        public void create_account() throws Exception {
//            CreateAccountActivity createaccount = new CreateAccountActivity();
//            createaccount.create("Chester Mc Bad Bad");
//
//        }
//    }
//
////        @Test
////    public void create_account() throws Exception {
////        CreateAccountActivity createaccount = new CreateAccountActivity();
////        assertTrue(createaccount.("abalabahaha", "abalabahaha", "abala", "bahaha");
////    }
//}
//
