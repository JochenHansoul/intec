package com.example.cleaninghouse.service.tool;

import org.springframework.beans.factory.annotation.Value;

import java.util.Locale;
import java.util.ResourceBundle;

public class Broom extends CleaningTool {
    @Value("${language.language}")
    String language;
    @Value("${language.country}")
    String country;
    Locale locale = new Locale("fr", "FR");
    //ResourceBundle resourceBundle = ResourceBundle.getBundle("res.bundle", locale);

    @Override
    public void use() {
        //System.out.println(resourceBundle.getString("tool.broom.use"));
    }
}
