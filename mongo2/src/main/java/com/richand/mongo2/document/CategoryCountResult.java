package com.richand.mongo2.document;

import lombok.Data;

@Data
public class CategoryCountResult {
    private String category;
    private int total;
}