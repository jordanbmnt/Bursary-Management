package com.bbd.bursary.manager.Controller;


import com.bbd.bursary.manager.Model.FundAllocation;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundAllocationController {


    @PatchMapping("/fundAllocation")
    public void patchFunds(@RequestBody final FundAllocation fundAllocation) {
        System.out.println(fundAllocation);
    }
}
