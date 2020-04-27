package com.example.hzvita.controller;

import com.example.hzvita.Dao.OrganizationPersonnelDao;
import com.example.hzvita.bean.OrganizationPersonnel;
import com.example.hzvita.utils.JsonUtils;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("organization")
public class OrganizationPersonnelController {
    @Resource
    OrganizationPersonnelDao organizationPersonnelDao;


    //获取所有组织人员信息
    @GetMapping("/getAll")
    public List<OrganizationPersonnel> getOrganizationPersonnel() {
        List<OrganizationPersonnel> organizationPersonnelList = organizationPersonnelDao.findAll();
        return organizationPersonnelList;
    }

    //添加组织人员信息
    @PostMapping("/add")
    public OrganizationPersonnel add(
            @RequestBody String json
    ) {
        OrganizationPersonnel organizationPersonnel = null;
        try {
            organizationPersonnel = (OrganizationPersonnel) JsonUtils.jsonToObj(new OrganizationPersonnel(), json);
            organizationPersonnelDao.save(organizationPersonnel);
        } catch (Exception e) {
            System.out.println(e);
        }
        return organizationPersonnel;
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam("/id") int id
    ){
        OrganizationPersonnel organizationPersonnel = new OrganizationPersonnel();
        organizationPersonnel.setId(id);
        organizationPersonnelDao.delete(organizationPersonnel);
        return "删除成功";
    }
}
