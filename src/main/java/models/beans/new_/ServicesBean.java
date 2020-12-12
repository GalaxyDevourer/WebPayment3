package models.beans.new_;

import database.implementation.new_.ServicesDAO;
import models.entities.new_.ServicesEntity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("servicesBean")
@SessionScoped
public class ServicesBean implements Serializable {
    private ServicesDAO servicesDAO;
    private ServicesEntity service;

    public ServicesBean () {
        this.servicesDAO = new ServicesDAO();
    }

    @PostConstruct
    public void init() {
        service = new ServicesEntity();
    }

    public List<ServicesEntity> getServices() {
        return servicesDAO.select();
    }

    public String updateServices() {
        System.out.println("DEBUG: " + service.toString());
        if(service.getId() == 0) {
            servicesDAO.insert(service);
        } else {
            servicesDAO.update(service);
        }
        return "clients";
    }

    public String deleteServices() {
        servicesDAO.delete(service);
        return "clients";
    }

    public ServicesDAO getServicesDAO() {
        return servicesDAO;
    }

    public void setServicesDAO(ServicesDAO servicesDAO) {
        this.servicesDAO = servicesDAO;
    }

    public ServicesEntity getService() {
        return service;
    }

    public void setService(ServicesEntity service) {
        this.service = service;
    }
}
