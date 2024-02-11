package ru.jekkan.exchange_rate_bote.service;

import ru.jekkan.exchange_rate_bote.exception.ServiceException;

public interface ExchangeRatesService {

    String getUSDExchangeRate() throws ServiceException;

    String getEURExchangeRate() throws ServiceException;
}
