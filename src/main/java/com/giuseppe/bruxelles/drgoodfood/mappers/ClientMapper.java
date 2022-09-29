package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ClientDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Client;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientInsertForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientUpdateForm;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientInsertForm form){

        if(form == null)
            return null;

        Client client = new Client();
        client.setFirstName(form.getFirstName());
        client.setLastName(form.getLastName());
        client.setDateOfBirth(form.getDateOfBirth());
        client.setNickname(form.getNickname());
        client.setMailAddress(form.getMailAddress());
        client.setCreditCard(form.getCreditCard());

        return client;

    }

    public Client toEntity(ClientUpdateForm form){

        if(form == null)
            return null;

        Client client = new Client();
        client.setFirstName(form.getFirstName());
        client.setLastName(form.getLastName());
        client.setDateOfBirth(form.getDateOfBirth());
        client.setNickname(form.getNickname());
        client.setMailAddress(form.getMailAddress());
        client.setCreditCard(form.getCreditCard());

        return client;

    }

    public ClientDTO toDto(Client entity) {

        if(entity == null)
            return null;

        return ClientDTO.builder()
                .id(entity.getClientId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .dateOfBirth(entity.getDateOfBirth())
                .nickname(entity.getNickname())
                .mailAddress(entity.getMailAddress())
                .creditCard(entity.getCreditCard())
                .address(entity.getAddress())
                .status(entity.getStatus())
                .consultations(entity.getConsultations())
                .subscription(entity.getSubscription())
                .orders(entity.getOrders())
                .build();

    }
}
