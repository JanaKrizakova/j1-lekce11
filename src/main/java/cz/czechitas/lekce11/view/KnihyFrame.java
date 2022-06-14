package cz.czechitas.lekce11.view;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import cz.czechitas.lekce11.Aplikace;
import cz.czechitas.lekce11.controller.KnihovnaController;
import cz.czechitas.lekce11.formbuilder.FormBuilder;
import cz.czechitas.lekce11.formbuilder.FormBuilderWithContainer;
import cz.czechitas.lekce11.model.Kniha;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;

/**
 * Hlavní okno aplikace – seznam knih.
 */
public class KnihyFrame extends JFrame {
  private final KnihovnaController controller;

  public KnihyFrame(KnihovnaController controller) throws HeadlessException {
    super("Knihovna 1.0");
    this.controller = controller;
    this.init();
  }

  private void init() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
    setMinimumSize(new Dimension(600, 300));
    setLayout(new BorderLayout());

    add(createMainPanel(), BorderLayout.CENTER);
    add(createButtonStack(), BorderLayout.EAST);

    pack();
  }

  private Component createMainPanel() {
    JPanel panel = new JPanel();
    BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
    panel.setLayout(boxLayout);

    panel.add(createForm());
    panel.add(createTable());
    return panel;
  }

  private Component createButtonStack() {
    JPanel panel = new JPanel(new MigLayout("wrap 1", "[80,fill]", "[top]"));
    panel.add(new JButton(controller.getNovaKnihaAction()));
    panel.add(new JButton(controller.getSmazatKnihuAction()));
    panel.add(new JButton(controller.getAutoriAction()));
    panel.add(new JButton(controller.getKonecAction()));
    return panel;
  }



  private Component createForm() {
    JPanel panel = new JPanel(new MigLayout("wrap 4", "[right]rel[grow,fill]unrel[right]rel[grow,fill]"));
    FormBuilderWithContainer<Kniha> formBuilder = FormBuilder.create(controller.getKnihaModel())
            .container(panel);

    formBuilder
            .label("&Název")
            .textField("nazev")
            .add("span");

    formBuilder
            .label("&Autor")
            .comboBox("autor", controller.getAutorList().getList())
            .add("span");

    formBuilder
            .label("&Vydání")
            .numberField("vydani")
            .add();

    formBuilder
            .label("&Rok vydání")
            .numberField("rokVydani", "0000")
            .add();

    formBuilder
            .label("Počet &stran")
            .numberField("pocetStran")
            .add();

    formBuilder
            .label("Vydavate&lství")
            .textField("vydavatelstvi")
            .add();

    return panel;
  }

  private Component createTable() {
    JTable table = BasicComponentFactory.createTable(controller.getKnihaList(), new KnihaTableAdapter());
    TableColumnModel columnModel = table.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(200);
    columnModel.getColumn(1).setPreferredWidth(200);
    columnModel.getColumn(2).setPreferredWidth(50);
    columnModel.getColumn(3).setPreferredWidth(50);
    columnModel.getColumn(4).setPreferredWidth(100);
    return new JScrollPane(table);
  }

  private class KnihaTableAdapter extends AbstractTableAdapter<Kniha> {
    public KnihaTableAdapter() {
      super("Název", "Autor", "Rok vydání", "Počet stran", "Vydavatelství");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Kniha kniha = getRow(rowIndex);
      switch (columnIndex) {
        case 0:
          return kniha.getNazev();
        case 1:
          return kniha.getAutor();
        case 2:
          return kniha.getRokVydani();
        case 3:
          return kniha.getPocetStran();
        case 4:
          return kniha.getVydavatelstvi();
        default:
          return null;
      }
    }
  }

}
