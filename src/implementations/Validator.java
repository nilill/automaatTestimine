package implementations;

import interfaces.ValidatorInterface;

public class Validator implements ValidatorInterface {
    @Override
    public boolean validateGEO(String GEO) {
        return false;
    }

    @Override
    public boolean validateTemp(String temp) {
        return false;
    }

    @Override
    public String getMeasurmentSystem() {
        return "Metric";
    }
}
