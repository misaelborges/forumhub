package com.misael.forumhub.domain.exceptions;

public class NotFoundTopicException extends RuntimeException {

    public NotFoundTopicException(String message) {
        super(message);
    }

    public NotFoundTopicException(Long id) {
        this("No topic was found with the id:" + id);
    }
}

