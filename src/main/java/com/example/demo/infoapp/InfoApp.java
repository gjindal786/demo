package com.example.demo.infoapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties used to pick things from application.properties as we can set path as prefix and define our objects.
@ConfigurationProperties(prefix = "info.app")
//@Data It is super annotation as set public constructor, getters, setters & toString functions.
@Data
public class InfoApp {
    private String name;
    private String description;
    private String version;

    /*
    InfoApp(String name,String description,String version) {
        this.name = name;
        this.description = description;
        this.version = version;
    }
    public InfoApp() {

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "InfoApp{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
     */
}
