package ru.netology.repository;

import ru.netology.domain.Proposal;

public class ProposalRepository {
    private Proposal[] tickets = new Proposal[0];

    public void save(Proposal item) {
        int length = tickets.length + 1;
        Proposal[] tmp = new Proposal[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        tickets = tmp;
    }

    public Proposal[] getAll() {
        return tickets;
    }

    public Proposal findById(int id) {
        for (Proposal item : tickets) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {

        int length = tickets.length - 1;
        Proposal[] tmp = new Proposal[length];
        int index = 0;
        for (Proposal item : tickets) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        tickets = tmp;
    }
}
