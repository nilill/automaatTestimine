package implementations;

public class main {
    public static void main(String[] args) {
        Controler controler = new Controler();
        controler.setCity("Tallinn");
        String currentWeather = controler.getCurrentWeather();
        String forecast = controler.getForecastWeather();
        String coordinates = controler.getCoordinates();
        JsonReadWrite.writeToFile(currentWeather +"\n"+ forecast + "\n"+ coordinates);
        System.out.println(controler.getForecastWeather());
        System.out.println(controler.getCurrentWeather());
        String path = ("D:\\Programeerimine\\Automaattestimine\\automaatTestimine\\doesNotExist.txt");
        controler.setCityFromFile(path);
        controler.setCityFromConsole();


    }

}
