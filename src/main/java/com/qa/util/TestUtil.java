package com.qa.util;

import com.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.seleniumhq.jetty9.util.IO;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 60;
    public static long IMPLICIT_WAIT = 30;
    private static IO FileUtils;


    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}

