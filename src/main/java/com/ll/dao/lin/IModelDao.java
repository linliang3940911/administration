package com.ll.dao.lin;

import com.ll.pojo.lin.WorkName;
import com.ll.pojo.lin.WorkTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/8 0008$ 21:16$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/8 0008$ 21:16$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Mapper
public interface IModelDao {
    @Select("select text from lin_users where id=1 ")
    String querymodle();
    @Select("select * from ll_workTree where pid=#{id} ")
    List<WorkTree> getQueryTree(Integer id);
    @Select("select * from ll_workname  LIMIT #{offset},#{limit}")
    List<WorkName> queryWork(@Param("offset") int offset, @Param("limit")int limit,@Param("url") String url);
    @Select("select count(*) from ll_workname ")
    long queryCount(@Param("url") String url);
}
