package com.lsege.controller.servicep;

import com.google.gson.reflect.TypeToken;
import com.lsege.controller.BaseController;
import com.lsege.entity.JsonResult;
import com.lsege.entity.Page;
import com.lsege.entity.servicep.Distributor;
import com.lsege.entity.sys.User;
import com.lsege.service.servicep.DistributorService;
import com.lsege.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by xuzhongyao on 2017/5/26.
 */
@RestController
@RequestMapping(value ="/distributor")
public class DistributorController extends BaseController{

    @Autowired
    DistributorService distributorService;

    @PostMapping(value = "/addDistributor")
    public JsonResult addDistributor(Distributor d, HttpServletRequest request){
        Map<String, Object> redisUserInfo = getRedisUser(request);
        Long uId = redisUserInfo.get("uId") != null ? (Long) redisUserInfo.get("uId") : null;
        d.setCreator(uId);
        d = distributorService.addDistributorDistributor(d);
        JsonResult json = new JsonResult();
        json.setData(d);
        json.setSuccess(true);
        json.setMessage("录入成功");
        return json;
    }

    @GetMapping(value = "/getDisList")
    public JsonResult getDisList(Integer pageNum,Integer pageSize){
        JsonResult<Page> json = new JsonResult<>();
        List<Distributor> dlist = distributorService.getDisList();
        Long total = distributorService.getDisTotel();
        json.setMessage("查询成功");
        json.setSuccess(true);
        json.setData(new Page<Distributor>(dlist,total,pageSize,pageNum));
        return json;
    }


}
