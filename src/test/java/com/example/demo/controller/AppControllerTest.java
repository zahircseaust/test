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


 @Test
    void getAllPolicy(){
                ArrayList<String> dates = new ArrayList<>();
                dates.add("2014-03");
                PolicyListingRequestModel policyListingRequestModel = new PolicyListingRequestModel(
                "",
                "",
                new ArrayList<String>(dates),
                "",
                1,
                10,
                1
        );
//        ResponseWithPagination<List<PolicyModel>> policyList = new ResponseWithPagination<>();
                PolicyModel policyModel = new PolicyModel(
                "2296407",
                "BEGUM, JAMILA",
                "",
                42,
                6182.00,
                DateUtils.parse("28-Mar-2014", DateUtils.FORMAT_DD_MMM_YYYY)
        );
        ListingModel<List<PolicyModel>> policies = new ListingModel<>();
        policies.getData().add(policyModel);



        when(policyService.getAllPolicy(any())).thenReturn(policies);

        ResponseWithPagination<List<PolicyModel>> actualResponse = policyController.getAllPolicy(policyListingRequestModel);
        assert actualResponse != null;

        Assertions.assertEquals(policies.getData().stream().map(p->p.getPolicyNumber()).collect(Collectors.toList()), actualResponse.getData().stream().map(p -> p.getPolicyNumber()).collect(Collectors.toList()));
   }

