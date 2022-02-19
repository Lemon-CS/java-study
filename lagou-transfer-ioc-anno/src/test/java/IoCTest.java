import com.lagou.edu.SpringConfig;
import com.lagou.edu.dao.AccountDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;



import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * @author Lemon-CS
 */
public class IoCTest {


    @Test
    public void testIoC() throws Exception {

        // 通过读取classpath下的xml文件来启动容器（xml模式SE应用下推荐）
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        accountDao.queryAccountByCardNo("1111111");
        System.out.println("accountDao：" + accountDao);

    }

}
