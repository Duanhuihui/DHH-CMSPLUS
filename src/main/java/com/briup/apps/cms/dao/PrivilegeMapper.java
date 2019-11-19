package com.briup.apps.cms.dao;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.PrivilegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    long countByExample(PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    int deleteByExample(PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    int insert(Privilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    int insertSelective(Privilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    List<Privilege> selectByExample(PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    Privilege selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    int updateByExampleSelective(@Param("record") Privilege record, @Param("example") PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    int updateByExample(@Param("record") Privilege record, @Param("example") PrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    int updateByPrimaryKeySelective(Privilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_privilege
     *
     * @mbg.generated Wed Nov 13 18:27:57 CST 2019
     */
    int updateByPrimaryKey(Privilege record);
}