package com.itheima.arguidance;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class GenerCreateCode {
public static void main(String[] args) {
    // 使用 FastAutoGenerator 快速配置代码生成器
    FastAutoGenerator.create("jdbc:mysql://192.168.126.100:3306/mybatis_plus?serverTimezone=GMT%2B8", "root", "duanchengxi66..")
            .globalConfig(builder -> {
                builder.author("Dcx") // 设置作者
                        .outputDir("src/main/java"); // 输出目录
            })
            .packageConfig(builder -> {
                builder.parent("arguidance") // 设置父包名
                        .entity("pojo") // 设置实体类包名
                        .mapper("mapper") // 设置 Mapper 接口包名
                        .service("service") // 设置 Service 接口包名
                        .serviceImpl("service.impl") // 设置 Service 实现类包名
                        .xml("mappers"); // 设置 Mapper XML 文件包名
            })
            .strategyConfig(builder -> {
                builder.addInclude("user") // 设置需要生成的表名
                        .entityBuilder()
                        .enableLombok() // 启用 Lombok
                        .enableTableFieldAnnotation() // 启用字段注解
                        .controllerBuilder()
                        .enableRestStyle(); // 启用 REST 风格
            })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎
            .execute(); // 执行生成
}
}
