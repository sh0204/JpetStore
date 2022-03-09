package org.mybatis.jpetstore.domain;

import java.io.Serializable;

public class Mating implements Serializable {

    private static final long serialVersionUID = 3421795172624424931L;

    private int matingId;
    private String title;
    private String type;
    private String username;
    private String species;
    private String sex;
    private int age;
    private String content;
    private String path;

    public int getMatingId() {
        return matingId;
    }

    public void setMatingId(int matingId) {
        this.matingId = matingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() { return path; }

    public void setPath(String path) { this.path = path; }
}
