package game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ConvertJson implements Convert{


    @Override
    public void TransForm(List<List<Item>> items,String fileMame) {
        ObjectMapper obj = new ObjectMapper();
        try {
            obj.writerWithDefaultPrettyPrinter().writeValue(new File(fileMame.replace(".txt",".json")),
                    items);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
