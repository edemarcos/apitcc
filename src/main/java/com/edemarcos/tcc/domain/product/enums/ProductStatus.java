package com.edemarcos.tcc.domain.product.enums;

public enum ProductStatus {
    ACTIVE(1),
    INACTIVE(2);

    private final int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ProductStatus valueOf(int value) {
        for (ProductStatus status : ProductStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ProductStatus value: " + value);
    }
}
