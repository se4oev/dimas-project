package entity;

public enum FinSourse {

    OMS("ОМС", 1),
    DMS("ДМС", 2),
    CASH("Наличные", 3);

    private String text;
    private int code;

    FinSourse(String text, int code) {
        this.text=text;
        this.code=code;
    }

    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }
}
