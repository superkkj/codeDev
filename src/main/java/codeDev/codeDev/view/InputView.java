package codeDev.codeDev.view;

import static codeDev.codeDev.dev.Console.readLine;

public class InputView {


    public static InputView of() {
        return new InputView();
    }

    public String insertPersonName() {
        System.out.println("사람이름입력.(이름은쉼표(,)기준으로구분)");
        return readLine();
    }

    public String insertHomeNames() {
        System.out.println("주소입력.(이름은쉼표(,)기준으로구분)");
        return readLine();
    }
}
