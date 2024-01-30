package presenter;

import model.service.Service;
import view.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addToys(String nameToy, int weightToy) {
        view.printAnswer(service.addToys(nameToy, weightToy));
    }
    public void getToy() {
        view.printAnswer(service.getToy());
    }
    public void giveToy() {
        view.printAnswer(service.giveToy());
    }
    public void allToysInShop() {
        view.printAnswer(service.allToysInShop());
    }
    public void allToysInQueue() {
        view.printAnswer(service.allToysInQueue());
    }
    public  boolean finish() {
        return service.finish();
    }
}
