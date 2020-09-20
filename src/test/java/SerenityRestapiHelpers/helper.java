package SerenityRestapiHelpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class helper {
    public static String Properties(String PName) throws IOException {

        Properties prop = new Properties();
        File configFile = new File("src/test/resources/serenity.properties");
        InputStream stream = new FileInputStream(configFile);
        prop.load(stream);

        return  prop.getProperty(PName);

    }

}
