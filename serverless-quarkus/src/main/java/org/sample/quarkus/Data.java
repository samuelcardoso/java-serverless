package org.sample.quarkus;

import javax.validation.constraints.Positive;

public class Data {

    private Long id;

    @Positive
    private Integer number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return id + " - " + number;
    }
}