package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class MovieManagerTest {
    MovieRepository repo = Mockito.mock(MovieRepository.class);
    MovieManager manager = new MovieManager(repo);

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
    public void shouldShowLimitByDefault() {
        MovieItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15};
        doReturn(items).when(repo).findAll();

        MovieItem[] expected = {item15, item14, item13, item12, item11, item10, item9, item8, item7, item6};
        MovieItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByParameters() {
        MovieManager manager = new MovieManager(repo, 5);
        MovieItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15};
        doReturn(items).when(repo).findAll();

        MovieItem[] expected = {item15, item14, item13, item12, item11};
        MovieItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByParametersAboveLimit() {
        MovieManager manager = new MovieManager(repo, 20);
        MovieItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15};
        doReturn(items).when(repo).findAll();

        MovieItem[] expected = {item15, item14, item13, item12, item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        MovieItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByNegativeParameters() {
        MovieManager manager = new MovieManager(repo, -3);
        MovieItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15};
        doReturn(items).when(repo).findAll();

        MovieItem[] expected = {item15, item14, item13, item12, item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        MovieItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByZeroParameter() {
        MovieManager manager = new MovieManager(repo, 0);
        MovieItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15};
        doReturn(items).when(repo).findAll();

        MovieItem[] expected = {};
        MovieItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLimitByParameterOne() {
        MovieManager manager = new MovieManager(repo, 1);
        MovieItem[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15};
        doReturn(items).when(repo).findAll();

        MovieItem[] expected = {item15};
        MovieItem[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}