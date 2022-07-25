package codeDev.codeDev.dev;


import codeDev.codeDev.view.InputView;
import codeDev.codeDev.view.ResultView;

public class Application {

    private Country country = new Country();
    private InputView inputView = new InputView();


    public void start() {
        String pNames = inputView.insertPersonName();
        country.initPerson(pNames);

        String hNames = inputView.insertHomeNames();
        country.initHome(hNames);

        country.initPersonHome();

        printResult();
    }

    void printResult() {

        ResultView resultView = new ResultView(country.getPeople(), country.gethomes());

        System.out.println("영어이름만 출력!");
        resultView.printEnglishName();


        System.out.println("사람-주소 출력!");
        resultView.printPersonHome(country.getPersonHome());
    }

}
