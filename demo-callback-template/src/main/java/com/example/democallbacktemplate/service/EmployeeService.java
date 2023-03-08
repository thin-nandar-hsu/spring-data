package com.example.democallbacktemplate.service;

import com.example.democallbacktemplate.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    // Update
    public void creatEmployee(Employee emp){
        jdbcTemplate.update("""
            insert into employee (id,first_name,last_name,email,salary) 
            values (?,?,?,?,?)""",emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getSalary());

    }


    //  Native Way
    public double avgNativeWay(){
        return jdbcTemplate.queryForObject("select avg(salary) from employee",Double.class);
    }


    // Modern Way
    public double avgModernWay(){
        return jdbcTemplate.query("select * from employee",this::mapEmployee)
                .stream()
                .map(Employee::getSalary)
                .mapToDouble(s->s)
                .average().orElse(0);
    }


    // Row Mapper
    public List<Employee> listForEmployee(){
        return jdbcTemplate.query("select * from employee",

                this::mapEmployee                // MethodReference    *RowMap
                // (a,b) -> mapEmployee(a,b)      *LambdaExpression

        );
    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet rs,int i){         //RowMapper  -- stateless
        return new Employee(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getDouble("salary")
        );

    }


    // RowCallBackHandler
    public double avgRollCallBackHandler(){
        CustomRowCallBackHandler rowCallBackHandler= new CustomRowCallBackHandler();
        jdbcTemplate.query("select salary from employee", rowCallBackHandler);
        return rowCallBackHandler.averageSalary();
    }




    //ResultSetExtractor
    public double avgResultSetExtractor(){
        CustomResultExtractor resultExtractor = new CustomResultExtractor();
        return jdbcTemplate.query("select salary from employee",resultExtractor);
    }





    //RowCallBackHandler
    class CustomRowCallBackHandler implements RowCallbackHandler{     //RowCallBackHandler --- stateful

        double total;
        int count;
        @Override
        public void processRow(ResultSet rs) throws SQLException {
           total += rs.getDouble("salary");          // += is the auto-cast , auto-convector
            count ++;

        }
        public double averageSalary(){
            return total/count;
        }
    }




    //ResultSetExtractor      --- stateless
    class CustomResultExtractor implements ResultSetExtractor<Double>{

        @Override
        public Double extractData(ResultSet rs) throws SQLException, DataAccessException {
           double total = 0;
           int count = 0;
           while (rs.next()){
               total+=rs.getDouble("salary");
               count++;
           }
            return total / count;
        }
    }


}
