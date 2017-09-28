package interfaces;

public interface ValidatorInterface {
    public boolean validateGEO(String GEO);
    public boolean validateTemp(int temp);
    public String getMeasurmentSystem();
}
