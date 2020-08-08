package com.example.cache.mapper;

import com.example.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author yulshi
 * @create 2020/06/06 14:17
 */
@Mapper
public interface EmployeeMapper {

  @Select("SELECT * FROM employee WHERE id=#{id}")
  public Employee getEmployee(Integer id);

  @Update("UPDATE employee " +
          "SET lastName=#{lastName}, " +
          "email=#{email}, " +
          "gender=#{gender}, " +
          "dId=#{dId} " +
          "WHERE id=#{id}")
  public void updateEmp(Employee employee);

  @Delete("DELETE FROM employee WHERE id=#{id}")
  public void deleteEmployee(Integer id);

  @Insert("INSERT INTO employee(lastName,email,gender,dId)" +
          "VALUES(#{lastName},#{email},#{gender},#{dId}")
  public void insertEmployee(Employee employee);

}
