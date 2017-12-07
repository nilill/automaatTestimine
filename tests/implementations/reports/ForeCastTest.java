package implementations.reports;


import org.junit.Test;

public class ForeCastTest {
    private Validator validator = new Validator();

    @Test
    public void getForecast() {
        //ForeCast foreCast = new ForeCast("https://api.openweathermap.org/data/2.5/forecast?q=%22Tallinn&appid=8ed7afa5f56fcd9ca49db9e458e97128&unit=metric");
        //String fore = foreCast.getForecast(0);
        //System.out.println(fore);
        //assertEquals(17, fore.length());
    }
    @Test
    public void getMaxTemp() {
        //ForeCast foreCast = new ForeCast("https://api.openweathermap.org/data/2.5/forecast?q=%22Tallinn&appid=8ed7afa5f56fcd9ca49db9e458e97128&unit=metric");
        //assertEquals(false, validator.validateTemp(foreCast.getForecast(1)));
    }
    @Test
    public void getMinTemp() {
        //ForeCast foreCast = new ForeCast("https://api.openweathermap.org/data/2.5/forecast?q=%22Tallinn&appid=8ed7afa5f56fcd9ca49db9e458e97128&unit=metric");
        //assertEquals(false, validator.validateTemp(foreCast.getForecast(2)));
    }
}