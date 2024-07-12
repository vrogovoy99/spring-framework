package com.cydeo.service.impl;

import com.cydeo.client.CountryClient;
import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.country.CountryResponse;
import com.cydeo.entity.Address;
import com.cydeo.exception.NotFoundException;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final CountryClient countryClient;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, CountryClient countryClient) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.countryClient = countryClient;
    }

    @Override
    public AddressDTO findByAddressNo(String addressNo) {

        Address foundAddress = addressRepository.findByAddressNo(addressNo)
                .orElseThrow(() -> new NotFoundException("No Address Found!"));

        AddressDTO addressDTO = mapperUtil.convert(foundAddress, new AddressDTO());

        addressDTO.setCurrency(getCurrencyApi(addressDTO.getCountry()));

        return addressDTO;
    }

    private String getCurrencyApi(String country) {

        // call countryClient.getCountryInfo API, pass country, retrieve JSON array of countries converted to list of CountryResponse
        List<Map<String,Object>> countryInfo = countryClient.getCountryInfo(country);

        if (countryInfo==null) { return null; }

        Map<String,Object> currency = (Map<String,Object>) countryInfo.get(0).get("currencies");

        return currency.keySet().toString().replaceAll("\\[|\\]", "");


//        List<CountryResponse> countryInfo = countryClient.getCountryInfo(country);
//
//        if (countryInfo==null) { return null; }
//
//        return countryInfo.get(0).getCurrencies().getEur().getName();
    }

    @Override
    public AddressDTO update(String addressNo, AddressDTO address) {

        Address foundAddress = addressRepository.findByAddressNo(addressNo)
                .orElseThrow(() -> new NotFoundException("No Address Found!"));

        Address addressToUpdate = mapperUtil.convert(address, new Address());

        addressToUpdate.setAddressNo(addressNo);
        addressToUpdate.setId(foundAddress.getId());

        Address updatedAddress = addressRepository.save(addressToUpdate);

        return mapperUtil.convert(updatedAddress, new AddressDTO());

    }
}
