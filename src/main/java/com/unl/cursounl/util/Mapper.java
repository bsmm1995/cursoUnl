package com.unl.cursounl.util;

import org.modelmapper.ModelMapper;

public class Mapper {
  private Mapper() {
    throw new IllegalStateException("No se puede instancian un utilitario");
  }

  public static ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
