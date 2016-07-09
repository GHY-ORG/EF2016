package cn.ghy.ef.mapper;

import cn.ghy.ef.model.user_role;
import cn.ghy.ef.model.user_roleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface user_roleMapper {
    int countByExample(user_roleExample example);

    int deleteByExample(user_roleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(user_role record);

    int insertSelective(user_role record);

    List<user_role> selectByExample(user_roleExample example);

    user_role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") user_role record, @Param("example") user_roleExample example);

    int updateByExample(@Param("record") user_role record, @Param("example") user_roleExample example);

    int updateByPrimaryKeySelective(user_role record);

    int updateByPrimaryKey(user_role record);
}