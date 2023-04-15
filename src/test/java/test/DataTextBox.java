package test;

public enum DataTextBox {
    JOHN("John6", "john@gmail.com", "John address 1", "John address 2"),
    KATE("Kate6", "kate@gmail.com", "Kate address 1", "Kate address 2" ),
    PETER("Peter6", "peter@gmail.com", "Peter address 1", "Peter address 2");

    private final String NAME;
    private final String EMAIL;
    private final String CURRENT_ADDRESS;
    private final String PERMANENT_ADDRESS;

    DataTextBox(String NAME, String EMAIL, String CURRENT_ADDRESS, String PERMANENT_ADDRESS) {
        this.NAME = NAME;
        this.EMAIL = EMAIL;
        this.CURRENT_ADDRESS = CURRENT_ADDRESS;
        this.PERMANENT_ADDRESS = PERMANENT_ADDRESS;
    }

    public String getNAME() {
        return NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getCURRENT_ADDRESS() {
        return CURRENT_ADDRESS;
    }

    public String getPERMANENT_ADDRESS() {
        return PERMANENT_ADDRESS;
    }
}
