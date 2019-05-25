package listeners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

//класс отвечающий за чтение properties

public class PropertyListener implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {  //получаем список suites
        XmlSuite suite = suites.get(0);  //берем первый элемент списка, то есть первый suite
        Properties properties = new Properties(); //создаем объект типа properties
        try {  // загружаем данные из файла в объект properties
            properties.load(new FileReader("src/test/resources/testChrome.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<String, String> params = new HashMap<String, String>(); // создаем объект HashMap, где ключ и значения - строки
        for (Map.Entry<Object, Object> abc : properties.entrySet()) { // entrySet - возвращает список записей в properties, перебираем этот список
            params.put(abc.getKey().toString(), abc.getValue().toString()); //кладем записи в объект params
        }
        suite.setParameters(params); //устанавливаем значения параметров
    }
}