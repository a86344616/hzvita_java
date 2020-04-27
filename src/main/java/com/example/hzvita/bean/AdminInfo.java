package com.example.hzvita.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class AdminInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @CreatedDate//自动添加创建时间的注解
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @LastModifiedDate//自动添加更新时间的注解
    private Date updateTime;
}


