package org.graalvm.demos.springr;

import java.util.List;

public class DataHolder<T> {

  public List<T> values;

  public DataHolder(List<T> values) {
    this.values = values;
  }

}
