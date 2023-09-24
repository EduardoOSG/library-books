package com.uam.microservices.books.enums;

public enum CatEstatusEnum {

    AVAILABLE(1L),
    DELIVERED(2L),
    OVERDUE(3L),
    DELAYED_DELIVERY(4L);

    private final Long value;

    CatEstatusEnum(Long value) {
        this.value = value;
    }

    public static CatEstatusEnum getEnum(Long value) {
        for (CatEstatusEnum e : CatEstatusEnum.values()) {
            if (e.getValue().equals(value))
                return e;
        }
        return CatEstatusEnum.AVAILABLE;
    }

    public Long getValue() {
        return value;
    }
}


