package com.lsege.mapper.sys;

import com.lsege.entity.sys.DictionaryData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.lsege.entity.sys.Dictionary;
import java.util.List;

/**
 * Created by zhanglei on 2017/5/22.
 */

@Mapper
@Repository(value = "dictMapper")
public interface DictMapper {
    List<Dictionary> selectDictList();
    List<DictionaryData> getDictChild(Long dictValue);
    Long insertDict(DictionaryData dictionaryData);
    Long insertTopDict(Dictionary dictionary);
    Long deldict(Long id);
    Long delTopDict(Long dictValue);
    Long getDictChildTotal(Long dictValue);
    Long getDictTotal();
    Long updateDictStates(Long id);

}
