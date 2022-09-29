package com.giuseppe.bruxelles.drgoodfood.services;

import com.giuseppe.bruxelles.drgoodfood.models.dtos.ClientDTO;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientInsertForm;
import com.giuseppe.bruxelles.drgoodfood.models.forms.ClientUpdateForm;

public interface ClientService extends CRUDService<ClientDTO, Long, ClientInsertForm, ClientUpdateForm> {

}
