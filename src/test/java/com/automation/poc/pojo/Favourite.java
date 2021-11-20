package com.automation.poc.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Favourite {

  @JsonProperty("image")
  private Image image;

  @JsonProperty("user_id")
  private String userId;

  @JsonProperty("sub_id")
  private String subId;

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("image_id")
  private String imageId;
}