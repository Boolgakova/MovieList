package ru.netology.repository;

import ru.netology.domain.MovieItem;

public class MovieRepository {
    private MovieItem[] items = new MovieItem[0];

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

    public MovieItem findById(int id) {
        return items[id - 1];
    }

    public void removeById(int id) {
        MovieItem[] tmp = new MovieItem[items.length - 1];
        int copyToIndex = 0;
        for (MovieItem item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public void removeAll() {
        MovieItem[] tmp = new MovieItem[0];
        items = tmp;
    }
}
