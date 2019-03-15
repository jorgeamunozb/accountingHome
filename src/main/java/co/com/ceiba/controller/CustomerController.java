package co.com.ceiba.controller;

import co.com.ceiba.model.Customer;
import co.com.ceiba.view.CustomerView;

public class CustomerController {

    //objetos customerView y customerModel
    private CustomerView customerView;
    private Customer customerModel;

    //constructor para inicializar el customerModel y la customerView
    public CustomerController(Customer customerModel, CustomerView customerView) {
        this.customerModel = customerModel;
        this.customerView = customerView;
    }

    //getters y setters para el customerModel
    public int getId() {
        return customerModel.getId();
    }

    public void setId(int id) {
        this.customerModel.setId(id);
    }

    public String getNombre() {
        return customerModel.getFirstName();
    }

    public void setNombre(String nombre) {
        this.customerModel.setFirstName(nombre);
    }

    public String getApellido() {
        return customerModel.getLastName();
    }

    public void setApellido(String apellido) {
        this.customerModel.setLastName(apellido);
    }

    //pasa el customerModel a la customerView para presentar los datos
    public void actualizarVista() {
        customerView.imprimirDatosCliente(customerModel.getId(), customerModel.getFirstName(), customerModel.getLastName());
    }

}
