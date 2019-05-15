package listeners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class PropertyListener implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        XmlSuite suite = suites.get(0);
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/testChrome.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, String> params = new HashMap<String, String>();
        for (Map.Entry<Object, Object> each : properties.entrySet()) {
            params.put(each.getKey().toString(), each.getValue().toString());

        }
        suite.setParameters(params);
    }
}