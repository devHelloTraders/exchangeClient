// com.traders.exchange.domain.TradeRequest
package com.traders.exchange.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record TradeRequest(
    Double lotSize,
    OrderType orderType,
    OrderCategory orderCategory,
    Long stockId,
    Double askedPrice,
    Double stopLossPrice,
    Double targetPrice,
    OrderValidity orderValidity
) {

}