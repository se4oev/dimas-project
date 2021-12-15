package entity;

public enum Sex {

    MALE("Мужской", 1),
    FEMALE("Женский", 0);

    private String text;
    private int code;

    Sex(String text, int code) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public int getCode() {
        return code;
    }
}
