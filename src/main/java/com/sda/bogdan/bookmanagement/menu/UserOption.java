package com.sda.bogdan.bookmanagement.menu;

public enum UserOption {
    CREATE_AUTHOR(1,"Create Author"),
    SHOW_ALL_AUTHORS(2,"Display all authors"),
    EXIT(99,"Exit"),
    UNKNOW(100,"Unknow Option");

    private int numericOption;
    private String displayValue;

    UserOption(int numericOption, String displayValue) {
        this.numericOption = numericOption;
        this.displayValue = displayValue;
    }

    public int getNumericOption() {
        return numericOption;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static void printAllOptions(){
        for (UserOption value : values()) {
                if(value != UNKNOW){
                    System.out.println(value.getNumericOption() + "-" + value.getDisplayValue());
                }
        }
    }
    public static UserOption findUserOption(int numericValue){
        for(UserOption value : values()){
            if(value.getNumericOption() == numericValue){
                return value;
            }
        }
        return UNKNOW;
    }
}
