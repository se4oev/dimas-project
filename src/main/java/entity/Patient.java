package entity;

import java.time.LocalDate;

public class Patient {
    private long id;
    private String fio;
    private LocalDate date;
    private Sex sex;
    private int num;
    private String smo;
    private String snils;
    private String policy;
    private FinSource fin_source;

    public Patient (long id, String fio, String date, int sex, int num,
                    String smo, String snils, String policy, int fin_source) {
        this.id = id;
        this.fio = fio;
        this.date = date;
        this.sex = sex;
        this.num = num;
        this.smo = smo;
        this.snils = snils;
        this.policy = policy;
        this.fin_source = fin_source;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getSmo() {
        return smo;
    }

    public void setSmo(String smo) {
        this.smo = smo;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public FinSource getFin_source() {
        return fin_source;
    }

    public void setFin_source(FinSource fin_source) {
        this.fin_source = fin_source;
    }
}
