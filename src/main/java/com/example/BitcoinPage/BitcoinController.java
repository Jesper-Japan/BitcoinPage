package com.example.BitcoinPage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BitcoinController {


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/bitcoinPage")
    public String hello() {
        return "This is the bitcoin page. This will be the home of various relevant information of bitcoin";
    }

    @GetMapping("/bitcoinAverageValue")
    public String bitcoinAverageValue(@RequestParam(value = "amountAveragedOver", defaultValue = "100") String amountAveragedOver) {
        BitcoinAverageDTO response = BitfinexCommunication.getBitcoinAveragePrice(Integer.parseInt(amountAveragedOver));
        if(response != null) {
            return String.format("The average price of bitcoin from the most recent %d transactions is %d", response.getAmountAveragedOver(), response.getAverage());
        }
        return "An error occurred";
    }

}
