package models.beans.new_;

import database.implementation.new_.ClientsDAO;
import models.entities.new_.ClientsEntity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("clientsBean")
@SessionScoped
public class ClientsBean implements Serializable {
    private ClientsDAO clientsDAO;
    private ClientsEntity client;

    public ClientsBean () {
        this.clientsDAO = new ClientsDAO();
    }

    @PostConstruct
    public void init() {
        client = new ClientsEntity();
    }

    public List<ClientsEntity> getClients() {
        return clientsDAO.select();
    }

    public String updateClient() {
        System.out.println("DEBUG: " + client.toString());
        if(client.getId() == 0) {
            clientsDAO.insert(client);
        } else {
            clientsDAO.update(client);
        }
        return "clients";
    }

    public String deleteClient() {
        clientsDAO.delete(client);
        return "clients";
    }

    public ClientsDAO getClientsDAO() {
        return clientsDAO;
    }

    public void setClientsDAO(ClientsDAO clientsDAO) {
        this.clientsDAO = clientsDAO;
    }

    public ClientsEntity getClient() {
        return client;
    }

    public void setClient(ClientsEntity client) {
        this.client = client;
    }
}
