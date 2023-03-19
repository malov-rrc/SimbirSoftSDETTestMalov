package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс для работы с конфиг-файлом
 */
public class ConfigManager {

    private static ConfigManager manager;
    private static final Properties properties = new Properties();
    private final String PATH_TO_PROPERTIES = "src/test/resources/application.properties";

    private ConfigManager() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Не удалось открыть файл property " + PATH_TO_PROPERTIES);
        }
    }

    public static ConfigManager getInstance() {
        if (manager == null) {
            synchronized (ConfigManager.class) {
                try {
                    manager = new ConfigManager();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return manager;
    }

    public String getProperty(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }
}