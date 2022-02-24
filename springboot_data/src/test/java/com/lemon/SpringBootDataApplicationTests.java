package com.lemon;

import com.lemon.mapper.ArticleMapper;
import com.lemon.mapper.CommentMapper;
import com.lemon.pojo.Address;
import com.lemon.pojo.Article;
import com.lemon.pojo.Comment;
import com.lemon.pojo.Person;
import com.lemon.repository.CommentRepository;
import com.lemon.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月24日 8:22 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataApplicationTests {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void contextLoads() {
        Comment comment = commentMapper.findById(1);
        System.out.println(comment);
    }

    @Autowired
    private ArticleMapper articleMapper;


    @Test
    public void selectArticle(){
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }


    //测试整合JPA
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void selectComment(){
        Optional<Comment> byId = commentRepository.findById(1);
        if(byId.isPresent()){}
        System.out.println(byId.get());
    }

    //测试整合redis
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void savePerson(){
        Person person = new Person();
        person.setFirstname("张");
        person.setLastname("三");

        Address address = new Address();
        address.setCity("北京");
        address.setCountry("中国");
        person.setAddress(address);

        // 向redis数据库中添加了数据
        personRepository.save(person);

    }

    @Test
    public void selectPerson(){
        List<Person> list = personRepository.findByAddress_City("北京");
        for (Person person : list) {
            System.out.println(person);
        }


    }

}
