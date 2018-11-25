package com.datahack.k8sms.promos.promosApi.application;

import com.datahack.k8sms.promos.domain.exception.PromoDoesNotExistsException;
import com.datahack.k8sms.promos.domain.model.Promo;
import com.datahack.k8sms.promos.domain.model.PromoQuery;
import com.datahack.k8sms.promos.promosQuery.QueryServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueryClient {
    private final QueryServer queryServer;

    @Autowired
    public QueryClient(QueryServer queryServer) {
        this.queryServer = queryServer;
    }

    PromoQuery getPromo(String id) throws PromoDoesNotExistsException {
        return queryServer.getPromo(id);
    }

    PromoQuery modifyPromo(Promo promo) {
        return queryServer.modifyPromo(promo);
    }

}
