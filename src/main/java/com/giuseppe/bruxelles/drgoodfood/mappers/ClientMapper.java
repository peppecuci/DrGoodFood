package com.giuseppe.bruxelles.drgoodfood.mappers;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ClientDTO;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Address;
import com.giuseppe.bruxelles.drgoodfood.models.entities.Client;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientForm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    private final AddressMapper addressMapper;

    public ClientMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Client toEntity(ClientForm form){

        if(form == null)
            return null;

        Client client = new Client();
        Address address = new Address();

        client.setFirstName(form.getFirstName());
        client.setLastName(form.getLastName());
        client.setSex(form.getSex());
        client.setUsername(form.getUsername());
        client.setPassword(form.getPassword());
        client.setMailAddress(form.getMailAddress());

        address.setNum(form.getAddress().getNum());
        address.setStreet(form.getAddress().getStreet());
        address.setZipCode(form.getAddress().getZipCode());
        address.setCity(form.getAddress().getCity());

        client.setAddress(address);

        return client;
    }


    public ClientDTO toDto(Client entity) {
        if(entity == null)
            return null;

        return ClientDTO.builder()
                .id(entity.getClientId())
                .username(entity.getUsername())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .sex(entity.getSex())
                .mailAddress(entity.getMailAddress())
                .creditCard(entity.getCreditCard())
                .address( addressMapper.toDto(entity.getAddress()) )
                .status(entity.getStatus())
                .enabled(entity.isEnabled())
                .roles(entity.getRoles())
//               TODO .consultations(entity.getConsultations())
//                .subscription(entity.getSubscription())
//                .orders(entity.getOrders())
                .build();

    }
}
