
package homework6;

import oracle.javatools.db.DBException;

import java.io.FileReader;
import java.io.IOException;

public class MyFileReaderImpl implements MyFileReader {

    private MyFileReader myFileReader = null;

    @Override
    public String readFile(String file) {
        String numberOfCharact = null;
        try {
            FileReader fr = new FileReader("/src/homework6/test.txt");
            numberOfCharact = String.valueOf(fr.read());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
                myFileReader.writeFile();
        }
        catch (DBException de) {
            de.getMessage();
        }
        return numberOfCharact;
    }

    @Override
    public String writeFile() {
        MyFileReader myFileReader = new MyFileReaderImpl();
        myFileReader.readFile("file");
        return null;
    }
}

