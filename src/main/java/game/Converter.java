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

    private static String file;

    public static Converter setFile(String file) {
        if (file == null || file.isEmpty())
            System.out.println("File can not be null or empty");
        Converter.file = file;
        return instance;
    }

    public Converter Convert(Rep typeRep) {
        List<List<Item>> items = new ArrayList<>();
        try {
            File f = new File(file);
            if (f.exists()) {
                BufferedReader reader;

                reader = new BufferedReader(new FileReader(f));
                String line = reader.readLine();
                while (line != null) {
                    //  System.out.println(line);

                    List<Item> itemsList = createItemList(line);
                    items.add(itemsList);
                    // read next line
                    line = reader.readLine();
                }
                reader.close();
                if (typeRep == Rep.JSON) {

                    ObjectMapper obj = new ObjectMapper();


                    try {

                        // get Oraganisation object as a json string
                        obj.writerWithDefaultPrettyPrinter().writeValue(new File(file.replace(".txt",".json")), items);

                        // Displaying JSON String
                        //  System.out.println(jsonStr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (typeRep == Rep.XML) {

                    XmlMapper xmlMapper = new XmlMapper();
                    String xml = xmlMapper.writeValueAsString(items);
                    System.out.println(xml);
                }


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
            Item item = new Item(tokenizer2.nextToken().toString().replace("\"", ""), tokenizer2.nextToken().replace("\"", "").toString(), tokenizer2.nextToken().replace("\"", "").toString());
            ret.add(item);
        }


        return ret;
    }

}
