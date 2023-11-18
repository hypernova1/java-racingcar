package step4.domain;

public class Car {

    private static final int THRESHOLD = 4;
    private static final int MAX_NAME_SIZE = 5;

    private final String name;
    private int forwardCount = 0;

    public Car(String name) {
        this.validateName(name);
        this.name = name;
    }

    protected Car(String name, int forwardCont) {
        this(name);
        this.forwardCount = forwardCont;
    }

    public void move(int randomNumber) {
        if (isImmovable(randomNumber)) {
            return;
        }
        this.forwardCount++;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    public int graterThanForwardCount(int value) {
        return Math.max(this.forwardCount, value);
    }

    public boolean equalForwardCount(int value) {
        return value == this.getForwardCount();
    }

    private boolean isImmovable(int number) {
        return number < THRESHOLD;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}