package org.mybatis.jpetstore.domain;

import java.io.Serializable;

public class Board implements Serializable {

    private static final long serialVersionUID = -8359821512904602344L;

    private int boardId;
    private String username;
    private String title;
    private String content;

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}