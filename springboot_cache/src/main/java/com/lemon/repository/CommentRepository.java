package com.lemon.repository;

import com.lemon.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    //根据评论id修改评论作者

    @Transactional
    @Modifying
    @Query(value = "update t_comment c set c.author = ?1 where  c.id = ?2", nativeQuery = true)
    public int updateComment(String author, Integer id);

}
