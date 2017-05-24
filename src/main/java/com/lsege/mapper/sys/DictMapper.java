package com.lsege.mapper.sys;

import com.lsege.entity.sys.DictionaryData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by zhanglei on 2017/5/22.
 */

@Mapper
@Repository(value = "dictMapper")
public interface DictMapper {
    List<Dictionary> selectDictList();
    List<DictionaryData> getDictChild(Long dictValue);

}
