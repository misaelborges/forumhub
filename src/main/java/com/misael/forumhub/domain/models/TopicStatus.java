package com.misael.forumhub.domain.models;

public enum TopicStatus {
    NOT_ANSWERED("Not answered"),
    UNRESOLVED("Unresolved"),
    RESOLVED("Resolved"),
    CLOSED("Closed");

    private String status;

    TopicStatus(String status) {
        this.status = status;
    }
}
