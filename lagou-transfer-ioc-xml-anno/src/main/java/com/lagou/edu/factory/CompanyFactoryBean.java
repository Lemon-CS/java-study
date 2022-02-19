package com.lagou.edu.factory;

import com.lagou.edu.pojo.Company;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月19日 10:16 下午
 */
public class CompanyFactoryBean implements FactoryBean<Company> {

    private String companyInfo; // 公司名称,地址,规模
    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    @Override
    public Company getObject() throws Exception {
        // 模拟创建复杂对象Company
        Company company = new Company();
        String[] strings = companyInfo.split(",");
        company.setName(strings[0]);
        company.setAddress(strings[1]);
        company.setScale(Integer.parseInt(strings[2]));
        return company;
    }
    @Override
    public Class<?> getObjectType() {
        return Company.class;
    }
    @Override
    public boolean isSingleton() {
        return true;
    }
}
