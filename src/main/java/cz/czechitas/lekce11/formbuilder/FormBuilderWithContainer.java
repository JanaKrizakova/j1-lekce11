package cz.czechitas.lekce11.formbuilder;

import javax.swing.*;
import java.util.function.Consumer;

public interface FormBuilderWithContainer<B> extends WithLabel<B> {
  WithLabel<B> label(String text);

  WithInput<B> panel(Consumer<JPanel> configuration);
}
