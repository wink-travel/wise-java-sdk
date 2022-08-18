/*
 * Copyright (c) 2022. Wink
 */

package com.wise.sdk;

import com.wise.sdk.api.AffiliatesApi;
import com.wise.sdk.model.GetPriceComparison200Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Quick ping integration test
 *
 * @author Bjorn Harvold Responsibility:
 */
@Slf4j
@Disabled("Needs an API key to run")
@ContextConfiguration(classes = {WiseSdkConfiguration.class})
@ExtendWith(SpringExtension.class)
@ActiveProfiles({"sandbox"})
class WiseIntegrationTest {

    @Autowired
    private AffiliatesApi affiliatesApi;

//    @BeforeEach
//    public void setUp() {
//
//    }
//
//    @AfterEach
//    public void tearDown() {
//
//    }

    @Test
    void givenWiseAccount_whenRetrievingExchangeRates_thenVerify() {
        try {
            log.info("Testing retrieving Stripe balance...");

            Mono<ResponseEntity<Void>> response = this.affiliatesApi.getExchangeRateHistoryWithHttpInfo("EUR", "USD", null, null, null);
            assertNotNull(response, "balance should not be null");

            StepVerifier
                    .create(response)
                    .assertNext(comparison -> {
                        assertNotNull(response, "response should not be null");
                    })
                    .expectComplete()
                    .verify();

            log.info("Testing retrieving Stripe balance COMPLETE");
        } catch (Exception ex) {
            fail(ex.getMessage(), ex);
        }
    }

}
