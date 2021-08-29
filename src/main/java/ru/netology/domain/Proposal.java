package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Proposal implements Comparable<Proposal> {

    private int id;
    private int price;
    private String from; //iata BTS LIL TOY MSU XYZ TDD SQl JDK
    private String to; //iata
    private int time;

    @Override
    public int compareTo(Proposal o) {
        return this.price - o.price;
    }
}
