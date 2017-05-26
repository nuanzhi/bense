package com.lsege.service.servicep;

import com.lsege.entity.servicep.Distributor;
import com.lsege.mapper.servicep.DistributorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/26.
 */
@Service
public class DistributorServiceImpl implements DistributorService {

    @Autowired
    DistributorMapper distributorMapper;


    @Override
    public Distributor addDistributorDistributor(Distributor d) {
        distributorMapper.addDistributorDistributor(d);
        return d;
    }

    @Override
    public List<Distributor> getDisList() {
        return distributorMapper.getDisList();
    }

    @Override
    public Long getDisTotel() {
        return distributorMapper.getDisTotal();
    }
}
