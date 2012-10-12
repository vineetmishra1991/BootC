package com.intelligrape.learngrails

class ApplicationTagLib {

    static namespace = "lg"

    def tags = {attrs ->

        List<Tag> tagsList = Tag.list()
        out << render(template: '/tag/tag', model: [tagsList: tagsList])

    }
    def viewQuestionsTitle = {attrs ->

        Tag tag = Tag.get(attrs.long('tagId'))
        out << """<a href="${createLink(action: "listTagQuestion", controller: "question", id: tag.id)}">${tag.name}</a>"""
    }

    def viewQuestion = {attrs ->

        Question question = Question.get(attrs.long('questionId'))
        out << """<a href="${createLink(action: "showQuestionOption", controller: "question", id: question.id)}">${question.title}</a>"""
    }
    def topTeachers = {attrs ->

        Integer max = attrs.int('max')

        def userList = Answer.createCriteria().list()
                {
                    projections {
                        groupProperty('user')
                        count('question', 'q')
                    }
                    eq('usefulness', Usefulness.MOST_USEFUL)
                    order('q', 'desc')
                    maxResults max
                }
        out << render(template: '/user/topTeachers', model: [userList: userList])
    }
}
