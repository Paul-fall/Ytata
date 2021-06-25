package com.project.ygvt;

public class Tabel1 {
    private Long id;
    private String value;

    public Tabel1() {

    }
    public Tabel1(Long id, String value)
    {
        this.id = id;
        this.value = value;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long idd) {
        this.id = idd;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
