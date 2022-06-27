package ru.netology.manager;

import ru.netology.domain.MovieItem;

public class MovieManager {
    private MovieItem[] items = new MovieItem[0];
    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public MovieManager() {
        this.limit = 10;
    }


    public void save(MovieItem item) {
        MovieItem[] tmp = new MovieItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public MovieItem[] findAll() {
        return items;
    }

    public MovieItem[] findLast() {
        MovieItem[] all = findAll();
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

