package com.spaghettiteam.hotelapi.validation;

public interface Validator<T> {
    void validate(T t);
}
