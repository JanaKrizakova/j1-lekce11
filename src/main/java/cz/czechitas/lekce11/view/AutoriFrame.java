package cz.czechitas.lekce11.view;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import cz.czechitas.lekce11.Aplikace;
import cz.czechitas.lekce11.controller.KnihovnaController;
import cz.czechitas.lekce11.formbuilder.ActionBuilder;
import cz.czechitas.lekce11.formbuilder.FormBuilder;
import cz.czechitas.lekce11.formbuilder.FormBuilderWithContainer;
import cz.czechitas.lekce11.model.Autor;
import cz.czechitas.lekce11.model.Kniha;
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
    JList list = BasicComponentFactory.createList(controller.getAutorList());
    return new JScrollPane(list);
  }

  private Component createForm() {
    JPanel panel = new JPanel(new MigLayout("wrap 2", "[right]rel[grow,fill]"));

    FormBuilderWithContainer<Autor> formBuilder = FormBuilder.create(controller.getAutorModel())
            .container(panel);

    formBuilder
            .label("&Jméno")
            .textField("jmeno")
            .add("span");

    formBuilder
            .label("&Rok narození")
            .numberField("rokNarozeni", "0000")
            .add();

    return panel;
  }

  private Component createButtonStack() {
    JPanel panel = new JPanel(new MigLayout("wrap 1", "[80,fill]", "[top]"));
    panel.add(new JButton(controller.getNovyAutorAction()));
    panel.add(new JButton(controller.getSmazatAutoraAction()));
    panel.add(new JButton(controller.getAutoriSkrytAction()));
    return panel;
  }
}
