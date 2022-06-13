package cz.czechitas.lekce11.formbuilder;

/**
 * @author Filip Jirsák
 */
public interface WithInput<B> {
  FormBuilderWithContainer<B> add();

  FormBuilderWithContainer<B> add(Object constraints);
}
