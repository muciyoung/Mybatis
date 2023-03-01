package cn.edu.svtcc.controller;

import cn.edu.svtcc.dao.EmployeeDao;
import cn.edu.svtcc.entity.Employee;
import cn.edu.svtcc.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeService {
    /**
     * 根据ID查询员工信息
     * @param id
     * @throws IOException
     */
    public void testSelectEmployeeById(Long id) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = employeeDao.selectEmployeeById(id);
        sqlSession.close();
        System.out.println(employee);
    }

    /**
     * 添加员工信息
     * @throws IOException
     */
    public void testAddEmployee(String name,Integer age,String position) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        employee.setPosition(position);
        int num = employeeDao.addEmployee(employee);
        sqlSession.commit();
        if (num>0){
            System.out.println("添加成功！！");
        }else{
            System.out.println("添加失败！！");
        }
    }

    /**
     * 根据ID修改员工信息
     * @throws IOException
     */
    public void testUpdateEmployee(Long id,String name,int age,String position) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        int num = employeeDao.updateEmployee(new Employee(id, name, age, position));
        sqlSession.commit();
        if (num>0){
            System.out.println("更新"+num+"条数据成功！！");
        }else {
            System.out.println("更新"+num+"条数据,更新失败！！");
        }
        sqlSession.close();
    }

    /**
     * 根据ID删除员工信息
     * @param id
     * @throws IOException
     */
    public void testDeleteEmployee(Long id) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
        int num = employeeDao.deleteEmployee(id);
        sqlSession.commit();
        if (num>0){
            System.out.println("删除"+num+"条数据成功！！");
        }else {
            System.out.println("删除"+num+"条数据,更新失败！！");
        }
        sqlSession.close();
    }



    public static void main(String[] args) throws IOException {
        int a = 0;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请键入你的操作：\n1.查询员工信息\n2.新增员工信息\n3.修改员工信息\n4.删除员工信息\n5.退出程序");
            a= sc.nextInt();
            switch(a){
                case 1://根据ID查询员工信息
                    EmployeeService employeeService = new EmployeeService();
                    System.out.println("请输入员工ID：");
                    long nextLong = sc.nextLong();
                    employeeService.testSelectEmployeeById(nextLong);
                    break;
                case 2://新增员工信息
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("输入新增员工姓名：");
                    String name = sc1.next();
                    System.out.println("输入新增员工年龄：");
                    int age = sc1.nextInt();
                    System.out.println("输入新增员工职位：");
                    String position = sc1.next();
                    EmployeeService employeeService1 = new EmployeeService();
                    employeeService1.testAddEmployee(name,age,position);
                    break;
                case 3://根据ID修改员工信息
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("输入你想要修改的员工信息的ID：");
                    long id = sc2.nextLong();
                    System.out.println("输入你想要修改的员工信息的姓名：");
                    String name1 = sc2.next();
                    System.out.println("输入你想要修改的员工信息的年龄：");
                    int age1 = sc2.nextInt();
                    System.out.println("输入你想要修改的员工信息的职位：");
                    String position1 = sc2.next();
                    EmployeeService employeeService2 = new EmployeeService();
                    employeeService2.testUpdateEmployee(id,name1,age1,position1);
                    break;
                case 4://根据ID删除员工信息
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("输入你想要删除的员工的ID：");
                    long id3 = sc3.nextLong();
                    EmployeeService employeeService3 = new EmployeeService();
                    employeeService3.testDeleteEmployee(id3);
                    break;
                case 5://退出程序
                    System.exit(0);
                    break;
                default:
                    System.err.println(" not found error！！");
                    break;
            }
        }
    }
}
