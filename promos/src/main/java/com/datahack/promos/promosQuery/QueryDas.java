package com.datahack.promos.promosQuery;

import com.datahack.promos.domain.exception.PromoDoesNotExistsException;
import com.datahack.promos.domain.model.Promo;
import com.datahack.promos.domain.model.PromoQuery;
import com.mongodb.BasicDBObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class QueryDas {
    private final QueryRepository queryRepository;
    private final DocumentMapper mapper;
    private final PromoQueryBuilder promoQueryBuilder;

    @Autowired
    QueryDas(QueryRepository queryRepository, DocumentMapper mapper
            , PromoQueryBuilder promoQueryBuilder) {
        this.queryRepository = queryRepository;
        this.mapper = mapper;
        this.promoQueryBuilder = promoQueryBuilder;
    }

    public PromoQuery saveQueryDocument(PromoQuery promoQuery){
        log.info("Saving: {}",promoQuery);
        PromoQueryDocument document2Save = mapper.domain2Document(promoQuery);
        log.info("Saving document: {}",document2Save);
        PromoQueryDocument docSaved = queryRepository.save(document2Save);
        return mapper.document2Domain(docSaved);
    }

    public PromoQuery getPromoQuery(String id) throws PromoDoesNotExistsException{
        Optional<PromoQueryDocument> dbObj = queryRepository.findById(id);
        return dbObj.map(mapper::document2Domain)
                .orElseThrow(() -> new PromoDoesNotExistsException("Promo not exists"));
    }

    public PromoQuery modifyPromo(Promo promo){
        PromoQuery promoQuery = promoQueryBuilder.build(promo);
        PromoQueryDocument document2Save = mapper.domain2Document(promoQuery);
        PromoQueryDocument docSaved = queryRepository.save(document2Save);
        return mapper.document2Domain(docSaved);
    }

    public void deletePromoQuery(String id) {
        queryRepository.deleteById(id);
        return;
    }
}
