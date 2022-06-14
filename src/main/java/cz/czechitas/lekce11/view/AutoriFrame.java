package cz.czechitas.lekce11.view;

import cz.czechitas.lekce11.Aplikace;
import cz.czechitas.lekce11.controller.KnihovnaController;
import net.miginfocom.swing.MigLayout;

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
    setMinimumSize(new Dimension(600, 300));
    setLayout(new BorderLayout());

    add(createList(), BorderLayout.WEST);
    add(createForm(), BorderLayout.CENTER);
    add(createButtonStack(), BorderLayout.EAST);

    pack();
  }

  private Component createList() {
    //TODO Implementovat seznam autorů pomocí JList – použít BasicComponentFactory
    return new JScrollPane();
  }

  private Component createForm() {
    JPanel panel = new JPanel(new MigLayout("wrap 2", "[right]rel[grow,fill]"));
    //TODO Implementovat formulář – editaci jména a roku narození – použít FormBuilder
    return panel;
  }

  private Component createButtonStack() {
    JPanel panel = new JPanel(new MigLayout("wrap 1", "[80,fill]", "[top]"));
    //TODO Implementovat tlačítka „Nový“, „Smazat“ a „Zavřít“ – použít ActionBuilder
    return panel;
  }
}
