package cn.ghy.ef.mapper;

import cn.ghy.ef.model.post;
import cn.ghy.ef.model.postExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface postMapper {
    int countByExample(postExample example);

    int deleteByExample(postExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(post record);

    int insertSelective(post record);

    List<post> selectByExample(postExample example);

    post selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") post record, @Param("example") postExample example);

    int updateByExample(@Param("record") post record, @Param("example") postExample example);

    int updateByPrimaryKeySelective(post record);

    int updateByPrimaryKey(post record);
}