package implementations.reports;

class Validator {

    static boolean validateGEO(double geo) {
        return geo > 0 && geo < 180;
    }

    static boolean validateTemp(String temp) {
        try {
            double number = Double.parseDouble(temp);
        } catch (NumberFormatException nfe) {
            return false;
        }
        double number = Double.parseDouble(temp);
        return number < 70 && number > -70;
    }
}
