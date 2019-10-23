package org.xiaoh.data.openapi.auth.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.xiaoh.data.openapi.auth.domain.PriorityDO;

/**
 * 
 * @Description: 权限Mapper组件
 * @author pengyc
 * @date 2019年10月18日
 *
 */
@Mapper
public interface PriorityMapper
{
 
    /**
     * @Description: 查询根权限
     * @return 根权限集合
     */
    @Select("SELECT id,code,url,priority_comment," + "priority_type,parent_id,gmt_create,gmt_modified "
            + "FROM auth_priority " + "WHERE parent_id IS NULL ")
    @Results(
    { @Result(column = "id", property = "id", id = true), @Result(column = "code", property = "code"),
            @Result(column = "url", property = "url"),
            @Result(column = "priority_comment", property = "priorityComment"),
            @Result(column = "priority_type", property = "priorityType"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified") })
    List<PriorityDO> listRootPriorities();
    
    /**
     * 
     * @Description: 根据权限ID删除权限
     * @param Id
     */
    @Delete("DELETE FROM auth_priority WHERE id =#{id}")
    Boolean removePriority(@Param("id") Long Id);
    
    
    /**
     * 
     * @Description: 根据父id查询子权限
     * @param 父id
     * @return 子权限集合
     */
    @Select("SELECT id,"
                + "code,"
                + "url,"
                + "priority_comment,"
                + "priority_type,"
                + "parent_id,"
                + "gmt_create,"
                + "gmt_modified "
            + "FROM auth_priority "
            + "WHERE parent_id = #{parentId}")
    @Results({
        @Result(column = "id", property = "id", id = true), @Result(column = "code", property = "code"),
        @Result(column = "url", property = "url"),
        @Result(column = "priority_comment", property = "priorityComment"),
        @Result(column = "priority_type", property = "priorityType"),
        @Result(column = "parent_id", property = "parentId"),
        @Result(column = "gmt_create", property = "gmtCreate"),
        @Result(column = "gmt_modified", property = "gmtModified")
    })
    List<PriorityDO> listchildPriorities(@Param("parentId") Long parentId);
    
    /**
     * 
     * @Description: 根据ID查询权限
     * @param 权限
     */
    @Select("SELECT "
                + "id,"
                + "code,"
                + "url,"
                + "priority_comment,"
                + "priority_type,"
                + "parent_id,"
                + "gmt_create,"
                + "gmt_modified "
            + "FROM auth_priority "
            + "WHERE id = #{id}")
    @Results({
        @Result(column = "id", property = "id", id = true), @Result(column = "code", property = "code"),
        @Result(column = "url", property = "url"),
        @Result(column = "priority_comment", property = "priorityComment"),
        @Result(column = "priority_type", property = "priorityType"),
        @Result(column = "parent_id", property = "parentId"),
        @Result(column = "gmt_create", property = "gmtCreate"),
        @Result(column = "gmt_modified", property = "gmtModified")
    })
    PriorityDO getPriorityById(@Param("id") Long Id);
    
    /**
     * @Description: 新增权限
     * @param priorityDO 
     */
    @Insert("INSERT INTO auth_priority("
                + "code,"
                + "url,"
                + "priority_comment,"
                + "priority_type,"
                + "parent_id,"
                + "gmt_create,"
                + "gmt_modified"
            + ") "
            + "VALUES("
                + "#{code},"
                + "#{url},"
                + "#{priorityComment},"
                + "#{priorityType},"
                + "#{parentId},"
                + "#{gmtCreate},"
                + "#{gmtModified}"
                + ")")
    @Options(keyColumn = "id",keyProperty = "id", useGeneratedKeys = true)
    void savePriority(PriorityDO priorityDO);
    
    /**
     * 
     * @Description: 更新权限
     * @param priorityDO
     */
    @Update("UPDATE auth_priority SET "
            + "code = #{code}, "
            + "url = #{url}, "
            + "priority_comment = #{priorityComment}, "
            + "priority_type = #{priorityType}, gmt_modified = #{gmtModified} WHERE id = #{id}")
    void updatePriority(PriorityDO priorityDO);
}
