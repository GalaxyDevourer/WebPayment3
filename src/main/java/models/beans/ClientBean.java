package models.beans;

import database.implementation.ClientDAO;
import models.entities.Client;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean("clientBean")
@SessionScoped
public class ClientBean implements Serializable {
    private ClientDAO clientDAO;
    private Client client;

    public ClientBean () {
        this.clientDAO = new ClientDAO();
    }

    public List<Client> getClients() {
        return clientDAO.select();
    }

    public String updateClient() {
        if(client.getId() == null) {
            clientDAO.checkPersist(client);
        } else {
            clientDAO.update(client);
        }
        return "clients";
    }

    public String deleteClient() {
        clientDAO.delete(client);
        return "clients";
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
