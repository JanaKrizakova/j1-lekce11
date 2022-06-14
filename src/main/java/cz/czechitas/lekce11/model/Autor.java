package cz.czechitas.lekce11.model;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import com.jgoodies.common.bean.ObservableBean;

import java.beans.PropertyChangeListener;
import java.util.Objects;

/**
 * Údaje o autorovi knihy.
 */
public class Autor implements ObservableBean {
  private final ExtendedPropertyChangeSupport pcs = new ExtendedPropertyChangeSupport(this);
  private String jmeno;
  private Long rokNarozeni;

  public Autor() {
  }

  public Autor(String jmeno, Long rokNarozeni) {
    this.jmeno = jmeno;
    this.rokNarozeni = rokNarozeni;
  }

  public String getJmeno() {
    return jmeno;
  }

  public void setJmeno(String jmeno) {
    String oldValue = this.jmeno;
    this.jmeno = jmeno;
    pcs.firePropertyChange("jmeno", oldValue, this.jmeno);
  }

  public Long getRokNarozeni() {
    return rokNarozeni;
  }

  public void setRokNarozeni(Long rokNarozeni) {
    Long oldValue = this.rokNarozeni;
    this.rokNarozeni = rokNarozeni;
    pcs.firePropertyChange("rokNarozeni", oldValue, this.rokNarozeni);
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    pcs.addPropertyChangeListener(listener);
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    pcs.removePropertyChangeListener(listener);
  }

  @Override
  public String toString() {
    return String.format("%s (%d)", jmeno, rokNarozeni);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Autor)) return false;
    Autor autor = (Autor) o;
    return Objects.equals(jmeno, autor.jmeno) && Objects.equals(rokNarozeni, autor.rokNarozeni);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jmeno, rokNarozeni);
  }
}
