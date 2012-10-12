package com.intelligrape.learngrails

import grails.validation.Validateable
import org.apache.commons.collections.list.LazyList
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.ListUtils;
@Validateable

class QuestionCommand {
    String title
    String description
    String tag
    String justification
    List<QuestionOptionCommand> questionOptions = ListUtils.lazyList([], {new QuestionOptionCommand()} as Factory)

    @Override
    public String toString() {
        return "QuestionCommand{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tag=" + tag +
                ", questionOptions=" + questionOptions +
                '}';
    }
}

