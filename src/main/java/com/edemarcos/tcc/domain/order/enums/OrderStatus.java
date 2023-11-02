package com.edemarcos.tcc.domain.order.enums;

import com.edemarcos.tcc.domain.product.enums.ProductStatus;

public enum OrderStatus {
    PENDING(1),
    PROCESSING(2),
    SENT(3),
    CANCELED(4),
    DELIVERED(5);
    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderStatus valueOf(int value) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus value: " + value);
    }

}
