package cz.czechitas.lekce11.formbuilder;

import com.jgoodies.binding.list.SelectionInList;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Filip Jirsák
 */
public interface WithLabel<B> {
  WithInput<B> textField(String property);

  WithInput<B> textField(String property, Consumer<JTextField> configuration);

  WithInput<B> numberField(String property);

  WithInput<B> numberField(String property, NumberFormat format);

  WithInput<B> numberField(String property, String format);

  WithInput<B> numberField(String property, Consumer<JFormattedTextField> configuration);

  WithInput<B> numberField(String property, NumberFormat format, Consumer<JFormattedTextField> configuration);

  WithInput<B> numberField(String property, String format, Consumer<JFormattedTextField> configuration);

  WithInput<B> dateField(String property);

  WithInput<B> dateField(String property, Consumer<JFormattedTextField> configuration);

  <E> WithInput<B> comboBox(String property, List<E> items);

  <E> WithInput<B> comboBox(String property, SelectionInList<E> list);

  <E> WithInput<B> comboBox(String property, List<E> items, Consumer<JComboBox<E>> configuration);

  <E> WithInput<B> comboBox(String property, SelectionInList<E> list, Consumer<JComboBox<E>> configuration);

  WithInput<B> checkbox(String label, String property);

  WithInput<B> checkbox(String label, String property, Consumer<JCheckBox> configuration);
}
