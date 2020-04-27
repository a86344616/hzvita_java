package com.example.hzvita.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class VipUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String site;
    private String telephone;


    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @CreatedDate//自动添加创建时间的注解
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @LastModifiedDate//自动添加更新时间的注解
    private Date updateTime;
}
