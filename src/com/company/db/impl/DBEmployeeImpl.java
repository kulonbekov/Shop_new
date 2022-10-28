package com.company.db.impl;

import com.company.db.DBEmployee;
import com.company.db.DBGetConnection;
import com.company.models.Employee;
import com.company.models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBEmployeeImpl implements DBEmployee {

    DBGetConnection dbGetConnection = new DBGetConnectionImpl();
    @Override
    public void insertEmployee(Employee employee) {
        try {
            PreparedStatement ps = dbGetConnection.getConnection("Insert into tb_employee(numberEmployee, name, age) Values (?,?,?)");
            ps.setInt(1,employee.getNumberEmployee());
            ps.setString(2, employee.getName());
            ps.setInt(3, employee.getAge());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throw  new RuntimeException("Произошла ошибка при сохранении преподавателя");
        }
    }

    @Override
    public List<Employee> selectAllEmployee() {

        try {
            PreparedStatement ps = dbGetConnection.getConnection("select * from tb_employee");
            ResultSet resultSet = ps.executeQuery();
            List<Employee> employees=new ArrayList<>();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setNumberEmployee(resultSet.getInt("numberEmployee"));
                employee.setName(resultSet.getString("name"));
                employee.setAge(resultSet.getInt("age"));
                employees.add(employee);
            }
            return employees;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка");
        }
    }

    @Override
    public void updateEmployee(Long id, int numberEmployee, String name, int age) {

        try {
            PreparedStatement ps = dbGetConnection.getConnection("Update tb_employee set numberEmployee = ? name =?, age = ? where id =?");
            ps.setInt(1, numberEmployee);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setInt(4, Math.toIntExact(id));
            ps.executeUpdate();

        }  catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при изменения данных преподавателя");
        }
    }

    @Override
    public void deleteEmployee(Long id) {

        try {
            PreparedStatement ps = dbGetConnection.getConnection("Delete from tb_employee where id = ?");
            ps.setInt(1, Math.toIntExact(id));
            int result = ps.executeUpdate();
            System.out.println(result);

            if(result==1){
                System.out.println("Объект успешно удален");
            }else if(result==0){
                System.out.println(" Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при удалении ");
        }

    }
}
