package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;

public class MovieManagerTest {

    MovieItem item1 = new MovieItem(1, "Matrix");
    MovieItem item2 = new MovieItem(2, "Deadpool");
    MovieItem item3 = new MovieItem(3, "Mission impossible");
    MovieItem item4 = new MovieItem(4, "Beauty and the beast");
    MovieItem item5 = new MovieItem(5, "Sex and the city");
    MovieItem item6 = new MovieItem(6, "And just like that...");
    MovieItem item7 = new MovieItem(7, "Friends");
    MovieItem item8 = new MovieItem(8, "Big bang theory");
    MovieItem item9 = new MovieItem(9, "IT crowd");
    MovieItem item10 = new MovieItem(10, "Taxi");
    MovieItem item11 = new MovieItem(11, "Gentlemen");
    MovieItem item12 = new MovieItem(12, "Bohemian rhapsody");
    MovieItem item13 = new MovieItem(13, "Rocketman");
    MovieItem item14 = new MovieItem(14, "Transformers");
    MovieItem item15 = new MovieItem(15, "X-men");

    @Test
    public void emptyList() {
        MovieManager repo = new MovieManager();

        MovieItem[] expected = {};
        MovieItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOne() {
        MovieManager repo = new MovieManager();
        repo.save(item1);

        MovieItem[] expected = {item1};
        MovieItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldAddSeveral() {
        MovieManager repo = new MovieManager();
        repo.save(item1);
        repo.save(item3);
        repo.save(item5);

        MovieItem[] expected = {item1, item3, item5};
        MovieItem[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByDefault() {
        MovieManager repo = new MovieManager();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);
        repo.save(item12);
        repo.save(item13);
        repo.save(item14);
        repo.save(item15);

        MovieItem[] expected = {item15, item14, item13, item12, item11, item10, item9, item8, item7, item6};
        MovieItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByParameters() {
        MovieManager repo = new MovieManager(5);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);
        repo.save(item12);
        repo.save(item13);
        repo.save(item14);
        repo.save(item15);

        MovieItem[] expected = {item15, item14, item13, item12, item11};
        MovieItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByParametersAboveLimit() {
        MovieManager repo = new MovieManager(20);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);
        repo.save(item12);
        repo.save(item13);
        repo.save(item14);
        repo.save(item15);

        MovieItem[] expected = {item15, item14, item13, item12, item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        MovieItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByNegativeParameters() {
        MovieManager repo = new MovieManager(-3);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);
        repo.save(item12);
        repo.save(item13);
        repo.save(item14);
        repo.save(item15);

        MovieItem[] expected = {item15, item14, item13, item12, item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        MovieItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByZeroParameter() {
        MovieManager repo = new MovieManager(0);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);
        repo.save(item12);
        repo.save(item13);
        repo.save(item14);
        repo.save(item15);

        MovieItem[] expected = {};
        MovieItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByParameterOne() {
        MovieManager repo = new MovieManager(1);
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);
        repo.save(item12);
        repo.save(item13);
        repo.save(item14);
        repo.save(item15);

        MovieItem[] expected = {item15};
        MovieItem[] actual = repo.findLast();

        assertArrayEquals(expected, actual);
    }
}
