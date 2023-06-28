package com.richand.mongo2.document;

import lombok.Data;

@Data
public class CategoryAveragePriceResult {
    private String category;
    private double averagePrice;
}