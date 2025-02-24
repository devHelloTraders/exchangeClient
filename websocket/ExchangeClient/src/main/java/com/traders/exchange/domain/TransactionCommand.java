package com.traders.exchange.domain;

public sealed interface TransactionCommand {
    record PlaceBuy(TradeRequest request, long transactionId) implements TransactionCommand {}
    record PlaceSell(TradeRequest request, long transactionId) implements TransactionCommand {}
    record UpdateStatus(long transactionId, TransactionStatus status, double price) implements TransactionCommand {}
}