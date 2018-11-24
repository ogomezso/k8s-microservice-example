package com.datahack.promos.promosQuery;

import com.datahack.promos.domain.model.PromoEvent;
import com.datahack.promos.domain.model.PromoQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueryListener implements ApplicationListener<PromoEvent>
{
    private final PromoQueryBuilder promoQueryBuilder;
    private final QueryDas queryDas;

    QueryListener(PromoQueryBuilder promoQueryBuilder, QueryDas queryDas) {
        this.promoQueryBuilder = promoQueryBuilder;
        this.queryDas = queryDas;
    }

    @Override
    public void onApplicationEvent(PromoEvent promoEvent) {
        switch (promoEvent.getEventType()){
            case CREATED:{
                log.info("Query model receive command event: {}", promoEvent.getEventBody());
                PromoQuery promoQuery = promoQueryBuilder.build(promoEvent.getEventBody());

                queryDas.saveQueryDocument(promoQuery);
                log.info("Document Saved: {}", promoQuery);
                break;
            }
            case DELETED:{
                log.info("Query model receive DELETE event: {}",promoEvent.getPromoId());
                queryDas.deletePromoQuery(promoEvent.getPromoId());
                break;
            }
        }


    }
}
