package com.jUnit.seleniumTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CorrectWriteEmail_Test.class
        ,EmailDuplicate_Test.class,ObligatoryField_Test.class,PasswordLong_Test.class, RegisterPage_Test.class})
public class SocialSkinTestJunit {




}
