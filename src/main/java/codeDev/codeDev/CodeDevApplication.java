package codeDev.codeDev;

import codeDev.codeDev.dev.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeDevApplication {

    public static void main(String[] args) {
        new Application().start();
    }
}
