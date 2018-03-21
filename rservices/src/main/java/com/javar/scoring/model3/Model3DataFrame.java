package com.javar.scoring.model3;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javar.scoring.models.ModelDataFrame;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Model3DataFrame extends ModelDataFrame {


}
