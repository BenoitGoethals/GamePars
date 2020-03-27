package game;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ConvertXML implements Convert {
    @Override
    public void TransForm(List<List<Item>> items,String fileMame) {

            XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new FileOutputStream(fileMame.replace(".txt",".XML")),items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
