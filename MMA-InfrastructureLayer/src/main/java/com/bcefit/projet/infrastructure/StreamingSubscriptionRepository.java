package com.bcefit.projet.infrastructure;

import com.bcefit.projet.domain.user.StreamingSubscription;
import org.springframework.data.repository.CrudRepository;

public interface StreamingSubscriptionRepository extends CrudRepository<StreamingSubscription, Long> {
}
