package cn.edu.svtcc.dao;

import cn.edu.svtcc.entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeDao {
//    根据ID查询员工信息
    public Employee selectEmployeeById( Long id);
//    添加员工信息
    public int addEmployee(Employee employee);
//    修改员工信息
    public int updateEmployee(Employee employee);
//    删除员工信息
    public int deleteEmployee(Long id);


}
