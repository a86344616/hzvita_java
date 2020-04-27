package com.example.hzvita.controller;

import com.example.hzvita.Dao.AdminInfoDao;
import com.example.hzvita.bean.AdminInfo;
import com.example.hzvita.global.GlobalConst;
import com.example.hzvita.utils.CookieUtil;
import com.example.hzvita.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
   /* @GetMapping("/")
    public String hello(){
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setPassword("123");
        return adminInfo.getPassword();
    }*/
    @Resource
    AdminInfoDao adminInfoDao;

    //查询寻所有数据
    @GetMapping("/getAll")
    public List<AdminInfo> getAdminInfos(){
        List<AdminInfo> adminInfos = adminInfoDao.findAll();
        return adminInfos;
    }

    @GetMapping("/loginAdmin")
    @ResponseBody
    public String loginAdmin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpServletResponse response) {
        System.out.println("执行了登陆查询");
        AdminInfo admin = adminInfoDao.findByUsername(username);
        log.info("查询到得admininfo={}", admin);
        if (admin != null && admin.getPassword().equals(password)) {
            String token = UUID.randomUUID().toString();
            log.info("登录成功的token={}", token);
            //有效期2小时
            CookieUtil.set(response, GlobalConst.COOKIE_TOKEN, token, 7200);
            return "登录成功";
        } else {
            return "登陆失败";
        }
    }


    //添加或修改数据
    @PostMapping("/add")
    public AdminInfo add(@RequestBody String json){
        AdminInfo adminInfo = null;
        try {
            adminInfo = (AdminInfo) JsonUtils.jsonToObj(new AdminInfo(),json);
            adminInfoDao.saveAndFlush(adminInfo);
        }catch (Exception e){
            log.info("查询到得错误信息为：", e);
        }
        return adminInfo;
    }

    //删除数据
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setId(id);
        adminInfoDao.delete(adminInfo);
        return "删除成功";
    }

}
