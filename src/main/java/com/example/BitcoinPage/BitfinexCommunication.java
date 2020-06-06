package com.example.BitcoinPage;

import org.apache.commons.io.IOUtils;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;


import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class BitfinexCommunication {

    public final static String BITFINEX_BITCOIN_AVERAGE_URL = "https://api.bitfinex.com/v2/calc/trade/avg?symbol=tBTCUSD&amount=";

    public static BitcoinAverageDTO getBitcoinAveragePrice (int amountOfTransactions) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(BITFINEX_BITCOIN_AVERAGE_URL + amountOfTransactions);

        try {
            CloseableHttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                InputStream inStream = entity.getContent();
                StringWriter writer = new StringWriter();
                IOUtils.copy(inStream, writer, "UTF-8");
                String responseString = writer.toString().toString();
                String[] responseValues = responseString.replace("[","").replace("]", "").split(",");
                return new BitcoinAverageDTO(Long.parseLong(responseValues[0]), Integer.parseInt(responseValues[1]));
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return new BitcoinAverageDTO(0, 0);
    }
}
