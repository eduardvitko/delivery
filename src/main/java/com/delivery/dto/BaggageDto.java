package com.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class BaggageDto {

    private int b_id;

    private String name_Baggage;

    private int height;

    private int weight;

    private  int length;

    private int width;
}
