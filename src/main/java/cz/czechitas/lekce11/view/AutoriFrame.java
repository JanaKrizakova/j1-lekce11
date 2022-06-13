package cz.czechitas.lekce11.view;

import cz.czechitas.lekce11.Aplikace;
import cz.czechitas.lekce11.controller.KnihovnaController;

import javax.swing.*;
import java.awt.*;

/**
 * Okno aplikace – seznam autorů.
 */
public class AutoriFrame extends JFrame {
  private final KnihovnaController controller;

  public AutoriFrame(KnihovnaController controller) throws HeadlessException {
    super("Autoři");
    this.controller = controller;
    this.init();
  }

  private void init() {
    setDefaultCloseOperation(HIDE_ON_CLOSE);
    setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
    setLocationRelativeTo(null);
    setMinimumSize(new Dimension(400, 400));
    setLayout(new BorderLayout());

    pack();
  }
}
