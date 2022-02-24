package com.lemon.pojo;

import javax.persistence.*;

@Entity
@Table(name = "t_comment")
public class Comment {

    @Id //表明映射主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //评论id
    private String content; //评论内容
    private String author; //评论作者
    @Column(name = "a_id")
    private Integer aId; //外键：表示当前这条评论是属于那篇文章

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", aId=" + aId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }
}
