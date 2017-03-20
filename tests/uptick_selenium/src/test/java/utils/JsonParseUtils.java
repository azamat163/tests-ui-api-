package utils;


import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by azamat on 10.02.17.
*/
public class JsonParseUtils {

    private static String chromedriverOS;
    private static String chromedriverWIN;
    private static String chromedriverUnix;
    private static File file;
    private static String path_screenshot_pass;
    private static String path_screenshot_err;
    private static String baseUrl;
    private static String localhost;
    private static int port;
    private static String login;
    private static String password;
    private static String login_teacher;
    private static String password_teacher;

    public void jsonParseUtils() {
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        try {
            Object objSys = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/main/resources/SystemConfig.json"));
            Object objBus = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/main/resources/BusinessConfig.json"));
            JSONObject jsonObject = (JSONObject) objSys;
            JSONObject jsonObject1 = (JSONObject) objBus;
            chromedriverOS = (String) jsonObject.get("chromedriverOS");
            chromedriverWIN = (String) jsonObject.get("chromedriverWin");
            chromedriverUnix = (String) jsonObject.get("chromedriverUnix");
            chromedriverOS = System.getProperty("user.dir") + chromedriverOS;
            chromedriverWIN = System.getProperty("user.dir") + chromedriverWIN;
            chromedriverUnix = System.getProperty("user.dir") + chromedriverUnix;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (System.getProperty("os.name").contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", chromedriverOS);
        } else if (System.getProperty("os.name").contains("Win")) {
            System.setProperty("webdriver.chrome.driver", chromedriverWIN);
        } else if (System.getProperty("os.name").contains("Linux")) {
            System.setProperty("webdriver.chrome.driver", chromedriverUnix);

        }
    }
}

