package game;

public class Main {

    public static void main(String[] args) {
        if(args.length>1 ) {
                Converter.setFile(args[0]).Convert(Rep.valueOf(args[1]));
        }
        else
            System.out.println("No File given");
    }
}
