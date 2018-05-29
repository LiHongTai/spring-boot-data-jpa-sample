package com.roger.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringDataJpaApplication {

    //手动初始化DruidDataSource
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    //注册后台界面Servlet Bean, 用于显示后台界面
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //创建StatViewServlet,绑定到/druid/路径下
        ServletRegistrationBean serRegBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> param = new HashMap<>();
        param.put("loginUsername","admin");
        param.put("loginPassword","123456");
        param.put("allow","");//那些IP允许访问后台,""代表所有地址
        param.put("deny","33.31.51.88");//不允许这个IP访问

        serRegBean.setInitParameters(param);

        return serRegBean;
    }

    //用于监听获取应用的数据,Filter用于收集数据,Servlet用于展现数据
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();

        filterRegBean.setFilter(new WebStatFilter());
        filterRegBean.addUrlPatterns("/*");

        Map<String,String> param = new HashMap<>();
        param.put("exclusions","*.png,*.map,*.js,*.css,/druid/*,*.woff");
        filterRegBean.setInitParameters(param);
        return filterRegBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
}
