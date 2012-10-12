package com.intelligrape.learngrails

public enum Usefulness {
    USEFUL("Useful", 1),
    VERY_USEFUL("Very Useful", 2),
    MOST_USEFUL("Most Useful", 3)

    String displayName
    Integer points

    Usefulness(String name, Integer p) {
        displayName = name
        points = p
    }
}


