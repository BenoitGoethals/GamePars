package game;

public enum Rep {

    XML(new ConvertXML()),
    JSON(new ConvertJson());
    private final Convert convert;

    Rep(Convert convert) {
        this.convert=convert;
    }

    public Convert getConvert() {
        return convert;
    }

    @Override
    public String toString() {
        return "Rep{" +
                "convert=" + convert +
                '}';
    }
}
