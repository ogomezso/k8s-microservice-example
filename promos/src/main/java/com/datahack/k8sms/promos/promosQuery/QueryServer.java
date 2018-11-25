package com.datahack.k8sms.promos.promosQuery;


import com.datahack.k8sms.promos.domain.exception.PromoDoesNotExistsException;
import com.datahack.k8sms.promos.domain.model.Promo;
import com.datahack.k8sms.promos.domain.model.PromoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QueryServer {
    private final QueryDas queryDas;

    @Autowired
    public QueryServer(QueryDas queryDas) {
        this.queryDas = queryDas;
    }

    @Transactional
    public PromoQuery getPromo(String id) throws PromoDoesNotExistsException {
        return queryDas.getPromoQuery(id);
    }

    @Transactional
    public PromoQuery modifyPromo(Promo promo) {
        return queryDas.modifyPromo(promo);
    }
}
