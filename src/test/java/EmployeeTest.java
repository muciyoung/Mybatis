import cn.edu.svtcc.dao.EmployeeDao;
import cn.edu.svtcc.entity.Employee;
import cn.edu.svtcc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;

public class EmployeeTest {
    /**
     * 根据id查询员工信息
     * @throws IOException
     */
    @Test
    public void testSelectEmployeeById() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = employeeDao.selectEmployeeById(1L);
        sqlSession.close();
        System.out.println(employee);
    }

    /**
     * 添加员工
     * @throws IOException
     */
    @Test
    public void testAddEmployee() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setName("何强");
        employee.setAge(18);
        employee.setPosition("项目经理");
        int num = employeeDao.addEmployee(employee);
        sqlSession.commit();
        if (num>0){
            System.out.println("添加成功！！");
        }else{
            System.out.println("添加失败！！");
        }
    }

    /**
     * 修改员工信息
     * @throws IOException
     */
    @Test
    public void testUpdateEmployee() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        int num = employeeDao.updateEmployee(new Employee(5L, "", null, "6"));
        sqlSession.commit();
        if (num>0){
            System.out.println("更新"+num+"条数据成功！！");
        }else {
            System.out.println("更新"+num+"条数据,更新失败！！");
        }
       sqlSession.close();
    }

    /**
     * 删除员工信息
     * @throws IOException
     */
    @Test
    public void testDeleteEmployee() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        int num = employeeDao.deleteEmployee(3L);
        sqlSession.commit();
        if (num>0){
            System.out.println("删除"+num+"条数据成功！！");
        }else {
            System.out.println("删除"+num+"条数据,更新失败！！");
        }
        sqlSession.close();
    }
}
