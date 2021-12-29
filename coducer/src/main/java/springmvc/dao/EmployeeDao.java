package springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import springmvc.pojo.Employee;  

public class EmployeeDao {
	
	private HibernateTemplate hibernateTemplate; 

	public void sethibernateTemplate(HibernateTemplate hibernateTemplate) {  
	    this.hibernateTemplate = hibernateTemplate;  
	}  
	
	@Transactional
	public String saveEmployee(Employee e) {
		String i = (String) this.hibernateTemplate.save(e);
		return i;
	}
	
	
	public Employee getLoginDetails(String email){
		Employee emp = this.hibernateTemplate.get(Employee.class, email);
		return emp;
	}
	
//private JdbcTemplate jdbcTemplate;  
  
/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
} */ 

/*public int saveEmployee(Employee e){  
    String query="insert into yogi.employee values('"+e.getFirstName()+"','"+e.getLastName()+"','"+e.getEmail()+"','"+e.getContact()+"','"+e.getPassword()+"')";  
    return jdbcTemplate.update(query);  
}  
public int updateEmployee(Employee e){  
    String query="update yogi.employee set first_name='"+e.getFirstName()+"',last_name='"+e.getLastName()+"',contact='"+e.getContact()+"',password='"+e.getPassword()+"' where email='"+e.getEmail()+"' "; 
    return jdbcTemplate.update(query);  
}  
public int deleteEmployee(Employee e){  
    String query="delete from yogi.employee where email='"+e.getEmail()+"' ";  
    return jdbcTemplate.update(query);  
}  

public List<?> showAllEmployee(){
	return jdbcTemplate.queryForList("select first_name,last_name,email,contact,password from yogi.employee");
}

public List<?> getLoginDetails(Employee e){
	return jdbcTemplate.queryForList("select first_name,last_name,contact,password from yogi.employee where email='"+e.getEmail()+"'");
}*/
}  