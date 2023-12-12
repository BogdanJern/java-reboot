package ru.sberbank.edu;

public interface Saver {
    void save(int lineCount, int spaceCount, String line) throws RuntimeException;
}