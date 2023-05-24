package lambda;

public enum Gender {
    FEMALE, MALE;

    public boolean isMale() {
        return this == MALE;
    }

    public boolean isFemale() {
        return this == FEMALE;
    }
}
