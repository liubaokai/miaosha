package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.UserPasswordDO;
import com.miaoshaproject.dataobject.UserPasswordDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component(value ="UserPasswordDOMapper ")
public interface UserPasswordDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    long countByExample(UserPasswordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    int deleteByExample(UserPasswordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    int insert(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    int insertSelective(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    List<UserPasswordDO> selectByExample(UserPasswordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    UserPasswordDO selectByPrimaryKey(Integer id);

    UserPasswordDO selectByUserId(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserPasswordDO record, @Param("example") UserPasswordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    int updateByExample(@Param("record") UserPasswordDO record, @Param("example") UserPasswordDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    int updateByPrimaryKeySelective(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon Jun 17 16:06:17 CST 2019
     */
    int updateByPrimaryKey(UserPasswordDO record);
}