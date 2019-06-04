package services.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Reader<T>{
    private static final String COMMA_DELIMITER = ",";

    BufferedReader fileReader = null;

    public List<T> readObjects(String path) {

        List<T> objectList = new ArrayList<T>();

        try {
            fileReader = new BufferedReader(new FileReader(path));
            String line = "";
            fileReader.readLine();  //header

            while ((line = fileReader.readLine()) != null) {

                String[] objectDetails = line.split(COMMA_DELIMITER);

                T object = createObject(objectDetails);
                objectList.add(object);
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        return objectList;
    }

    abstract T createObject(String[] objectDetails);
}