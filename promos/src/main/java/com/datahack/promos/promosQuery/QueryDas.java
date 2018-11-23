package com.datahack.promos.promosQuery;

import com.datahack.promos.domain.model.PromoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryDas {
    private final QueryRepository queryRepository;
    private final DocumentMapper mapper;

    @Autowired
    QueryDas(QueryRepository queryRepository, DocumentMapper mapper) {
        this.queryRepository = queryRepository;
        this.mapper = mapper;
    }

    public PromoQuery saveQueryDocument(PromoQuery promoQuery){

        PromoQueryDocument document2Save = mapper.domain2Document(promoQuery);
        PromoQueryDocument docSaved = queryRepository.save(document2Save);
        return mapper.document2Domain(docSaved);
    }
}
