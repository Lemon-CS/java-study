package com.lemon.config;

import com.lemon.io.Resources;
import com.lemon.pojo.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 2:42 下午
 */
public class XMLConfigBuilder {

    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }

    /**
     * 该方法就是使用dom4j对配置文件进行解析，封装Configuration
     */
    public Configuration parseConfig(InputStream inputStream) throws DocumentException, PropertyVetoException {

        Document document = new SAXReader().read(inputStream);
        //<configuration>
        Element rootElement = document.getRootElement();

        List<Element> list = rootElement.selectNodes("//property");
        Properties properties = new Properties();
        for (Element element : list) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");

            properties.setProperty(name, value);
        }

        // c3p0的连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(properties.getProperty("driverClass"));
        comboPooledDataSource.setJdbcUrl(properties.getProperty("jdbcUrl"));
        comboPooledDataSource.setUser(properties.getProperty("username"));
        comboPooledDataSource.setPassword(properties.getProperty("password"));

        configuration.setDataSource(comboPooledDataSource);

        //mapper.xml解析: 拿到路径--字节输入流---dom4j进行解析
        List<Element> mapperList = rootElement.selectNodes("//mapper");

        for (Element element : mapperList) {
            String mapperPath = element.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(mapperPath);
            XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
            xmlMapperBuilder.parse(resourceAsStream);
        }

        return null;
    }

}
