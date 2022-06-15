package cz.czechitas.lekce11;


import com.formdev.flatlaf.FlatLightLaf;
import cz.czechitas.lekce11.controller.KnihovnaController;
import cz.czechitas.lekce11.view.KnihyFrame;

public class Aplikace {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new KnihovnaController().start();
    }
}
