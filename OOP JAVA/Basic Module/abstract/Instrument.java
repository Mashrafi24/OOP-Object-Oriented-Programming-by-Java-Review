abstract class Instrument {
    // Private and protected fields
    private String name;
    protected int year;
    
    // Constructor
    public Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }
    
    // Abstract method that child classes must implement
    public abstract String play();
    
    // Concrete method that all child classes inherit
    public String getInstrumentDetails() {
        return "Instrument: " + name + ", Year: " + year;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
}
