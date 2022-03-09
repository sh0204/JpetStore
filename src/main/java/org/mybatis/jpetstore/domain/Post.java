package org.mybatis.jpetstore.domain;

import net.sourceforge.stripes.validation.Validate;

import java.io.Serializable;

/**
 * The Class Account.
 *
 * @author Eduardo Macarron
 */
public class Post implements Serializable {

    private static final long serialVersionUID = 3839697446622980525L;

    private int idx;
    private String sendUser;
    private String receiveUser;
    private String title;
    private String content;
    private char status;
    private String createdAt;
    private char recvdel;
    private char senddel;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }

    public String getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(String receiveUser) {
        this.receiveUser = receiveUser;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public char getSenddel() {
        return senddel;
    }

    public void setSenddel(char senddel) {
        this.senddel= senddel;
    }

    public char getRecvdel() {
        return recvdel;
    }

    public void setRecvdel(char recvdel) {
        this.recvdel= recvdel;
    }
}
