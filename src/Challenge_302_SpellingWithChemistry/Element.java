package Challenge_302_SpellingWithChemistry;

public class Element {

    /** Element attributes */
    private String NAME, SYMBOL, ATOMICWEIGHT;
    private int Z;
    private float C;

    /**
     * Constructor without C
     */
    public Element(String NAME, String SYMBOL, String ATOMICWEIGHT, int Z) {
        this.NAME = NAME;
        this.SYMBOL = SYMBOL;
        this.ATOMICWEIGHT = ATOMICWEIGHT;
        this.Z = Z;
    }

    /**
     * Constructor
     */
    public Element(String NAME, String SYMBOL, String ATOMICWEIGHT, int Z, float C) {
        this.NAME = NAME;
        this.SYMBOL = SYMBOL;
        this.ATOMICWEIGHT = ATOMICWEIGHT;
        this.Z = Z;
        this.C = C;
    }

    /**
     * Getters
     */
    public String getNAME() { return NAME; }
    public String getSYMBOL() { return SYMBOL; }
    public String getATOMICWEIGHT() { return ATOMICWEIGHT; }
    public int getZ() { return Z; }
    public float getC() { return C; }

}
