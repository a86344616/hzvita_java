package com.example.hzvita.Dao;

import com.example.hzvita.bean.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminInfoDao extends JpaRepository<AdminInfo,Integer> {
    AdminInfo findByUsername(String username);
}
