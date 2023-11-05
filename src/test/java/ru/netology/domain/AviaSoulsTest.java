package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    AviaSouls repo = new AviaSouls();

    @Test
    public void shouldCompareToFirstTicketMoreSecondTicketTest() {
        Ticket ticket1 = new Ticket("Домодедово", "Курумоч", 14_560, 13, 15);
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 12_590, 17, 20);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToFirstTicketLessSecondTicketTest() {
        Ticket ticket1 = new Ticket("Домодедово", "Курумоч", 14_560, 13, 15);
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 18_590, 17, 20);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareToFirstTicketEqualSecondTicketTest() {
        Ticket ticket1 = new Ticket("Домодедово", "Курумоч", 14_560, 13, 15);
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 14_560, 17, 20);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicketsTest() {

        Ticket ticket1 = new Ticket("Домодедово", "Курумоч", 14_560, 13, 15);
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 11_560, 17, 20);
        Ticket ticket3 = new Ticket("Пулково", "Пенза", 17_560, 12, 17);
        Ticket ticket4 = new Ticket("Курумоч", "Волгоград", 12_800, 19, 23);
        Ticket ticket5 = new Ticket("Шереметьево", "Екатеринбург", 19_560, 9, 13);
        Ticket ticket6 = new Ticket("Домодедово", "Волгоград", 23_560, 13, 16);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);


        Ticket[] actual = repo.search("Курумоч", "Волгоград");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortAndSearchFewTicketsTest() {

        Ticket ticket1 = new Ticket("Домодедово", "Волгоград", 14_560, 13, 15);
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 11_560, 17, 20);
        Ticket ticket3 = new Ticket("Домодедово", "Волгоград", 12_800, 12, 17);
        Ticket ticket4 = new Ticket("Домодедово", "Волгоград", 12_800, 19, 23);
        Ticket ticket5 = new Ticket("Шереметьево", "Екатеринбург", 19_560, 9, 13);
        Ticket ticket6 = new Ticket("Домодедово", "Волгоград", 23_560, 13, 16);
        Ticket ticket7 = new Ticket("Домодедово", "Курумоч", 14_000, 9, 12);
        Ticket ticket8 = new Ticket("Домодедово", "Волгоград", 20_560, 11, 13);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        Ticket[] actual = repo.search("Домодедово", "Волгоград");
        Ticket[] expected = {ticket3, ticket4, ticket1, ticket8, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortAndSearchZeroTicketsTest() {

        Ticket ticket1 = new Ticket("Домодедово", "Волгоград", 14_560, 13, 15);
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 11_560, 17, 20);
        Ticket ticket3 = new Ticket("Домодедово", "Волгоград", 12_800, 12, 17);
        Ticket ticket4 = new Ticket("Домодедово", "Волгоград", 12_800, 19, 23);
        Ticket ticket5 = new Ticket("Шереметьево", "Екатеринбург", 19_560, 9, 13);
        Ticket ticket6 = new Ticket("Домодедово", "Волгоград", 23_560, 13, 16);
        Ticket ticket7 = new Ticket("Домодедово", "Курумоч", 14_000, 9, 12);
        Ticket ticket8 = new Ticket("Домодедово", "Волгоград", 20_560, 11, 13);

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        Ticket[] actual = repo.search("Пулково", "Волгоград");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortAndSearchFewTicketsWithComparatorTest() {

        Ticket ticket1 = new Ticket("Домодедово", "Волгоград", 14_560, 13, 15); // 2
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 11_560, 17, 20);
        Ticket ticket3 = new Ticket("Домодедово", "Волгоград", 12_800, 12, 17); // 5
        Ticket ticket4 = new Ticket("Домодедово", "Волгоград", 12_800, 19, 23); // 4
        Ticket ticket5 = new Ticket("Шереметьево", "Екатеринбург", 19_560, 9, 13);
        Ticket ticket6 = new Ticket("Домодедово", "Волгоград", 23_560, 15, 16);  //1
        Ticket ticket7 = new Ticket("Домодедово", "Курумоч", 14_000, 9, 12);
        Ticket ticket8 = new Ticket("Домодедово", "Волгоград", 20_560, 11, 13); // 3

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] actual = repo.search("Домодедово", "Волгоград", comparator);
        Ticket[] expected = {ticket6, ticket1, ticket8, ticket4, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortAndSearchOneTicketsWithComparatorTest() {

        Ticket ticket1 = new Ticket("Домодедово", "Волгоград", 14_560, 13, 15); // 2
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 11_560, 17, 20);
        Ticket ticket3 = new Ticket("Домодедово", "Волгоград", 12_800, 12, 17); // 5
        Ticket ticket4 = new Ticket("Домодедово", "Волгоград", 12_800, 19, 23); // 4
        Ticket ticket5 = new Ticket("Шереметьево", "Екатеринбург", 19_560, 9, 13);
        Ticket ticket6 = new Ticket("Домодедово", "Волгоград", 23_560, 15, 16);  //1
        Ticket ticket7 = new Ticket("Домодедово", "Курумоч", 14_000, 9, 12);
        Ticket ticket8 = new Ticket("Домодедово", "Волгоград", 20_560, 11, 13); // 3

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] actual = repo.search("Внуково", "Волгоград", comparator);
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortAndSearchZeroTicketsWithComparatorTest() {

        Ticket ticket1 = new Ticket("Домодедово", "Волгоград", 14_560, 13, 15); // 2
        Ticket ticket2 = new Ticket("Внуково", "Волгоград", 11_560, 17, 20);
        Ticket ticket3 = new Ticket("Домодедово", "Волгоград", 12_800, 12, 17); // 5
        Ticket ticket4 = new Ticket("Домодедово", "Волгоград", 12_800, 19, 23); // 4
        Ticket ticket5 = new Ticket("Шереметьево", "Екатеринбург", 19_560, 9, 13);
        Ticket ticket6 = new Ticket("Домодедово", "Волгоград", 23_560, 15, 16);  //1
        Ticket ticket7 = new Ticket("Домодедово", "Курумоч", 14_000, 9, 12);
        Ticket ticket8 = new Ticket("Домодедово", "Волгоград", 20_560, 11, 13); // 3

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] actual = repo.search("Шереметьево", "Волгоград", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

}