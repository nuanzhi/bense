package com.lsege.service.servicep;

import com.lsege.entity.servicep.Distributor;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/26.
 */
public interface DistributorService {

    Distributor addDistributorDistributor (Distributor d);

    List<Distributor> getDisList();

    Long getDisTotel();
}
