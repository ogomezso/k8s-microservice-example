package com.datahack.k8sms.orders.ordersApi.application;

import com.datahack.k8sms.orders.domain.exception.PromoNotAvailableException;
import com.datahack.k8sms.orders.domain.model.OrderCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class OrderCommandProcessorTest {

    private final PodamFactory podamFactory = new PodamFactoryImpl();

    @Mock
    OrderValidator mockOrdersValidator;

    @Mock
    CommandClient mockCommandClient;

    @InjectMocks
    ClientOrderProcessor underTest;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void given_validatedClientOrder__when_processClientOrder_returnClientOrder() throws PromoNotAvailableException {


        OrderCommand expected = podamFactory.manufacturePojo(OrderCommand.class);
        when(mockOrdersValidator.validatePromo(any())).thenReturn(true);
        when(mockCommandClient.createCommand(any())).thenReturn(expected);
        OrderCommand actual = underTest.processClientOrder(expected);

        assertEquals(expected.getClientId(),actual.getClientId());
        assertEquals(expected.getPromoId(), actual.getPromoId());
        assertEquals(expected.getQuantity(),actual.getQuantity());
    }

    @Test(expected = PromoNotAvailableException.class)
    public void given_NotValidatedClientOrder__when_processClientOrder_throwsPromoNotAvailableException() throws PromoNotAvailableException {


        OrderCommand expected = podamFactory.manufacturePojo(OrderCommand.class);
        when(mockOrdersValidator.validatePromo(any())).thenReturn(false);
        OrderCommand actual = underTest.processClientOrder(expected);
    }
}