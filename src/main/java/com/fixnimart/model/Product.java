package com.fixnimart.model;

import java.util.UUID;
import lombok.Data;

@Data
public class Product {
    UUID ProductId;
    byte[] ProductImage;
    String Name;
    String Description;
    double Price;
    int Stock;
    String BarCode;
}
