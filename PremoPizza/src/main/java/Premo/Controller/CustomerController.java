

package Premo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Premo.Model.Customer;
import Premo.Service.*;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    

    
    // display list of customers
    @GetMapping("/customers")
    public String viewCustomerHomePage(Model model) {
        model.addAttribute("listCustomers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model) {
        // create model attribute to bind form data
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }
    

    @GetMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        // save customer to database
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }
    
    /*
    @PostMapping("/saveCustomerAndGoToOrder")
    public String saveCustomerAndGoToOrder(@ModelAttribute("customer") Customer customer) {
        // save customer to database
        customerService.saveCustomer(customer);
        return "redirect:/new_order";
    }
    */

    @GetMapping("/showCustomerFormForUpdate/{phonenumber}")
    public String showFormForUpdate(@PathVariable(value = "phonenumber") String phonenumber, Model model) {

        // get customer from the service
        Customer customer = customerService.getCustomerById(phonenumber);

        // set customer as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        return "update_customer";
    }

    @GetMapping("/deleteCustomer/{phonenumber}")
    public String deleteCustomer(@PathVariable(value = "phonenumber") String phonenumber) {

        // call delete customer method 
        this.customerService.deleteCustomerById(phonenumber);
        return "redirect:/customers";
    }
}