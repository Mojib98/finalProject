package org.project.service.interfaces;

import org.project.entity.RequestForConfirmation;
import org.project.entity.RequestForNewSpecialization;
import org.project.entity.Specialist;

import java.util.List;
import java.util.Properties;

public interface ManageServiceForSpecialist extends GenericService<Specialist> {
    void changeStatus(Specialist specialist);

    //    void changeStatus(Properties properties);
    void acceptRequest(List<RequestForConfirmation> request);
    void unAccept(List<RequestForNewSpecialization> request);
    void changeStatusForRequest(List<RequestForConfirmation> request);
    List<RequestForNewSpecialization> findNewRequest();
    void handleRequestForSpecialization(List<RequestForNewSpecialization> request);
    List<Properties> search(Properties properties);
    List<RequestForConfirmation> RequestList();

}