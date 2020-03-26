package game;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        if(args.length>1 ) {
            try {
                Converter.setFile(args[0]).Convert(Rep.valueOf(args[1]));
            } catch (FileNotFoundException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        else
            System.out.println("No File given");
    }
}
