package com.example.cleaninghouse.service.tool;

import org.springframework.beans.factory.annotation.Value;

import java.util.Locale;
import java.util.ResourceBundle;

public class Broom extends CleaningTool {
    @Value("${language}")
    String language;
    @Value("${country}")
    String country;
    Locale locale = new Locale(language, country);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("res.bundle", locale);

    @Override
    public void use() {
        System.out.println(resourceBundle.getString("tool.broom.use"));
    }
}
