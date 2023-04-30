package model;

public enum Priority {

    THIRDAGE(5),
    
    PREGNANT(4),
    
    SMALLKID(3),
    
    SPECIALATTENTION(2),
    
    NONE(1);

    private int value;

    private Priority(int value) {

        this.value = value;

    }

    public int getValue() {

        return value;
        
    }
}

