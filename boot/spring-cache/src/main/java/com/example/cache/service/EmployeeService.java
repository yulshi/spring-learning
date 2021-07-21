package com.example.cache.service;

import com.example.cache.bean.Employee;
import com.example.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author yulshi
 * @create 2020/06/06 14:54
 */
@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp", key = "#id")
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id + "号员工");
        Employee employee = employeeMapper.getEmployee(id);
        return employee;
    }

    /**
     * 使用write-through方式更新缓存
     * <p>
     * 即，先调用方法更新数据库，再更新缓存
     *
     * @param employee
     * @return
     */
    @CachePut(value = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emp", key = "#id")
    public String deleteEmp(Integer id) {
        employeeMapper.deleteEmployee(id);
        return "success";
    }

    @Qualifier("cacheManager")
    @Autowired
    CacheManager cacheManager;

    public Employee getEmp2(Integer id) {

        Cache cache = cacheManager.getCache("emp");

        String key = Integer.toString(id);

        Cache.ValueWrapper valueWrapper = cache.get(key);
        if (valueWrapper != null) {
            return (Employee) valueWrapper.get();
        } else {
            Employee employee = employeeMapper.getEmployee(id);
            if (employee != null) {
                cache.put(key, employee);
            }
            return employee;
        }

    }

}
