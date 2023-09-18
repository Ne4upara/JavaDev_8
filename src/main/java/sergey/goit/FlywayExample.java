package sergey.goit;

import org.flywaydb.core.Flyway;

import static sergey.goit.DatabaseConnection.loadProperties;
import static sergey.goit.DatabaseConnection.properties;

public class FlywayExample {

    public static void flyway() {
        loadProperties();
        Flyway.configure()
                .dataSource(properties.getProperty("db.url"),
                            properties.getProperty("db.userName"),
                            properties.getProperty("db.password"))
                .locations("classpath:databaseFlyway/migration")
                .load()
                .migrate();
    }
}
