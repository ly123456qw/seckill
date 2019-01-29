package org.seckill.entity;

public class MessageEntity {
    private Integer message_id;
    private Integer user_id;
    private String message_title;
    private String message_content;

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getMessage_title() {
        return message_title;
    }

    public void setMessage_title(String message_title) {
        this.message_title = message_title;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    @Override
    public String toString() {
        return "message{" +
                "message_id=" + message_id +
                ", user_id=" + user_id +
                ", message_title='" + message_title + '\'' +
                ", message_content='" + message_content + '\'' +
                '}';
    }
}
