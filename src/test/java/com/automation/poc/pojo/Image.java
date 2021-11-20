package com.automation.poc.pojo;

import java.util.List;
import lombok.Data;

@Data
public class Image {

  private int width;
  private String id;
  private String url;
  private int height;
  private List<Breed> breeds;
  private List<Category> categories;
}