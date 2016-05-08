package com.clw.romannumerals;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.clw.converter.Converter;
import com.clw.converter.ConverterFactory;

@Path("/romannumerals")
public class RomanNumeralsRestService {

    private Converter romanConvertor;
    

    public RomanNumeralsRestService() {
        this.romanConvertor = ConverterFactory.getRomanConvertor();
    }
    
    
    @GET
	@Path("{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public RomanNumeralBean fromArabicToRomanParam(@PathParam("id") int id) {
    	RomanNumeralBean romannum = new RomanNumeralBean(id, romanConvertor.convert(id+""));
    	return romannum;
	}
}
