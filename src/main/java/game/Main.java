package game;

public class Main {

    public static void main(String[] args) {
        if(args.length>0)
            Converter.setFile(args[0]).Convert(Rep.JSON);
        else
            System.out.println("No File given");
    }
}
