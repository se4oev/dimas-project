package entity;

public enum FinSourse {

    OBLIGATORY("ОМС", 1),
    ADDITIONAL("ДМС", 2),
    CASH("Наличные", 3);

    private String text;
    private int code;

    FinSourse(String text, int code) {
        this.text=text;
        this.code=code;
    }
}
