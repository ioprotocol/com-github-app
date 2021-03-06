package com.github.app.api.dao.mapper;

import com.github.app.api.dao.domain.RolePopedom;
import com.github.app.api.dao.domain.RolePopedomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePopedomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated Sat Feb 10 17:25:42 CST 2018
     */
    long countByExample(RolePopedomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated Sat Feb 10 17:25:42 CST 2018
     */
    int deleteByExample(RolePopedomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated Sat Feb 10 17:25:42 CST 2018
     */
    int insert(RolePopedom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated Sat Feb 10 17:25:42 CST 2018
     */
    int insertSelective(RolePopedom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated Sat Feb 10 17:25:42 CST 2018
     */
    List<RolePopedom> selectByExample(RolePopedomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated Sat Feb 10 17:25:42 CST 2018
     */
    int updateByExampleSelective(@Param("record") RolePopedom record, @Param("example") RolePopedomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated Sat Feb 10 17:25:42 CST 2018
     */
    int updateByExample(@Param("record") RolePopedom record, @Param("example") RolePopedomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    RolePopedom selectOneByExample(RolePopedomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsert(@Param("list") List<RolePopedom> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_popedom
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int batchInsertSelective(@Param("list") List<RolePopedom> list, @Param("selective") RolePopedom.Column ... selective);

    void truncate();
}