package ru.netology.manager;

import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repo;

    public MovieManager(MovieRepository repo) {
        this.repo = repo;
    }

    private int limit = 10;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public MovieManager(MovieRepository repo, int limit) {
        this.repo = repo;
        this.limit = limit;
    }

    public MovieItem[] findLast() {
        MovieItem[] all = repo.findAll();
        int resultLength;
        if (getLimit() >= 0 && getLimit() < all.length) {
            resultLength = getLimit();
        } else {
            resultLength = all.length;
        }
        MovieItem[] result = new MovieItem[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = all[all.length - 1 - i];
        }
        return result;
    }
}

