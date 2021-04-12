package Premo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import Premo.Model.Employee;
import Premo.Service.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "home";
    }
    
    @GetMapping("/new_order")
    public String viewOrderPage(Model model) {
        return "new_order";
    }

    // display list of employees
    @GetMapping("/employees")
    public String viewEmployeeHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/showEmployeeFormForUpdate/{employeeid}")
    public String showFormForUpdate(@PathVariable(value = "employeeid") long employeeid, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmployeeById(employeeid);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{employeeid}")
    public String deleteEmployee(@PathVariable(value = "employeeid") long employeeid) {

        // call delete employee method 
        this.employeeService.deleteEmployeeById(employeeid);
        return "redirect:/employees";
    }
}
