package org.simon;

import org.simon.controller.SimonController;
import org.simon.model.SimonGame;
import org.simon.view.SimonView;

public class App {
    public static void main(String[] args) {
        SimonGame model = new SimonGame();
        SimonView view = new SimonView();
        SimonController controller = new SimonController(model, view);

        view.show();

        // add shutdown hook to stop schedulers
        Runtime.getRuntime().addShutdownHook(new Thread(controller::shutdown));
    }
}
