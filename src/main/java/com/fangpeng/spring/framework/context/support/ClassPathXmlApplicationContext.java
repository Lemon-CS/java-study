package com.fangpeng.spring.framework.context.support;

import com.fangpeng.spring.framework.beans.BeanDefinition;
import com.fangpeng.spring.framework.beans.MutablePropertyValues;
import com.fangpeng.spring.framework.beans.PropertyValue;
import com.fangpeng.spring.framework.beans.factory.support.BeanDefinitionRegistry;
import com.fangpeng.spring.framework.beans.factory.xml.XmlBeanDefinitionReader;
import com.fangpeng.spring.framework.utils.StringUtils;

import java.lang.reflect.Method;
import java.rmi.registry.Registry;

/**
 * @Description: IOC容器具体的子实现类
 *               用于加载类路径下的xml格式的配置文件
 * @Author : Lemon-CS
 * @Date : 2022年02月10日 6:32 下午
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        //构建解析器对象
        beanDefinitionReader = new XmlBeanDefinitionReader();

        try {
            this.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //根据bean对象的名称获取bean对象
    @Override
    public Object getBean(String name) throws Exception {
        //判断对象容器中是否包含指定名称的bean对象，如果包含，直接返回即可，如果不包含，需要自行创建
        Object obj = singletonMap.get(name);
        if (obj != null) {
            return obj;
        }

        //获取BeanDefinition对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);

        //获取bean信息中的className
        String className = beanDefinition.getClassName();

        //通过反射创建对象
        Class<?> clazz = Class.forName(className);
        Object beanObj = clazz.newInstance();

        //进行依赖注入操作
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            //获取name属性值
            String propertyName = propertyValue.getName();
            //获取value属性
            String value = propertyValue.getValue();
            //获取ref属性
            String ref = propertyValue.getRef();

            if (ref != null && !"".equals(ref)) {
                //获取依赖的bean对象
                Object bean = getBean(ref);
                //拼接方法名
                String methodName = StringUtils.getSetterMethodByFieldName(propertyName);
                //获取所有的方法对象
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        method.invoke(beanObj, bean);
                    }
                }
            }

            if (value != null && !"".equals(value)) {
                //拼接方法名
                String methodName = StringUtils.getSetterMethodByFieldName(propertyName);
                //获取method对象
                Method method = clazz.getMethod(methodName, String.class);
                method.invoke(beanObj, value);
            }
        }

        //在返回beanObj对象之前，将该对象存储到map容器中
        singletonMap.put(name, beanObj);

        return beanObj;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if(bean == null) {
            return null;
        }
        return clazz.cast(bean);
    }
}
