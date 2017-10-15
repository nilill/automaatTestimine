package implementations;

public class ForeCast implements interfaces.ForeCastInterface {
    private String url;
    private JsonReadWrite jsonReadWrite;
    public ForeCast(String url) {
        this.url = url;
        jsonReadWrite =  new JsonReadWrite(url);


    }
    @Override
    public String getForecast(int day) {
        return jsonReadWrite.getListType(day);
    }

    @Override
    public int getMaxTemp() {
        return 0;
    }

    @Override
    public int getMinTemp() {
        return 0;
    }
}
