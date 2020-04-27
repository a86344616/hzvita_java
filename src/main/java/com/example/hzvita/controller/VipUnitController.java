package com.example.hzvita.controller;

import com.example.hzvita.Dao.OrganizationPersonnelDao;
import com.example.hzvita.Dao.VipUnitDao;
import com.example.hzvita.bean.VipIntroduction;
import com.example.hzvita.bean.VipUnit;
import com.example.hzvita.utils.FileUploadUtil;
import com.example.hzvita.utils.JsonUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/vipUnit")
public class VipUnitController {

    @Resource
    VipUnitDao vipUnitDao;
    @GetMapping("/getAll")
    public List<VipUnit> getVipUnit(){
        List<VipUnit> vipUnitList = vipUnitDao.findAll();
        return vipUnitList;
    }

    @PostMapping("/add")
    public VipUnit add(
            @RequestBody String json
    ){
        VipUnit vipUnit = null;
        try {
            vipUnit = (VipUnit) JsonUtils.jsonToObj(new VipUnit(),json);
            vipUnitDao.save(vipUnit);
        }catch (Exception e){
            System.out.println(e);
        }
        return vipUnit;
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam("id") int id
    ){
        VipUnit vipUnit = new VipUnit();
        vipUnit.setId(id);
        vipUnitDao.delete(vipUnit);
        return "删除成功";
    }



}
