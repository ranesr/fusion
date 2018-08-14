//  The MIT License
//
//  Copyright © 2018 Saurabh Rane
//
//  Permission is hereby granted, free of charge, to any person obtaining a copy
//  of this software and associated documentation files (the "Software"), to deal
//  in the Software without restriction, including without limitation the rights
//  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//  copies of the Software, and to permit persons to whom the Software is
//  furnished to do so, subject to the following conditions:
//
//  The above copyright notice and this permission notice shall be included in all
//  copies or substantial portions of the Software.
//
//  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//  SOFTWARE.

package com.yelp.model.parameters;

import com.yelp.services.YelpApi;
import lombok.Data;

import com.yelp.exception.InvalidParameterException;
import com.yelp.exception.NullParameterException;

import org.apache.commons.lang3.StringUtils;

@Data
public class BusinessMatchesParameters implements Parameters {
    private static final String DEFAULT_MATCH_THRESHOLD = "default";

    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String country;
    private Double latitude;
    private Double longitude;
    private String phone;
    private String zipCode;
    private String yelpBusinessId;
    private Integer limit;
    private String matchThreshold;

    public String getParameters() throws NullParameterException, InvalidParameterException {
        StringBuilder builder = new StringBuilder("?");

        if (StringUtils.isBlank(name)) {
            throw new NullParameterException("name cannot be null or blank for /businesses/matches endpoint.");
        }
        builder.append("&name=").append(name);

        if (StringUtils.isBlank(address1)) {
            throw new NullParameterException("address1 cannot be null or blank for /businesses/matches endpoint.");
        }
        builder.append("&address1=").append(address1);

        if (!StringUtils.isBlank(address2)) {
            builder.append("&address2=").append(address2);
        }
        if (!StringUtils.isBlank(address3)) {
            builder.append("&address3=").append(address3);
        }

        if (StringUtils.isBlank(city)) {
            throw new NullParameterException("city cannot be null or blank for /businesses/matches endpoint.");
        }
        builder.append("&city=").append(city);

        if (StringUtils.isBlank(state)) {
            throw new NullParameterException("state cannot be null or blank for /businesses/matches endpoint.");
        }
        builder.append("&state=").append(state);

        if (StringUtils.isBlank(country)) {
            throw new NullParameterException("country cannot be null or blank for /businesses/matches endpoint.");
        }
        builder.append("&country=").append(country);

        if (latitude != null) {
            if (latitude < -90 || latitude > 90) {
                throw new InvalidParameterException("Please input the correct parameter value for latitude in " +
                        YelpApi.BUSINESSES_MATCHES_ENDPOINT + " endpoint.");
            }
            builder.append("&latitude=").append(latitude);
        }

        if (longitude != null) {
            if (longitude < -180 || longitude > 180) {
                throw new InvalidParameterException("Please input the correct parameter value for longitude in " +
                        YelpApi.BUSINESSES_MATCHES_ENDPOINT + " endpoint.");
            }
            builder.append("&longitude=").append(longitude);
        }

        if (!StringUtils.isBlank(phone)) {
            builder.append("&phone=").append(phone);
        }

        if (!StringUtils.isBlank(zipCode)) {
            builder.append("&zip_code=").append(zipCode);
        }

        if (!StringUtils.isBlank(yelpBusinessId)) {
            builder.append("&yelp_business_id=").append(yelpBusinessId);
        }

        if (limit != null) {
            if (limit > 10) {
                throw new InvalidParameterException("Please input the correct parameter value for limit in " +
                        YelpApi.BUSINESSES_MATCHES_ENDPOINT + " endpoint.");
            }
            builder.append("&limit=").append(limit);
        }

        if (StringUtils.isBlank(matchThreshold)) {
            builder.append("&match_threshold=").append(DEFAULT_MATCH_THRESHOLD);
        } else {
            builder.append("&match_threshold=").append(matchThreshold);
        }

        return builder.toString();
    }
}
