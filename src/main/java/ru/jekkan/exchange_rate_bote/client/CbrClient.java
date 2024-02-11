package ru.jekkan.exchange_rate_bote.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.jekkan.exchange_rate_bote.exception.ServiceException;

import java.io.IOException;

@Component
public class CbrClient {

    @Autowired
    private OkHttpClient client;

    @Value("${cbr.currency.rates.xml.url}")
    private String url;

    public String getCurrencyRatesXML() throws ServiceException {
        var request = new Request.Builder()
                .url(url)
                .build();

        try(var responce = client.newCall(request).execute();){
            var body = responce.body();
            return body == null ? null : body.string();
        }catch (IOException e){
            throw new ServiceException("Ошибка получения курсов валют! ", e);
        }
    }
}

