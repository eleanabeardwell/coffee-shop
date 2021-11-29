public enum Size {
    SMALL (0),
    MEDIUM (0.3),
    LARGE (0.6),
    SINGLE (0),
    DOUBLE (1.10);

    private double additionalCost;

    Size(double additionalCost) {
        this.additionalCost = additionalCost;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }
}
