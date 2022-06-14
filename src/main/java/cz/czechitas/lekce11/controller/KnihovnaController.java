package cz.czechitas.lekce11.controller;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.list.SelectionInList;
import cz.czechitas.lekce11.formbuilder.ActionBuilder;
import cz.czechitas.lekce11.model.Autor;
import cz.czechitas.lekce11.model.Kniha;
import cz.czechitas.lekce11.view.AutoriFrame;
import cz.czechitas.lekce11.view.KnihyFrame;

import javax.swing.*;

/**
 *
 */
public class KnihovnaController {
  private final SelectionInList<Kniha> knihaList = new SelectionInList<>();
  private final SelectionInList<Autor> autorList = new SelectionInList<>();
  private final PresentationModel<Kniha> knihaModel = new PresentationModel<>(knihaList.getSelectionHolder());
  private final AutoriFrame autoriFrame;
  private final KnihyFrame knihyFrame;
  private final Action novaKnihaAction;
  private final Action smazatKnihuAction;
  private final Action autoriAction;
  private final Action konecAction;

  public KnihovnaController() {
    nacistData();
    novaKnihaAction = ActionBuilder.create("N&ová", this::handleNovaKniha);
    smazatKnihuAction = ActionBuilder.create("&Smazat", this::handleSmazatKniha);
    autoriAction = ActionBuilder.create("&Autoři", this::handleAutori);
    konecAction = ActionBuilder.create("U&končit", this::handleKonec);

    if (!knihaList.isEmpty()) {
      knihaList.setSelectionIndex(0);
    }
    if (!autorList.isEmpty()) {
      autorList.setSelectionIndex(0);
    }

    smazatKnihuAction.setEnabled(knihaList.hasSelection());
    knihaList.addPropertyChangeListener("selectionEmpty", (event) -> smazatKnihuAction.setEnabled(!(Boolean) event.getNewValue()));

    autoriFrame = new AutoriFrame(this);
    knihyFrame = new KnihyFrame(this);
  }

  public void start() {
    knihyFrame.setVisible(true);
  }

  private void handleNovaKniha() {
    knihaList.getList().add(new Kniha());
  }

  private void handleSmazatKniha() {
    knihaList.getList().remove(knihaList.getSelectionIndex());
  }

  private void handleAutori() {
    autoriFrame.setLocationRelativeTo(knihyFrame);
    autoriFrame.setVisible(true);
  }

  private void handleKonec() {
    System.exit(0);
  }

  private void nacistData() {
    Autor karelCapek = new Autor("Karel Čapek", 1890);
    Autor josefCapek = new Autor("Josef Čapek", 1887);
    autorList.getList().add(karelCapek);
    autorList.getList().add(josefCapek);

    knihaList.getList().add(new Kniha("Dášeňka, čili, Život štěněte", karelCapek, 1, 1999, 78, "Amulet"));
    knihaList.getList().add(new Kniha("Povídání o pejskovi a kočičce", josefCapek, 16, 1984, 115, "Albatros"));
  }

  public SelectionInList<Kniha> getKnihaList() {
    return knihaList;
  }

  public SelectionInList<Autor> getAutorList() {
    return autorList;
  }

  public PresentationModel<Kniha> getKnihaModel() {
    return knihaModel;
  }

  public Action getNovaKnihaAction() {
    return novaKnihaAction;
  }

  public Action getSmazatKnihuAction() {
    return smazatKnihuAction;
  }

  public Action getAutoriAction() {
    return autoriAction;
  }

  public Action getKonecAction() {
    return konecAction;
  }
}
