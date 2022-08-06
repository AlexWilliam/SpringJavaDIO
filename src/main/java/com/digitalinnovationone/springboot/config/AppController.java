package com.digitalinnovationone.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${app.message}")
    private String appMessage;

    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbEnvironmentVariable;

    @GetMapping("/getMessage")
    public String getAppMessage(){
        return appMessage;
    }

    @GetMapping("/variavel")
    public String getDbEnvironmentVariable(){
        return "Variavel com valor ${dbEnvironmentVariable}";
    }
}
