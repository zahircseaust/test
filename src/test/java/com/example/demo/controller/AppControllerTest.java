package com.example.demo.controller;

import com.example.demo.Calculator;
import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

    class AppControllerTest {
    @Test
    void testSum() {
        int expectedValue = 15;
        Calculator calculator = new Calculator();
        int desValue = calculator.addValue(10, 5);
        assertThat(expectedValue).isEqualTo(desValue);
    }
    }

 @PostMapping()
 ResponseWithPagination<List<PolicyModel>> getAllPolicy(@RequestBody @Valid PolicyListingRequestModel policyListingRequestModel) {

        try {

            ListingModel<List<PolicyModel>> policies = policyService.getAllPolicy(policyListingRequestModel);
            Pagination pagination = new Pagination(policyListingRequestModel.getPageNo(), NumberUtils.parseInt(policies.getCount())/policyListingRequestModel.getPerPage(), policyListingRequestModel.getPerPage());

            return new ResponseWithPagination.Builder<List<PolicyModel>>()
                    .setData(policies.getData())
                    .setPagination(pagination)
                    .build();

        } catch (Exception e) {

            return new ResponseWithPagination.Builder<List<PolicyModel>>()
                    .setMessage("No Policy Found !!")
                    .setData(new ArrayList<>())
                    .setStatus(false)
                    .build();

        }

    }

