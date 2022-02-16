package com.lemon.mp.generator.user.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author zimu
* @since 2022-02-17
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 姓名
            */
    private String name;

            /**
            * 年龄
            */
    private Integer age;

            /**
            * 邮箱
            */
    private String email;

            /**
            * 版本
            */
    private Integer version;

            /**
            * 1代表删除，0代表未删除
            */
    private Integer deleted;


}
