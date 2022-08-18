package com.wise.sdk;

import com.wise.sdk.api.AffiliatesApi;
import com.wise.sdk.api.Class1TransferFlowApi;
import com.wise.sdk.api.Class1aSelectExistingApi;
import com.wise.sdk.api.Class2ChooseCreateRecipientApi;
import com.wise.sdk.api.PayoutsAndAccountAutomationApi;
import com.wise.sdk.api.ReceiveMoneyApi;
import com.wise.sdk.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created on: 8/18/22.
 *
 * @author Bjorn Harvold
 * Responsibility:
 */
@Configuration
public class WiseSdkConfiguration {

    @Value("${wise.api.url:https://api.sandbox.transferwise.tech}")
    private String wiseBaseUrl;

    @Value("${wise.api.key}")
    private String apiKey;

    @Bean(name = "webClient")
    WebClient webClient() {
        return WebClient.builder()
                .baseUrl(this.wiseBaseUrl)
                .defaultHeaders(headers -> headers.setBearerAuth(this.apiKey))
                .build();
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient(webClient());
    }

    @Bean(name = "affiliatesApi")
    public AffiliatesApi affiliatesApi() {
        return new AffiliatesApi(apiClient());
    }

    @Bean(name = "selectExistingApi")
    public Class1aSelectExistingApi selectExistingApi() {
        return new Class1aSelectExistingApi(apiClient());
    }

    @Bean(name = "transferFlowApi")
    public Class1TransferFlowApi transferFlowApi() {
        return new Class1TransferFlowApi(apiClient());
    }

    @Bean(name = "createRecipientApi")
    public Class2ChooseCreateRecipientApi createRecipientApi() {
        return new Class2ChooseCreateRecipientApi(apiClient());
    }

    @Bean(name = "createRecipientApi")
    public PayoutsAndAccountAutomationApi payoutsApi() {
        return new PayoutsAndAccountAutomationApi(apiClient());
    }

    @Bean(name = "receiveMoneyApi")
    public ReceiveMoneyApi receiveMoneyApi() {
        return new ReceiveMoneyApi(apiClient());
    }
}
