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
public enum  Locale {
    // Czech Republic, Czech
    CS_CZ("cs_CZ"),

    // Denmark, Danish
    DA_DK("da_DK"),

    // Austria, German
    DE_AT("de_AT"),

    // Switzerland, German
    DE_CH("de_CH"),

    // Germany, German
    DE_DE("de_DE"),

    // Australia, English
    EN_AU("en_AU"),

    // Belgium, English
    EN_BE("en_BE"),

    // Canada, English
    EN_CA("en_CA"),

    // Switzerland, English
    EN_CH("en_CH"),

    // United Kingdom, English
    EN_GB("en_GB"),

    // Hong Kong, English
    EN_HK("en_HK");

    @Getter
    private String value;

    @JsonCreator
    public static Locale locale(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        for (Locale locale: values()) {
            if (value.equals(locale.getValue())) {
                return locale;
            }
        }
        throw new IllegalArgumentException();
    }
}
