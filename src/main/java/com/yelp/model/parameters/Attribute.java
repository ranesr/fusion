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

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Attribute {
    HOT_AND_NEW("hot_and_new"),
    REQUEST_A_QUOTE("request_a_quote"),
    RESERVATION("reservation"),
    WAITLIST_RESERVATION("waitlist_reservation"),
    CASHBACK("cashback"),
    DEALS("deals"),
    GENDER_NEUTRAL_RESTROOMS("gender_neutral_restrooms");

    @Getter
    private String value;

    @JsonCreator
    public static Attribute attributes(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        for (Attribute attribute: values()) {
            if (value.equals(attribute.getValue())) {
                return attribute;
            }
        }
        throw new IllegalArgumentException();
    }
}
