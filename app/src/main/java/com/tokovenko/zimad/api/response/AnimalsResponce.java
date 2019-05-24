package com.tokovenko.zimad.api.response;

import com.tokovenko.zimad.domain.model.Animal;

import java.util.List;

public class AnimalsResponce {
    private String message;
    private List<Animal> data;

    public String getMessage() {
        return message;
    }

    public List<Animal> getData() {
        return data;
    }
}
