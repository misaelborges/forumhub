package com.misael.forumhub.domain.exceptions;

public class DuplicateTopicException extends RuntimeException {

    public DuplicateTopicException(String message) {
        super(message);
    }

    public DuplicateTopicException() {
        this("There is already a topic with this title and message");
    }
}

