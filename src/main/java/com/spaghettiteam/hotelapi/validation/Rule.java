package com.spaghettiteam.hotelapi.validation;

public interface Rule<T> {
    void validate(T t);
}
