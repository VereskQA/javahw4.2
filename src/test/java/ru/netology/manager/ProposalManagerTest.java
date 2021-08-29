package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Proposal;
import ru.netology.domain.TicketByTimeAscComparator;
import ru.netology.repository.ProposalRepository;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ProposalManagerTest {
    private ProposalRepository repository = new ProposalRepository();
    private ProposalManager manager = new ProposalManager(repository);
    private Proposal first = new Proposal(1, 1513, "BTS", "LIL", 124);
    private Proposal second = new Proposal(2, 1534, "BTS", "LIL", 360);
    private Proposal third = new Proposal(3, 1532, "LIL", "BTS", 364);
    private Proposal fourth = new Proposal(4, 1753, "LIL", "BTS", 128);
    private Proposal fifth = new Proposal(5, 3522, "MSU", "XYZ", 121);
    private Proposal sixth = new Proposal(6, 4566, "XYZ", "MSU", 120);
    private Proposal seventh = new Proposal(7, 4567, "TDD", "TDD", 3);
    private Proposal eight = new Proposal(8, 8541, "SQl", "JDK", 127);
    private Proposal ninth = new Proposal(9, 4519, "SQl", "JDK", 352);
    private Proposal tenth = new Proposal(10, 1510, "JDK", "JDK", 854);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eight);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    public void shouldSortByTime() {
        Proposal[] actual = new Proposal[]{first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};
        Arrays.sort(actual, new TicketByTimeAscComparator());
        assertArrayEquals(new Proposal[]{seventh, sixth, fifth, first, eight, fourth, ninth, second, third, tenth},
                actual);
    }

    @Test
    public void shouldFindAllByFromToAndSortByTime() {
        assertArrayEquals(new Proposal[]{eight, ninth}, manager.searchBy("SQl", "JDK",
                new TicketByTimeAscComparator()));
    }
}