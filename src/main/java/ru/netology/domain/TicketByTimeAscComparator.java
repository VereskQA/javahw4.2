package ru.netology.domain;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Proposal> {
    public int compare(Proposal o1, Proposal o2) {
        return o1.getTime() - o2.getTime();
    }
}
