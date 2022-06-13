package cz.czechitas.lekce11.formbuilder;

import java.awt.*;

/**
 * @author Filip Jirsák
 */
public interface WithModel<B> {
  FormBuilderWithContainer<B> container(Container container);
}
