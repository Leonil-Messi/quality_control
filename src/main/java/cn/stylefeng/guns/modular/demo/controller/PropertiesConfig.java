package cn.stylefeng.guns.modular.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Java读写修改Property文件
 * @author hjz
 * @date 2019-1-3
 * @version 1.0
 */
@RestController
@RequestMapping("Properties")
public class PropertiesConfig {

    public static final String path = "./src/main/webapp/assets/strings.properties";

    @RequestMapping("/read")
    public static String readData(String key) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(path));
            props.load(in);
            in.close();
            String value = props.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @RequestMapping("/update")

    public static void writeData(String key, String value) {
        Properties prop = new Properties();
        try {
            File file = new File(path);
            if (!file.exists())
                file.createNewFile();
            InputStream fis = new FileInputStream(file);
            prop.load(fis);
            //一定要在修改值之前关闭fis
            fis.close();
            OutputStream fos = new FileOutputStream(path);
            prop.setProperty(key, value);
            //保存，并加入注释
            prop.store(fos, "Update '" + key + "' value");
            fos.close();
        } catch (IOException e) {
            System.err.println("Visit " + path + " for updating " + value + " value error");
        }
    }
}
