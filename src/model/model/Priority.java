package model;

public enum Priority {

    THIRDAGE(1),
    
    PREGNANT(2),
    
    SMALLKID(3),
    
    SPECIALATTENTION(4),
    
    NONE(5);

    private int value;

    private Priority(int value) {

        this.value = value;

    }

    public int getValue() {

        return value;
        
    }
}

