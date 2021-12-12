package entity;

public enum Sex {

    MALE("Мужской", 1),
    FEMALE("Женский", 0);

    private String text;
    private int code;
    private String shortText;

    Sex(String text, int code) {
        this.text = text;
        this.code = code;
    }
}
