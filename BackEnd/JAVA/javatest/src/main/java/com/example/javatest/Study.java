package com.example.javatest;

public class Study {

    private StudyStatus status;
    private int limit;

    public Study() {
        this.status = StudyStatus.DRAFT;
    }

    public Study(int limit) {
        if(limit <0){
            throw new IllegalArgumentException("limit은 0보다 커야합니다.");
        }
        this.status = StudyStatus.DRAFT;
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return this.limit;
    }
}

