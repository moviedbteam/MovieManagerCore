package com.bcefit.projet.service.user;

import com.bcefit.projet.domain.user.StreamingSubscription;

public interface IStreamingSubscriptionService {

    Iterable<StreamingSubscription> findAll();

    StreamingSubscription findById(Long id);
}
