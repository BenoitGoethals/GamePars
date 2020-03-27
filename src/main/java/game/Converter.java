package game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.text.StringTokenizer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Converter {

    private static Converter instance = new Converter();

    private Convert convert;

    private static String file;

    public static Converter setFile(String file) throws FileNotFoundException {
        if (file == null || file.isEmpty())
            throw new FileNotFoundException(file);
        Converter.file = file;
        return instance;
    }

    public Converter Convert(Rep typeRep) {
        List<List<Item>> items = new ArrayList<>();
        try {
            File f = new File(file);
            if (f.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String line = reader.readLine();
                while (line != null) {
                    List<Item> itemsList = createItemList(line);
                    items.add(itemsList);
                    line = reader.readLine();
                }
                reader.close();
                convert=typeRep.getConvert();
                convert.TransForm(items,file);

            } else {
                throw new FileNotFoundException(file);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

        return instance;
    }

    private List<Item> createItemList(String line) {
        List<Item> ret = new ArrayList<>();
        line = line.substring(1, line.length() - 1);
        StringTokenizer tokenizer = new StringTokenizer(line, "\"]");
        while (tokenizer.hasNext()) {
            String part = tokenizer.nextToken();
            StringTokenizer tokenizer2 = new StringTokenizer(part, ",");
            Item item = new Item(tokenizer2.nextToken().replace("\"", ""), tokenizer2.nextToken().replace("\"", ""), tokenizer2.nextToken().replace("\"", ""));
            ret.add(item);
        }
        return ret;
    }

}
