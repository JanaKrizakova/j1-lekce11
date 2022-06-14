package cz.czechitas.lekce11.model;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;

import java.beans.PropertyChangeListener;

/**
 * Údaje o tištěné knize.
 */
public class Kniha implements ObservableBean {
  private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);

  private String nazev;
  private Autor autor;
  private Long vydani;
  private Long rokVydani;
  private Long pocetStran;
  private String vydavatelstvi;

  public Kniha() {
  }

  public Kniha(String nazev, Autor autor, Long vydani, Long rokVydani, Long pocetStran, String vydavatelstvi) {
    this.nazev = nazev;
    this.autor = autor;
    this.vydani = vydani;
    this.rokVydani = rokVydani;
    this.pocetStran = pocetStran;
    this.vydavatelstvi = vydavatelstvi;
  }

  public String getNazev() {
    return nazev;
  }

  public void setNazev(String nazev) {
    String oldValue = this.nazev;
    this.nazev = nazev;
    pcs.firePropertyChange("nazev", oldValue, this.nazev);
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    Autor oldValue = this.autor;
    this.autor = autor;
    pcs.firePropertyChange("autor", oldValue, this.autor);
  }

  public Long getVydani() {
    return vydani;
  }

  public void setVydani(Long vydani) {
    Long oldValue = this.vydani;
    this.vydani = vydani;
    pcs.firePropertyChange("vydani", oldValue, this.vydani);
  }

  public Long getRokVydani() {
    return rokVydani;
  }

  public void setRokVydani(Long rokVydani) {
    Long oldValue = this.rokVydani;
    this.rokVydani = rokVydani;
    pcs.firePropertyChange("rokVydani", oldValue, this.rokVydani);
  }

  public Long getPocetStran() {
    return pocetStran;
  }

  public void setPocetStran(Long pocetStran) {
    Long oldValue = this.pocetStran;
    this.pocetStran = pocetStran;
    pcs.firePropertyChange("pocetStran", oldValue, this.pocetStran);
  }

  public String getVydavatelstvi() {
    return vydavatelstvi;
  }

  public void setVydavatelstvi(String vydavatelstvi) {
    String oldValue = this.vydavatelstvi;
    this.vydavatelstvi = vydavatelstvi;
    pcs.firePropertyChange("vydavatelstvi", oldValue, this.vydavatelstvi);
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    pcs.addPropertyChangeListener(listener);
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    pcs.removePropertyChangeListener(listener);
  }
}
