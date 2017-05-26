package com.lsege.mapper.servicep;


import com.lsege.entity.servicep.Distributor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuzhongyao on 2017/5/26.
 */
@Mapper
@Repository(value = "distributorMapper")
public interface DistributorMapper {

    Long addDistributorDistributor (Distributor d);

    List<Distributor> getDisList();

    Long getDisTotal();

}
