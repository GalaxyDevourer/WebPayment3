package models.beans.old;

import database.implementation.old.ServiceDAO;
import models.entities.old.Service;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("serviceBean")
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
            serviceDAO.insert(service);
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
