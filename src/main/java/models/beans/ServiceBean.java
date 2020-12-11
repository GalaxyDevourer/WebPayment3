package models.beans;

import database.implementation.ServiceDAO;
import models.entities.Service;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean("serviceBean")
@SessionScoped
public class ServiceBean implements Serializable {
    private ServiceDAO serviceDAO;
    private Service service;

    public ServiceBean () {
        this.serviceDAO = new ServiceDAO();
    }

    public List<Service> getServices() {
        return serviceDAO.select();
    }

    public String updateService() {
        if(service.getId() == null) {
            serviceDAO.checkPersist(service);
        } else {
            serviceDAO.update(service);
        }
        return "services";
    }

    public String deleteService() {
        serviceDAO.delete(service);
        return "services";
    }

    public ServiceDAO getServiceDAO() {
        return serviceDAO;
    }

    public void setServiceDAO(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
